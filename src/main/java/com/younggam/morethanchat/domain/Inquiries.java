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
    @Column(name = "providerId")
    private Long providerId;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="inquiry")
    private String inquiry;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @Setter
    @Column(name="read_check")
    private boolean readCheck;

    private Inquiries() {
        this.regDate = getNowAllDate();
    }
}
