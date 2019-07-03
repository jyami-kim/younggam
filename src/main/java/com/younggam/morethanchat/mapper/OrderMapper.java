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

    @Select("SELECT cu.name, cu.phone_num, om.pickup_time, os.total_payment, os.payment_method " +
            "FROM chatroom AS cr INNER JOIN order_sheet AS os ON cr.chatroom_code=os.chatroom_code " +
            "INNER JOIN order_management AS om ON os.id = om.order_id INNER JOIN customer_user AS cu ON cu.id = cr.customer_id " +
            "WHERE cr.provider_id = #{providerId} AND om.pickup_date LIKE #{pickupDate};")
    List<OrderManageResDto> getMainPage(@Param("providerId") final Long providerId, @Param("pickupDate") final String pickupDate);

}
