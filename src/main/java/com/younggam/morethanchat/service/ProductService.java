package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.dto.product.ProductResDto;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.dto.product.TodayProductReqDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.dto.product.ProductSaveReqDto.DEFAULT_IMAGE;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_PRODUCT;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FileUploadService fileUploadService;

    @Transactional
    public Long saveStoreProduct(ProductSaveReqDto productSaveReqDto, Long providerId) throws IOException {

        if (productSaveReqDto.getImageFile() != null)
            productSaveReqDto.setImage(fileUploadService.upload(productSaveReqDto.getImageFile()));
        else
            productSaveReqDto.setImage(DEFAULT_IMAGE);

        Product product = productSaveReqDto.toEntity(providerId);

        product = productRepository.save(product);

        return product.getId();
    }

    public List<ProductResDto> getStoreProduct(Long providerId) {
        List<Product> products = productRepository.findByProviderId(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_PRODUCT));

        return products.stream()
                .map(ProductResDto::new)
                .collect(Collectors.toList());
    }

//    public String saveTodayProduct(Long providerId, TodayProductReqDto todayProductReqDto){
//
//    }

}
