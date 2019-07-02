package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Builder(builderMethodName = "createBuilder")
@Getter
@Table(name = "provider_user")
@AllArgsConstructor
public class ProviderUser {
    @NotNull
    @Id
    private Long id;

    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Setter
    @Column(name = "passwd")
    private String passWd;

    @NotNull
    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "zipcode")
    private String zipCode;

    private String address;

    @NotNull
    @Column(name = "detailed_address")
    private String detailedAddress;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    private boolean status;

    private ProviderUser() {
        this.regDate = DateConverter.getNowDate();
        this.status = true;
    }

}

