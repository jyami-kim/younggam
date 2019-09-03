package com.younggam.morethanchat.dto.paymentService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ImportPaymentReqDto {

    private int amount;
    private String status;
    private String name;

    private Boolean success;
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_msg")
    private String errorMessage;
//    @JsonProperty("imp_uid")
//    private String impUid;
//    @JsonProperty("merchant_uid")
//    private String merchantUid;
    @JsonProperty("pay_method")
    private String payMethod;
    @JsonProperty("pg_provider")
    private String pgProvider;
    @JsonProperty("pg_tid")
    private String pgTid;
    @JsonProperty("buyer_email")
    private String buyerEmail;
    @JsonProperty("buyer_name")
    private String buyerName;
    @JsonProperty("buyer_postcode")
    private String buyerPostCode;
    @JsonProperty("buyer_tel")
    private String buyerTel;
    @JsonProperty("buyer_addr")
    private String buyerAddress;
    @JsonProperty("custom_data")
    private Object customData;
    @JsonProperty("paid_at")
    private int paidAt;
    @JsonProperty("receipt_url")
    private String receiptUrl;

}
