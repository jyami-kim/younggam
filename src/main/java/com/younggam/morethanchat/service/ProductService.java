package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.younggam.morethanchat.dto.product.ProductSaveReqDto.DEFAULT_IMAGE;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FileUploadService fileUploadService;

    public Long saveStoreProduct(ProductSaveReqDto productSaveReqDto, Long providerId) throws IOException {

        if (productSaveReqDto.getImageFile() != null)
            productSaveReqDto.setImage(fileUploadService.upload(productSaveReqDto.getImageFile()));
        else
            productSaveReqDto.setImage(DEFAULT_IMAGE);

        Product product = productSaveReqDto.toEntity(providerId);

        product = productRepository.save(product);

        return product.getId();
    }

}
