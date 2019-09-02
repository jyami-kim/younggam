package com.younggam.morethanchat.dto.paymentService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImportTokenDto {
    @JsonProperty("access_token")
    private String accessToken;
    private Long now;
    @JsonProperty("expired_at")
    private Long expiredAt;
}
