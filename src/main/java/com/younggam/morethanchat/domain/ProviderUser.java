package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.dto.ProviderUserReqDto;
import com.younggam.morethanchat.utils.DateConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
public class ProviderUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String reqDate;

    private String name;

    private String passwd;

    private String phoneNum;

    private String zipcode;
    private String address;
    private String detailed_address;

    private int status;

    private ProviderUser() {
        this.reqDate = DateConverter.getNowDate();
        this.status = 1;
    }

    public static ProviderUser of(ProviderUserReqDto providerUserReqDto) {
        return new ProviderUser().builder()
                .email(providerUserReqDto.getEmail())
                .name(providerUserReqDto.getName())
                .passwd(providerUserReqDto.getPasswd())
                .address(providerUserReqDto.getAddress())
                .detailed_address(providerUserReqDto.getDetailedAddress())
                .phoneNum(providerUserReqDto.getDetailedAddress()).build();
    }

    public static ProviderUser of(ProviderUserReqDto providerUserReqDto, int status) {
        return ProviderUser.of(providerUserReqDto).builder()
                .status(status).build();
    }


}

