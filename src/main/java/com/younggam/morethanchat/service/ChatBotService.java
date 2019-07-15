package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveReqDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveResDto;
import com.younggam.morethanchat.mapper.ChatBotMapper;
import com.younggam.morethanchat.repository.ChatBotRepository;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {

    private final ChatBotMapper chatBotMapper;
    private final ChatBotRepository chatBotRepository;

    @Transactional
    public ChatBotMessageSaveResDto saveChatBotMessage(Long providerId, ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
//        ChatBot providerUser = chatBotRepository.findById(providerId)
//                .orElseThrow(() -> new NotFoundException(NOT_FOUND_CHATBOT));

        ChatCategory chatCategory = ChatCategory.find(chatBotMessageSaveReqDto.getCategory());

        ChatBot chatBot = chatBotMapper
                .findByCategoryAndProviderUser(chatCategory.getCategoryType(), providerId);

        if (chatBot != null) {
            chatBot.setMessage(chatBotMessageSaveReqDto.getMessage());
        } else {
            chatBot = chatBotMessageSaveReqDto.toEntity(providerId);
        }

        log.info(chatBot.getCategory());
        log.info(chatBot.getMessage());

        chatBot = chatBotRepository.save(chatBot);

        return ChatBotMessageSaveResDto.builder()
                .category(chatBot.getCategory())
                .id(chatBot.getId())
                .build();
    }

}
