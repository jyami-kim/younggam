package com.younggam.morethanchat.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public class ChatMessageReplyReqDto {
    private String replyMessage;
    private String chatRoomCode;
    @Setter
    private String regDate;
    private Long customerId;
}