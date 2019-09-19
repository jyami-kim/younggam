package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.RestDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RestDateMapper {

    @Select({"<script>",
            "SELECT * FROM chatbot WHERE provider_id = #{providerId} AND category IN",
            "<foreach item='item' index='index' collection='dates' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    List<RestDate> findByProviderIdAndRestDates(@Param("providerId") final Long providerId, @Param("dates") String[] dates);

}
