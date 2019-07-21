package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.domain.TodayProduct;
import com.younggam.morethanchat.dto.product.ProductResDto;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.dto.product.TodayProductReqDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.ProductMapper;
import com.younggam.morethanchat.repository.ProductRepository;
import com.younggam.morethanchat.repository.TodayProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.dto.product.ProductSaveReqDto.DEFAULT_IMAGE;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_PRODUCT;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_TODAY_PRODUCT;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final TodayProductRepository todayProductRepository;
    private final FileUploadService fileUploadService;
    private final ProductMapper productMapper;

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


    @Transactional
    public void saveTodayProduct(Long providerId, TodayProductReqDto todayProductReqDto) {
        List<TodayProduct> previousTodayProduct =
                todayProductRepository.findAllByRegDateAndProviderId(todayProductReqDto.getRegDate(), providerId);

        ArrayList<Long> overlapValues = new ArrayList<>(todayProductReqDto.getProductIds());

        List<Long> collect = previousTodayProduct.stream()
                .map(TodayProduct::getProductId)
                .collect(Collectors.toList());

        overlapValues.retainAll(collect);

        List<TodayProduct> deleteList = previousTodayProduct.stream()
                .filter(p -> !overlapValues.contains(p.getProductId()))
                .collect(Collectors.toList());

        //로직
        todayProductReqDto.deleteOverLap(overlapValues);

        List<TodayProduct> saveList = todayProductReqDto.toEntityList(providerId);

        todayProductRepository.deleteAll(deleteList);
        todayProductRepository.saveAll(saveList);

    }

    public List<ProductResDto> getTodayStoreProduct(Long productId, String searchDate) {
        List<Product> products = productMapper.findByTodayProduct(productId, searchDate);
        if(products.isEmpty())
            throw new NotFoundException(NOT_FOUND_TODAY_PRODUCT);

        return products.stream()
                .map(ProductResDto::new)
                .collect(Collectors.toList());
    }

}
