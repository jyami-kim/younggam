package com.younggam.morethanchat.dto.paymentService;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.Getter;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_SELECT;

@Getter
public enum PaymentGroupStoreType {

    MACARON(1, "마카롱", 10000),
    BEAUTY(2, "뷰티/살롱", 10000),
    HEALTH(3, "헬스장", 10000 );

    private int selectNumber;
    private String business;
    private int monthMoney;

    PaymentGroupStoreType(int selectNumber, String business, int monthMoney) {
        this.selectNumber = selectNumber;
        this.business = business;
        this.monthMoney = monthMoney;
    }

    public static PaymentGroupStoreType findBySelectNum(int number) {
        return Arrays.asList(PaymentGroupStoreType.values()).stream()
                .filter(x -> x.getSelectNumber() == number)
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(INVALID_SELECT));
    }


}
