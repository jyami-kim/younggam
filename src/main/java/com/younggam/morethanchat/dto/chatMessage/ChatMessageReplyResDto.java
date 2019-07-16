package com.younggam.morethanchat.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class ChatMessageReplyResDto {
    private Long chatMessageId;
    private Long inquiriesId;
    private Long inquiriesReplyId;
}
