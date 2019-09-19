package com.younggam.morethanchat.dto.store.restDate;

import com.younggam.morethanchat.domain.RestDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestDateReasonReqDto {
    private String date;
    private int number;
    private String detail;

    public RestDate toEntity(Long providerId) {
        RestReason.validateReasonNumber(number);
        return RestDate.builder()
                .providerId(providerId)
                .date(this.date)
                .reason(this.number)
                .detail(this.detail)
                .build();

    }
}
