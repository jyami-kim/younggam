package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE AND reg_date = #{regDate};")
    Optional<List<Product>> findAllByRegDate(@Param("regDate") final String regDate);

    @Select("SELECT * FROM product AS p INNER JOIN today_product AS tp ON p.id = tp.product_id WHERE tp.provider_id = #{providerId} AND tp.reg_date = #{regDate}")
    List<Product> findByTodayProduct(@Param("providerId") final Long providerId, @Param("regDate") final String regDate);
}
