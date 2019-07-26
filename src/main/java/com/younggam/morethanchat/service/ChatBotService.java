package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.domain.ChatType;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageReserveResDto;
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

    public ChatBotMessageReserveResDto getChatBotReserveMessage(Long providerId) {
        List<String> chatList = ChatCategory.RESERVE_1.getCategoryTypes().stream()
                .map(ChatType::getCategory)
                .collect(Collectors.toList());

        List<ChatBot> chatBots = chatBotMapper.findByCategoryListAndProviderUser(providerId, chatList.toArray(new String[ChatCategory.RESERVE_1.getSize()]));
        if (chatBots.size() != ChatCategory.RESERVE_1.getSize()) {
            return new ChatBotMessageReserveResDto();
        }
        return new ChatBotMessageReserveResDto(chatBots);
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
