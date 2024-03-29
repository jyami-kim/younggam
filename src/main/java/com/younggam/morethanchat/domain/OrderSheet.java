package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "order_management")
@AllArgsConstructor
public class OrderSheet {
    @NotNull
    private Long id;
    @NotNull
    @Column(name = "chatroom_code")
    private String chatroomCode;
    @NotNull
    @Column(name = "total_payment")
    private int totalPayment;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "remitter_name")
    private String remitterName;
}