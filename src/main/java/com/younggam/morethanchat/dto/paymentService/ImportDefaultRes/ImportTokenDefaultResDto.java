package com.younggam.morethanchat.dto.paymentService.ImportDefaultRes;

import com.younggam.morethanchat.dto.paymentService.ImportTokenReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ImportTokenDefaultResDto extends ImportDefaultResDto {
    private ImportTokenReqDto response;
}
