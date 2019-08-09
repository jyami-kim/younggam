package com.younggam.morethanchat.dto.paymentService;

import com.younggam.morethanchat.domain.PaymentManagement;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_TOTAL_AMOUNT;
import static com.younggam.morethanchat.utils.TypeConverter.getCalculateDate;
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
                .storeType(this.storeType)
                .servicePeriod(this.servicePeriod)
                .totalAmount(this.coupon)
                .paymentMethod(this.paymentMethod)
                .payDate(getNowAllDate())
                .dueDate(getCalculatedDueDate())
                .build();
    }

    private void checkValidTotalAmount() {

        int month = PaymentGroupServicePeriod.findBySelectNum(this.servicePeriod).getMonth();
        int discountRate = PaymentGroupCoupon.findBySelectNum(this.coupon).getDiscountRate();
        int monthMoney = PaymentGroupStoreType.findBySelectNum(this.storeType).getMonthMoney();

        if (monthMoney * month - discountRate != this.totalAmount)
            throw new NotValidateTypeException(INVALID_TOTAL_AMOUNT);

    }

    private String getCalculatedDueDate() {
        int month = PaymentGroupServicePeriod.findBySelectNum(this.servicePeriod).getMonth();
        return getCalculateDate(month);
    }
}
