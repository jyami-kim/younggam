package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "order_detail")
@AllArgsConstructor
public class OrderDetail {
    @NotNull
    private Long id;
    @NotNull
    @Column(name = "order_id")
    private String orderId;
    @NotNull
    @Column(name = "product_id")
    private String productId;
    @NotNull
    private int amount;
    @NotNull
    private int payment;
}
