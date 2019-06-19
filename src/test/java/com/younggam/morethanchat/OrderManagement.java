package com.younggam.morethanchat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class OrderManagement {
    @Id
    @Column(name="chatroom_code")
    private String chatRoomCode;

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
