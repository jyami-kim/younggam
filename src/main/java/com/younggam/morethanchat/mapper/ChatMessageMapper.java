package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ChatMessage;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageReplyReqDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    @Select("SELECT * FROM chat_message WHERE chatroom_code LIKE #{chatRoomCode} ORDER BY id ASC;")
    List<ChatMessage> getChatMessages(@Param("chatRoomCode") final String chatRoomCode);

    @Select("SELECT COUNT(*) FROM chatroom WHERE chatroom_code LIKE #{chatRoomCode} AND providerId = #{providerId};")
    Integer canAccessChatBot(@Param("chatRoomCode") final String chatRoomCode, @Param("providerId") final Long providerId);

    @Insert("INSERT INTO chat_message(chatroom_code, writer, chat_message, written_date) " +
            "VALUES (#{chatMessageReplyReqDto.chatRoomCode}, false," +
            " #{chatMessageReplyReqDto.replyMessage}, #{chatMessageReplyReqDto.regDate});")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long saveChatMessage(@Param("chatMessageReplyReqDto")ChatMessageReplyReqDto chatMessageReplyReqDto);
}
