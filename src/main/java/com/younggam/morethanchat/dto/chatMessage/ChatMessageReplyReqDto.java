package com.younggam.morethanchat.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@Getter
@Slf4j
@AllArgsConstructor
public class ChatMessageReplyReqDto {
    private String replyMessage;
    private String chatRoomCode;
    private String regDate;
    private Long customerId;

    private ChatMessageReplyReqDto() {
        regDate = getNowAllDate();
    }
}
