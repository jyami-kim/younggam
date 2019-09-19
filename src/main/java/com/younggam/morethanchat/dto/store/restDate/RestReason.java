package com.younggam.morethanchat.dto.store.restDate;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.Getter;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_SELECT;

@Getter
public enum RestReason {
    HOLIDAY(1, "공휴일"),
    REGULAR(2, "정기휴일"),
    OTHER(3, "기타");

    private int number;
    private String content;

    RestReason(int number, String content) {
        this.number = number;
        this.content = content;
    }

    public static void validateReasonNumber(int number) {
        Arrays.stream(RestReason.values())
                .filter(x -> x.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(INVALID_SELECT));
    }
}
