package com.younggam.morethanchat.dto;

import lombok.Value;

@Value
public class TokenDto {
    private String token;
    private TokenDto(String token){
        this.token = token;
    }
    public static TokenDto of(String token){
        return new TokenDto(token);
    }
}

