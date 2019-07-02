package com.younggam.morethanchat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderManagement {

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private OrderSheet orderId;

    @Column(name="pickup_date")
    private String pickUpDate;

    @Column(name="pickup_time")
    private String pickUpTime;

    @Column(name ="require_wrapping")
    private String requireWrapping;

    @Column(name="require_ect")
    private String requireEct;

    @Column(name="order_status")
    private int orderStatus;

    @Column(name="reg_date")
    private String regDate;
}
