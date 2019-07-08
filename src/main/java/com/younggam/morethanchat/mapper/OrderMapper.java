package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.Product;
import com.younggam.morethanchat.dto.order.OrderManageResDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM product WHERE AND reg_date = #{regDate};")
    Optional<List<Product>> findAllByRegDate(@Param("regDate") final String regDate);

    @Select("SELECT cu.name, cu.phone_num, om.pickup_time, os.total_payment, os.payment_method, om.order_status, GROUP_CONCAT(p.name SEPARATOR ',') AS productList, GROUP_CONCAT(od.amount) AS amountList " +
            "FROM chatroom AS cr INNER JOIN order_sheet AS os ON cr.chatroom_code=os.chatroom_code " +
            "INNER JOIN order_management AS om ON os.id = om.order_id " +
            "INNER JOIN customer_user AS cu ON cu.id = cr.customer_id " +
            "INNER JOIN order_detail AS od ON os.id = od.order_id " +
            "INNER JOIN product AS p ON p.id = od.product_id " +
            "WHERE cr.provider_id = 2 AND om.pickup_date LIKE '20190703' GROUP BY od.order_id;")
    List<OrderManageResDto> getMainPage(@Param("providerId") final Long providerId, @Param("pickupDate") final String pickupDate);


}
