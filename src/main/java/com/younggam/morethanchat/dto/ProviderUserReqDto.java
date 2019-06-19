package com.younggam.morethanchat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProviderUserReqDto {
    private String email;
    private String passwd;
    private String name;
    private String phoneNum;
    private String zipcode;
    private String address;
    private String detailedAddress;
}
