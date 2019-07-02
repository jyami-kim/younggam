package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.dto.product.ProductsByDateResDto;
import com.younggam.morethanchat.exception.EmptyException;
import com.younggam.morethanchat.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.PRODUCT_IS_EMPTY_IN_DATE;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public List<ProductsByDateResDto> getProductsByDateList(String date) {
        List<Product> allByRegDate = productMapper.findAllByRegDate(date)
                .orElseThrow(() -> new EmptyException(messageCode(PRODUCT_IS_EMPTY_IN_DATE, date)));

        return null;
        // TODO : return 부분 수정하기
    }
}
