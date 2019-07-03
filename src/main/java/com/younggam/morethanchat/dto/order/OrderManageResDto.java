package com.younggam.morethanchat.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.annotations.Select;

@AllArgsConstructor
@Getter
@Builder
public class OrderManageResDto {
//    @Select("SELECT cu.name, cu.phone_num, om.pickup_time, os.total_payment, os.payment_method " ;
    private String name;
    private String phoneNum;
    private String pickupTime;
    private String totalPayment;
    private String paymentMethod;
}
