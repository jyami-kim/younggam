package com.younggam.morethanchat.dto.paymentService;

import com.younggam.morethanchat.domain.PaymentManagement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@AllArgsConstructor
@Getter
public class PaymentManagementReqDto {

    private int storeType;
    private int servicePeriod;
    private int totalAmount;
    private int coupon;
    private String paymentMethod;

    public PaymentManagement toEntity(Long providerId) {
        checkValidTotalAmount();

        return PaymentManagement.builder()
                .providerId(providerId)
                .coupon(this.coupon)
                .storeType(this.storeType)
                .servicePeriod(this.servicePeriod)
                .totalAmount(this.totalAmount)
                .paymentMethod(this.paymentMethod)
                .regDate(getNowAllDate())
                .build();
    }

    private void checkValidTotalAmount() {

        int month = PaymentGroupServicePeriod.findBySelectNum(this.servicePeriod).getMonth();
        int discountRate = PaymentGroupCoupon.findBySelectNum(this.coupon).getDiscountRate();
        int monthMoney = PaymentGroupStoreType.findBySelectNum(this.storeType).getMonthMoney();


        /**
         * 정책에 따라 가격체크 로직
         */

//        double amount = (monthMoney * month) * (100 - discountRate) * 0.01;
//
//        if (amount != this.totalAmount)
//            throw new NotValidateTypeException(INVALID_TOTAL_AMOUNT);

    }
}
