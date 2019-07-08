package com.younggam.morethanchat.dto.providerUser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderUserForgetEmailReqDto {
    private String name;
    private String phoneNum;
}
