package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
@Table(name = "order_management")
@AllArgsConstructor
public class OrderManagement {

    @NotNull
    @Column(name = "order_id")
    private Long orderId;
    @NotNull
    @Column(name = "pickup_date")
    private String pickupDate;
    @NotNull
    @Column(name = "pickup_time")
    private String pickupTime;
    @Column(name = "require_wrapping")
    private String requireWrapping;
    @Column(name = "require_ect")
    private String requireEct;
    @NotNull
    @Column(name = "order_status")
    private boolean orderStatus;
    @NotNull
    @Column(name = "reg_date")
    private String regDate;
}
