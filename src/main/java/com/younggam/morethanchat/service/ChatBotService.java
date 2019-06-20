package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveReqDto;
import com.younggam.morethanchat.exception.NotFoundUserException;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.repository.ChatBotRepository;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {

    private final ChatBotRepository chatBotRepository;
    private final ProviderUserRepository providerUserRepository;

    @Transactional
    public Long saveChatBotMessage(Long providerId, ChatBotMessageSaveReqDto chatBotMessageSaveReqDto){
        ProviderUser providerUser = providerUserRepository.findById(providerId).orElseThrow(NotFoundUserException::new);
        Optional<ChatBot> previousCatBot = chatBotRepository.findByCategoryAndProviderUser(chatBotMessageSaveReqDto.getCategory(), providerUser);
        if (previousCatBot.isPresent()) {
            previousCatBot.get().setMessage(chatBotMessageSaveReqDto.getMessage());
            return previousCatBot.get().getId();
        }
        ChatBot newChatBot = chatBotMessageSaveReqDto.toEntity(providerUser);
        newChatBot.validateCategory();
        newChatBot = chatBotRepository.save(newChatBot);
        return newChatBot.getId();
    }

}
