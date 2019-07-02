package com.younggam.morethanchat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    private OrderSheet orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product productId;

    private int amount;
    private int payment;
}
