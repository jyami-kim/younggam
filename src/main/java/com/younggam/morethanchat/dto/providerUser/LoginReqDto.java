package com.younggam.morethanchat.dto.providerUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginReqDto {
    private String email;
    private String passWd;
}
