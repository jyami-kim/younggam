package com.younggam.morethanchat.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageReplyReqDto {
    private String replyMessage;
    private String chatRoomCode;

}
