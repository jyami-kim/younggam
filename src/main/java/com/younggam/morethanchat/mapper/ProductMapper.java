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

}
