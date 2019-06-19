package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.DateConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Builder(builderMethodName = "createBuilder")
@AllArgsConstructor
public class ProviderUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;

    @NotNull
    @Setter
    @Column(name = "passwd")
    private String passWd;

    @NotNull
    @Column(name="phone_num")
    private String phoneNum;

    @Column(name="zipcode")
    private String zipCode;

    private String address;

    @Column(name="detailed_address")
    private String detailedAddress;

    @Column(name="reg_date")
    private String regDate;

    private int status;

    private ProviderUser() {
        this.regDate = DateConverter.getNowDate();
        this.status = 1;
    }

}

