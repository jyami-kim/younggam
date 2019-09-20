package com.younggam.morethanchat.dto.reservation;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.Getter;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_SELECT;

@Getter
public enum ReservationDetail {
    ALWAYS(1, "언제나 가능합니다."),
    NOW_IMPOSSIBLE(2, "당일취소는 안됩니다."),
    OTHER(3, "직접 지정");

    private int number;
    private String message;

    ReservationDetail(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public static void validateReasonNumber(int number) {
        Arrays.stream(ReservationDetail.values())
                .filter(x -> x.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(INVALID_SELECT));
    }
}
