package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ProductService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.younggam.morethanchat.utils.ResponseMessage.IO_EXCEPTION;
import static com.younggam.morethanchat.utils.ResponseMessage.SAVE_PRODUCT;
import static com.younggam.morethanchat.utils.TypeConverter.stringToProductSaveReqDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth/product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final JwtFactory jwtFactory;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto saveBasicInformation(AuthTokenDto authTokenDto,
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

    private Long checkAuth(AuthTokenDto authTokenDto) {
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }

}
