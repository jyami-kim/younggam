package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.domain.ChatType;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.chatBot.*;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.mapper.ChatBotMapper;
import com.younggam.morethanchat.repository.ChatBotRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_USER;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {

    private final ChatBotMapper chatBotMapper;
    private final StoreRepository storeRepository;
    private final ChatBotRepository chatBotRepository;

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

    public ChatBotMessageWithOptionResDto getChatBotAnswerMessage(Long providerId) {
        ChatBotStoreOptionDto chatBotStoreOptionDto = chatBotMapper.findStoreByProviderId(providerId)
                .orElseGet(ChatBotStoreOptionDto::new);

        return ChatBotMessageWithOptionResDto.builder()
                .chatBotMessageResDto(getChatBotMessage(providerId, ChatCategory.ANSWER))
                .cold(chatBotStoreOptionDto.isCool())
                .packing(chatBotStoreOptionDto.isPacking())
                .build();
    }

    private ChatBot findByCategoryName(String category, List<ChatBot> reserveChatBot) {
        for (ChatBot chatBot : reserveChatBot) {
            if (chatBot.getCategory().equals(category))
                return chatBot;
        }
        throw new NotValidateTypeException(ResponseMessage.INVALID_CATEGORY_TYPE);
    }

    @Transactional
    public void saveChatBotMessage(Long providerId, ChatBotMessageReqDto chatBotMessageReqDto, ChatCategory chatCategory) {
        List<ChatBot> reserveChatBot =
                chatBotRepository.findByProviderIdAndCategoryStartingWith(providerId, chatCategory.getLike());

        if (reserveChatBot.isEmpty()) {
            List<ChatBot> chatBots = chatBotMessageReqDto.toDefaultEntity(providerId, chatCategory);
            chatBotRepository.saveAll(chatBots);
        } else {
            List<ChatBot> saveList = new ArrayList<>();
            chatBotMessageReqDto.checkValidCategory(chatCategory);
            for (ChatType chatType : chatBotMessageReqDto.getChatTypes()) {
                ChatBot byCategoryName = findByCategoryName(chatType.getCategory(), reserveChatBot);
                byCategoryName.setMessage(chatType.getMessage());
                saveList.add(byCategoryName);
            }
            chatBotRepository.saveAll(saveList);
        }
    }

    @Transactional
    //둘 중 더 나은 버전으로 작성 할 예정 (일단 DB 접근이 덜한 1로 설정)
    public void saveChatBotReserveMessageVer2(Long providerId, ChatBotMessageReqDto chatBotMessageReqDto, ChatCategory chatCategory) {

        List<ChatBot> saveList = new ArrayList<>();

        chatBotMessageReqDto.checkValidCategory(chatCategory);

        for (ChatType chatType : chatBotMessageReqDto.getChatTypes()) {
            ChatBot chatBot = chatBotRepository.findByProviderIdAndCategory(providerId, chatType.getCategory())
                    .orElse(chatType.toChatBotEntity(providerId));
            chatBot.setMessage(chatType.getMessage());
            saveList.add(chatBot);
        }

        chatBotRepository.saveAll(saveList);
    }

    @Transactional
    public void saveChatBotAnswerMessage(Long providerId, ChatBotMessageWithOptionReqDto chatBotMessageWithOptionReqDto) {
        Store store = storeRepository.findByProviderId(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));

        store.setCool(chatBotMessageWithOptionReqDto.isCold());
        store.setPacking(chatBotMessageWithOptionReqDto.isPacking());

        saveChatBotMessage(providerId, chatBotMessageWithOptionReqDto.getChatBotMessageReqDto(), ChatCategory.ANSWER);
    }


}
