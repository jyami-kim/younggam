package com.younggam.morethanchat.dto.chatMessage;

import com.younggam.morethanchat.domain.ChatMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@NoArgsConstructor
@Slf4j
public class ChatMessageShowResDto {
    private boolean writer;
    private String chatMessage;
    private String writtenDate;

    public ChatMessageShowResDto(ChatMessage chatMessage) {
        this.chatMessage = chatMessage.getChat_message();
        this.writtenDate = chatMessage.getWrittenDate();
        this.writer = chatMessage.getWriter();
    }
}
