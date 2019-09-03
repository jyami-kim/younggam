package com.younggam.morethanchat.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String id;

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
    private int coupon;

    @NotNull
    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Setter
    @Column(name = "pay_date")
    private String payDate;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @Setter
    @Column(name = "due_date")
    private String dueDate;
}
