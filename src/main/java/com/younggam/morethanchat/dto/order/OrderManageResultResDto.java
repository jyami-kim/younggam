package com.younggam.morethanchat.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class OrderManageResultResDto {
    private List<OrderManageResDto> orderManageResDtos;
    private int amountOrder;
    private int amountAsk;
    private int expectProfit;
}
