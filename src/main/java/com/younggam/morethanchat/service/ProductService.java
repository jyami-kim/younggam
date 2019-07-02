package com.younggam.morethanchat.service;

import com.younggam.morethanchat.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

//    public List<ProductsByDateResDto> getProductsByDateList(String date) {
//        List<Product> allByRegDate = productMapper.findAllByRegDate(date)
//                .orElseThrow(() -> new EmptyException(messageCode(PRODUCT_IS_EMPTY_IN_DATE, date)));
//
//        return allByRegDate;
//        // TODO : return 부분 수정하기
//    }
}
