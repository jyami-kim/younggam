package com.younggam.morethanchat.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.ByteArrayOutputStream;

@AllArgsConstructor
@Getter
@Builder
public class OrderManageResDto {

    private String chatroomCode;
    private Long customerId;
    private Long orderId;
    private String name;
    private String phoneNum;
    private String pickupTime;
    private int totalPayment;
    private String paymentMethod;
    private boolean orderStatus;
    private String productList;
    private String amountList;
    @Setter
    private boolean inquiries;


}
