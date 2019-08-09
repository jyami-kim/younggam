package com.younggam.morethanchat.dto.paymentService;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.Getter;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_SELECT;

@Getter
public enum PaymentGroupCoupon {

    OUT(0, 0),
    WELCOME(1, 5),
    INTERVIEWEE(2, 30);

    private int selectNumber;
    private int discountRate;

    PaymentGroupCoupon(int selectNumber, int discountRate) {
        this.selectNumber = selectNumber;
        this.discountRate = discountRate;
    }

    public static PaymentGroupCoupon findBySelectNum(int number) {
        return Arrays.asList(PaymentGroupCoupon.values()).stream()
                .filter(x -> x.getSelectNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(INVALID_SELECT));
    }

}
