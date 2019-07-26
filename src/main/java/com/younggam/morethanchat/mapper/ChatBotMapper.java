package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatBot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChatBotMapper {

    @Select("SELECT * FROM chatbot WHERE provider_id = #{providerId} AND category = #{category};")
    Optional<ChatBot> findByCategoryAndProviderUser(@Param("category") final String category, @Param("providerId") final Long providerId);

    @Select({"<script>",
            "SELECT *",
            "FROM chatbot",
            "WHERE provider_id = #{providerId} AND category IN",
            "<foreach item='item' index='index' collection='categories'",
            "open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"})
    List<ChatBot> findByCategoryListAndProviderUser(@Param("providerId") final Long providerId, @Param("categories") String[] categories);


//
//    @Insert("INSERT ")
//    ChatBot save(@Param("chatBot") final ChatBot chatBot);
}
