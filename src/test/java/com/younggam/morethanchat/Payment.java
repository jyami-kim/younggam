package com.younggam.morethanchat;

import com.younggam.morethanchat.domain.ProviderUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="payment_service")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "provider_id")

    private ProviderUser providerId;

    private String storeType;

    @Column(name="service_period")
    private String servicePeriod;

    @Column(name="total_amount")
    private int totalAmount;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="pay_date")
    private String payDate;

    @Column(name="due_date")
    private String dueDate;

}
