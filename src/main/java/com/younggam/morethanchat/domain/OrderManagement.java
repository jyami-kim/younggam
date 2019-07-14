package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
@Table(name = "order_management")
@AllArgsConstructor
@Entity
@Builder
public class OrderManagement {

    @NotNull
    @Id
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
    @NotNull
    @Setter
    @Column(name = "order_status")
    private boolean orderStatus;
    @NotNull
    @Column(name = "reg_date")
    private String regDate;
}
