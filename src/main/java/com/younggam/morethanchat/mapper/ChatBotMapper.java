package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Mapper
public interface ChatBotMapper {

    @Select("SELECT * FROM chatbot WHERE provider_id = #{providerId} AND category = #{category};")
    Optional<ChatBot> findByCategoryAndProviderUser(@Param("category") final String category, @Param("providerId") final Long providerId);

//
//    @Insert("INSERT ")
//    ChatBot save(@Param("chatBot") final ChatBot chatBot);
}
