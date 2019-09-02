package com.younggam.morethanchat.dto.paymentService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PaymentSubmitReqDto {
    @JsonProperty(value = "imp_uid")
    private String impUid;
    @JsonProperty(value = "merchant_uid")
    private String merchantUid;
}
