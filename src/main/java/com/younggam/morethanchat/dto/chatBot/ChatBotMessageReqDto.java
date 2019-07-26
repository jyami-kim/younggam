package com.younggam.morethanchat.dto.chatBot;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.domain.ChatType;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class ChatBotMessageReqDto {

    private List<ChatType> chatTypes;

    public void checkValidCategory(ChatCategory chatCategory) {
        if (this.chatTypes.size() != chatCategory.getSize()) {
            throw new NotValidateTypeException(ResponseMessage.INVALID_CATEGORY_TYPE);
        }
        for (ChatType chatType : chatTypes) {
            chatCategory.findByCategory(chatType.getCategory());
        }
    }

    public List<ChatBot> toDefaultEntity(Long providerId, ChatCategory chatCategory) {
        checkValidCategory(chatCategory);

        return this.chatTypes.stream()
                .map(c -> ChatBot.builder()
                        .category(c.getCategory())
                        .message(c.getMessage())
                        .providerId(providerId)
                        .build()
                ).collect(Collectors.toList());
    }
}
