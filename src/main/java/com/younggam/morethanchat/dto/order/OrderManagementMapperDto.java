package com.younggam.morethanchat.dto.order;

import com.younggam.morethanchat.domain.OrderManagement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter

public class OrderManagementMapperDto {

    private Long orderId;
    private String pickupDate;
    private String pickupTime;
    private String requireWrapping;
    @Setter
    private boolean orderStatus;
    private String regDate;

    public OrderManagement toEntity() {
        return OrderManagement.builder()
                .orderId(this.orderId)
                .pickupDate(this.pickupDate)
                .pickupTime(this.pickupTime)
                .requireWrapping(this.requireWrapping)
                .orderStatus(this.orderStatus)
                .regDate(this.regDate)
                .build();
    }
}
