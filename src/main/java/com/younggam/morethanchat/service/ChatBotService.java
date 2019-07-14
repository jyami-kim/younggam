package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveReqDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.ChatBotMapper;
import com.younggam.morethanchat.repository.ChatBotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_CHATBOT;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {

    private final ChatBotMapper chatBotMapper;
    private final ChatBotRepository chatBotRepository;

    //TODO: 여기 providerID가 안먹음
    @Transactional
    public Long saveChatBotMessage(Long providerId, ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
        ChatBot providerUser = chatBotRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_CHATBOT));

        log.info(providerId+"");
        log.info(providerUser+"");

        Optional<ChatBot> previousCatBot = chatBotMapper
                .findByCategoryAndProviderUser(chatBotMessageSaveReqDto.getCategory(), providerId);

        if (previousCatBot.isPresent()) {
            previousCatBot.get().setMessage(chatBotMessageSaveReqDto.getMessage());
            return previousCatBot.get().getId();
        }

        ChatBot newChatBot = chatBotMessageSaveReqDto.toEntity(chatBotMessageSaveReqDto);
        newChatBot.validateCategory();
        newChatBot = chatBotRepository.save(newChatBot);
        return newChatBot.getId();
    }

}
