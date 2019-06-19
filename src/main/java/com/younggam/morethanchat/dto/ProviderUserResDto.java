package com.younggam.morethanchat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProviderUserResDto {
    private Long id;
    private String email;
    private String name;
    private String passwd;
    private String phoneNum;
    private String reqDate;
    private String zipcode;
    private String address;
    private String detailedAddress;
    private int status;
}
