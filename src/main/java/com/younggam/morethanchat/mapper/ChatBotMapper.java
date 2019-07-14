package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatBot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatBotMapper {

    @Select("SELECT * FROM chatbot WHERE provider_id = #{providerId} AND category = #{category};")
    ChatBot findByCategoryAndProviderUser(@Param("category") final String category, @Param("providerId") final Long providerId);

//
//    @Insert("INSERT ")
//    ChatBot save(@Param("chatBot") final ChatBot chatBot);
}
