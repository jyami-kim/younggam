package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    @Select("SELECT * FROM chat_message WHERE chatroom_code LIKE #{chatRoomCode} ORDER BY id ASC;")
    List<ChatMessage> getChatMessages(@Param("chatRoomCode") final String chatRoomCode);

    @Select("SELECT COUNT(*) FROM chatroom WHERE chatroom_code LIKE #{chatRoomCode} AND provider_id = #{providerId};")
    Integer canAccessChatBot(@Param("chatRoomCode") final String chatRoomCode, @Param("providerId") final Long providerId);
}
