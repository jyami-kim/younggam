package com.younggam.morethanchat.dto;

import lombok.Value;

@Value
public class AuthTokenDto {

    private String token;

    private AuthTokenDto(String token) {
        this.token = token;
    }

    public static AuthTokenDto of(String token) {
        return new AuthTokenDto(token);
    }

}
