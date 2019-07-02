package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.dto.product.ProductsByDateResDto;
import com.younggam.morethanchat.exception.EmptyException;
import com.younggam.morethanchat.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import javax.xml.ws.ServiceMode;
import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.PRODUCT_IS_EMPTY_IN_DATE;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

@ServiceMode
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductsByDateResDto> getProductsByDateList(String date) {
        List<Product> allByRegDate = productRepository.findAllByRegDate(date)
                .orElseThrow(new EmptyException(messageCode(PRODUCT_IS_EMPTY_IN_DATE, date)));

    }
}
