package com.younggam.morethanchat.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.io.ByteArrayOutputStream;

@AllArgsConstructor
@Getter
@Builder
public class OrderManageResDto {
    private String name;
    private String phoneNum;
    private String pickupTime;
    private String totalPayment;
    private String paymentMethod;
    private int orderStatus;
    private String productList;
    private String amountList;
}
