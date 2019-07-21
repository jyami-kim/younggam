package com.younggam.morethanchat.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TodayProductReqDto {
    private List<Long> productIds;
    private String regDate;
}
