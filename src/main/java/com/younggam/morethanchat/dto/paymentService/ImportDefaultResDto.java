package com.younggam.morethanchat.dto.paymentService;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ImportDefaultResDto {
    private int code;
    private String message;
    private ImportTokenDto response;
}
