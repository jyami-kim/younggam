package com.younggam.morethanchat.dto.chatBot;

import com.younggam.morethanchat.domain.ChatBot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ChatBotMessageSaveReqDto {

    private String category;
    private String message;

    //초기 등록시
    public ChatBot toEntity(Long providerId) {
        return ChatBot.builder()
                .providerId(providerId)
                .category(this.category)
                .message(this.message)
                .build();
    }

}
