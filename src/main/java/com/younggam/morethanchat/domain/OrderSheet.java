package com.younggam.morethanchat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order_management")
    @PrimaryKeyJoinColumn
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    private ChatRoom chatRoomCode;

    @Column(name="total_payment")
    private int totalPayment;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="remitter_name")
    private String remitterName;

}