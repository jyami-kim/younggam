package com.younggam.morethanchat.dto.chatMessage;

import com.younggam.morethanchat.domain.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ChatMessageShowResDto {
    private boolean writer;
    private String chatMessage;
    private String writtenDate;

    public ChatMessageShowResDto(ChatMessage chatMessage){
        this.chatMessage = chatMessage.getChatMessage();
        this.writtenDate = chatMessage.getWrittenDate();
        this.writer = chatMessage.getWriter();
    }
}
