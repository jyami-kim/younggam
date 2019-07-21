package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.product.ProductResDto;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ProductService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.*;
import static com.younggam.morethanchat.utils.TypeConverter.stringToProductSaveReqDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth/product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final JwtFactory jwtFactory;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto saveProduct(AuthTokenDto authTokenDto,
                                   @RequestPart String productSaveReqDtoString,
                                   @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
        Long providerId = checkAuth(authTokenDto);
        ProductSaveReqDto productSaveReqDto = stringToProductSaveReqDto(productSaveReqDtoString);

        if (imageFile != null)
            productSaveReqDto.setImageFile(imageFile);

        Long productId = null;
        try {
            productId = productService.saveStoreProduct(productSaveReqDto, providerId);
        } catch (IOException e) {
            return ResponseDto.of(HttpStatus.CONFLICT, IO_EXCEPTION, e.getCause());
        }

        return ResponseDto.of(HttpStatus.OK, SAVE_PRODUCT, productId);
    }

    @GetMapping()
    public ResponseDto getProductList(AuthTokenDto authTokenDto) {
        Long providerId = checkAuth(authTokenDto);
        List<ProductResDto> storeProduct = productService.getStoreProduct(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_PRODUCT_SUCCESS, storeProduct);
    }



    private Long checkAuth(AuthTokenDto authTokenDto) {
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }

}
