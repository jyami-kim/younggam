package com.younggam.morethanchat.dto.chatBot;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Getter
@Slf4j
@NoArgsConstructor
public class ChatBotMessageSaveReqDto {

    private String category;
    private String message;

    //초기 등록시
    public ChatBot toEntity(ProviderUser providerUser) {
        return ChatBot.builder()
                .category(this.category)
                .message(this.message)
                .provider_id(providerUser.getId())
                .build();
    }


}
