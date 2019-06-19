package com.younggam.morethanchat.dto.providerUser;

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
    private String passWd;
    private String phoneNum;
    private String reqDate;
    private String zipCode;
    private String address;
    private String detailedAddress;
    private int status;
}
