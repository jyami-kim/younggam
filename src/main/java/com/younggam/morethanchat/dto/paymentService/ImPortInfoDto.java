package com.younggam.morethanchat.dto.paymentService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class ImPortInfoDto {
    @JsonProperty("imp_key")
    private String key;
    @JsonProperty("imp_secret")
    private String secret;
}
