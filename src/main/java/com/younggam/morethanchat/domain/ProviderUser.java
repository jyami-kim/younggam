package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder(builderMethodName = "createBuilder")
@Getter
@Table(name = "provider_user")
@AllArgsConstructor
public class ProviderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "phone_num", unique = true)
    private String phoneNum;

//    @Column(name = "zipcode")
//    private String zipCode;
//
//    private String address;
//
//    @NotNull
//    @Column(name = "detailed_address")
//    private String detailedAddress;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @NotNull
    private int birth;

    @Column(name= "know_path")
    private String knowPath;

    private boolean status;

    private ProviderUser() {
        this.regDate = DateConverter.getNowAllDate();
        this.status = true;
    }

}

