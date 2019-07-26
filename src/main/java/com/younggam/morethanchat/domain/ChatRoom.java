package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "chatroom")
@AllArgsConstructor
public class ChatRoom {
    @Id
    @NotNull
    @Column(name = "chatroom_code")
    private String chatRoomCode;
    @NotNull
    @Column(unique = true, name = "customer_id")
    private Long customerId;
    @NotNull
    @Column(name = "providerId")
    private Long providerId;
    @NotNull
    @Column(name = "reg_date")
    private String regDate;
}
