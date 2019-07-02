package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveReqDto;
import com.younggam.morethanchat.exception.NotFoundUserException;
import com.younggam.morethanchat.mapper.ChatBotMapper;
import com.younggam.morethanchat.mapper.ProviderUserMapper;
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

    private final ChatBotMapper chatBotMapper;
    private final ProviderUserMapper providerUserMapper;
    private final ChatBotRepository chatBotRepository;
//    private final

    @Transactional
    public Long saveChatBotMessage(Long providerId, ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
        ProviderUser providerUser = providerUserMapper.findById(providerId).orElseThrow(NotFoundUserException::new);
        Optional<ChatBot> previousCatBot = chatBotMapper.findByCategoryAndProviderUser(chatBotMessageSaveReqDto.getCategory(), providerUser);
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
