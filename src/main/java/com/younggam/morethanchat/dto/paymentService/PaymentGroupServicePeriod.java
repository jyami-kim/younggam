package com.younggam.morethanchat.dto.paymentService;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.Getter;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_SELECT;

@Getter
public enum PaymentGroupServicePeriod {

    BASIC(1, 3, 0),
    PREMIUM(2, 9, 15000);

    private int selectNumber;
    private int month;
    private int discountMoney;

    PaymentGroupServicePeriod(int selectNumber, int month, int discountMoney) {
        this.selectNumber = selectNumber;
        this.month = month;
        this.discountMoney = discountMoney;
    }

    public static PaymentGroupServicePeriod findBySelectNum(int number) {
        return Arrays.asList(PaymentGroupServicePeriod.values()).stream()
                .filter(x -> x.getSelectNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(INVALID_SELECT));
    }

}
