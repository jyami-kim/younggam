package com.younggam.morethanchat;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="chatroom_code")
    private ChatRoom chatRoomCode;

    @Column(name="total_payment")
    private int totalPayment;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="remitter_name")
    private String remitterName;

}
