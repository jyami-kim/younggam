package com.younggam.morethanchat.dto.providerUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProviderUserForgetPassWdReqDto {
    private String email;
    private String phoneNum;
}
