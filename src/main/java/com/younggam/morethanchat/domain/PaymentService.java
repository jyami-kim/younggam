package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "payment_service")
@AllArgsConstructor
public class PaymentService {
    @NotNull
    private Long id;
    @NotNull
    @Column(name = "providerId")
    private Long providerId;
    @NotNull
    @Column(name = "store_type")
    private String storeType;
    @NotNull
    @Column(name = "service_period")
    private String servicePeriod;
    @NotNull
    @Column(name = "total_amount")
    private int totalAmount;
    @NotNull
    @Column(name = "payment_method")
    private String paymentMethod;
    @NotNull
    @Column(name = "pay_date")
    private String payDate;
    @NotNull
    @Column(name = "due_date")
    private String dueDate;
}
