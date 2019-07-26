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
public class ChatBotMessageResDto {

    private List<ChatType> chatTypes;

    public ChatBotMessageResDto(ChatCategory chatCategory) {
        this.chatTypes = chatCategory.getCategoryTypes().stream()
                .map(c -> ChatType.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .build())
                .collect(Collectors.toList());
    }

    public ChatBotMessageResDto(List<ChatBot> chatBots) {
        this.chatTypes = chatBots.stream()
                .map(c -> ChatType.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .build())
                .collect(Collectors.toList());
    }

}
