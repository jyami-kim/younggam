package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "payment_management")
@AllArgsConstructor
@Entity
@Builder
public class PaymentManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "providerId")
    private Long providerId;

    @NotNull
    @Column(name = "store_type")
    private int storeType;

    @NotNull
    @Column(name = "service_period")
    private int servicePeriod;

    @NotNull
    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @NotNull
    @Column(name = "pay_date")
    private String payDate;

    @NotNull
    @Column(name = "due_date")
    private String dueDate;
}
