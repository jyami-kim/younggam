package com.younggam.morethanchat.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ChatMessageShowResDto {
    private Long id;
    private String chatroomCode;
    private boolean writer;
    private String chatMessage;
    private String writtenDate;
}
