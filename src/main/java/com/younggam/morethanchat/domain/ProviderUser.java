package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.dto.ProviderUserReqDto;
import com.younggam.morethanchat.dto.ProviderUserResDto;
import com.younggam.morethanchat.utils.DateConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ProviderUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String passwd;

    private String phoneNum;

    private String registerDate;

    private ProviderUser(String email, String passwd, String phoneNum){
        this.email = email;
        this.passwd = passwd;
        this.phoneNum = phoneNum;
        this.registerDate = DateConverter.getNowDate();
    }

    public static ProviderUser of(ProviderUserReqDto providerUserReqDto){
        return new ProviderUser(providerUserReqDto.getEmail(), providerUserReqDto.getPasswd(), providerUserReqDto.getPhoneNum());
    }
}

