package com.younggam.morethanchat.dto.chatBot;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.domain.ChatType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class ChatBotMessageReserveResDto {

    private List<ChatType> reserveMessage;

    public ChatBotMessageReserveResDto() {
        this.reserveMessage = ChatCategory.RESERVE_1.getCategoryTypes().stream()
                .map(c -> ChatType.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .build())
                .collect(Collectors.toList());
    }

    public ChatBotMessageReserveResDto(List<ChatBot> chatBots) {
        this.reserveMessage = chatBots.stream()
                .map(c -> ChatType.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ChatBot> toDefaultEntity(Long providerId) {
        return ChatCategory.RESERVE_1.getCategoryTypes().stream()
                .map(c -> ChatBot.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .providerId(providerId)
                        .build()
                ).collect(Collectors.toList());
    }

    private void checkCategoryValid() {

    }

}
