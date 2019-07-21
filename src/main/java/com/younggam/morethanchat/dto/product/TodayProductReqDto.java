package com.younggam.morethanchat.dto.product;

import com.younggam.morethanchat.domain.TodayProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class TodayProductReqDto {
    private ArrayList<Long> productIds;
    private String regDate;

    public List<TodayProduct> toEntityList(Long providerId) {
        return this.productIds.stream()
                .map(p -> toEntity(p, providerId))
                .collect(Collectors.toList());
    }

    private TodayProduct toEntity(Long productId, Long providerId) {
        return TodayProduct.builder()
                .productId(productId)
                .regDate(this.regDate)
                .providerId(providerId)
                .build();
    }

    public void deleteOverLap(ArrayList<Long> overlaps) {
        this.productIds.removeAll(overlaps);
    }
}
