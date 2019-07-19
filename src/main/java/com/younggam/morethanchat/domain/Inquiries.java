package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@Getter
@Entity
@AllArgsConstructor
public class Inquiries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "provider_id")
    private Long providerId;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    private String inquiry;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @Setter
    private boolean read;

    private Inquiries() {
        this.regDate = getNowAllDate();
    }
}
