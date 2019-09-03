package com.younggam.morethanchat.dto.paymentService.ImportDefaultRes;

import com.younggam.morethanchat.dto.paymentService.ImportPaymentReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ImportPaymentDefaultReqDto extends ImportDefaultResDto {
    private ImportPaymentReqDto response;
}
