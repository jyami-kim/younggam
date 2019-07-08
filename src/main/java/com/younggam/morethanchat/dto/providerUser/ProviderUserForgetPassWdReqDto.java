package com.younggam.morethanchat.dto.providerUser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderUserForgetPassWdReqDto {
    private String email;
    private String phoneNum;
}
