package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "customer_user")
@AllArgsConstructor
public class CustomerUser {
    @NotNull
    private Long id;
    @Column(name = "device_id")
    private String deviceId;
    @NotNull
    @Column(name = "chatroom_code", unique = true)
    private String chatRoomCode;
    private String name;
    @Column(name = "phone_num")
    private String phoneNum;
    @NotNull
    @Column(name = "reg_date")
    private String regDate;
}
