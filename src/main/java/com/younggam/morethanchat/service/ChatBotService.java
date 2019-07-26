package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.domain.ChatType;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageResDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageWithOptionResDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotStoreOptionDto;
import com.younggam.morethanchat.mapper.ChatBotMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {

    private final ChatBotMapper chatBotMapper;

    public ChatBotMessageResDto getChatBotMessage(Long providerId, ChatCategory chatCategory) {
        List<String> chatList = chatCategory.getCategoryTypes().stream()
                .map(ChatType::getCategory)
                .collect(Collectors.toList());

        List<ChatBot> chatBots = chatBotMapper.findByCategoryListAndProviderUser(providerId, chatList.toArray(new String[chatCategory.getSize()]));
        if (chatBots.size() != chatCategory.getSize()) {
            return new ChatBotMessageResDto(chatCategory);
        }
        return new ChatBotMessageResDto(chatBots);
    }

    public ChatBotMessageWithOptionResDto getChatBotQuestionMessage(Long providerId) {

        ChatBotStoreOptionDto chatBotStoreOptionDto = chatBotMapper.findStoreByProviderId(providerId)
                .orElseGet(ChatBotStoreOptionDto::new);

        return ChatBotMessageWithOptionResDto.builder()
                .chatBotMessageResDto(getChatBotMessage(providerId, ChatCategory.QUESTION))
                .cold(chatBotStoreOptionDto.isCool())
                .packing(chatBotStoreOptionDto.isPacking())
                .build();
    }


//    @Transactional
//    public ChatBotMessageSaveResDto saveChatBotMessage(Long providerId, ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
////        ChatBot providerUser = chatBotRepository.findById(providerId)
////                .orElseThrow(() -> new NotFoundException(NOT_FOUND_CHATBOT));
//
//        ChatCategory chatCategory = ChatCategory.find(chatBotMessageSaveReqDto.getCategory());
//
//        ChatBot chatBot = chatBotMapper
//                .findByCategoryAndProviderUser(chatCategory.getCategoryType(), providerId);
//
//        if (chatBot != null) {
//            chatBot.setMessage(chatBotMessageSaveReqDto.getMessage());
//        } else {
//            chatBot = chatBotMessageSaveReqDto.toEntity(providerId);
//        }
//
//        log.info(chatBot.getCategory());
//        log.info(chatBot.getMessage());
//
//        chatBot = chatBotRepository.save(chatBot);
//
//        return ChatBotMessageSaveResDto.builder()
//                .category(chatBot.getCategory())
//                .id(chatBot.getId())
//                .build();
//    }


}
