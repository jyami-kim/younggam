package com.younggam.morethanchat.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ChatBotMessageSaveResDto {
    private String category;
    private Long id;
}
