package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Inquiries;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageReplyReqDto;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageShowResDto;
import com.younggam.morethanchat.exception.EmptyException;
import com.younggam.morethanchat.exception.NotAccessException;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.ChatMessageMapper;
import com.younggam.morethanchat.repository.ChatRoomRepository;
import com.younggam.morethanchat.repository.InquiriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageMapper chatMessageMapper; //inquiries Save 로직도 담기
    private final InquiriesRepository inquiriesRepository;
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatMessageShowResDto> getChatMessage(Long providerId, String chatRoomCode) {

        checkCanAccessChatBot(providerId, chatRoomCode);

        return chatMessageMapper.getChatMessages(chatRoomCode).stream()
                .map(ChatMessageShowResDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long saveChatReply(Long providerId, ChatMessageReplyReqDto chatMessageReplyReqDto) {

        checkCanAccessChatBot(providerId, chatMessageReplyReqDto.getChatRoomCode());

        chatRoomRepository.findByChatRoomCodeAndCustomerIdAndProviderId
                (chatMessageReplyReqDto.getChatRoomCode(), chatMessageReplyReqDto.getCustomerId(), providerId)
                .orElseThrow(() -> new NotAccessException(NOT_ACCESS_CHAT_MESSAGE_CUSTOMER));

        Long chatMessageId = chatMessageMapper.saveChatMessage(chatMessageReplyReqDto);

        List<Inquiries> inquiries = inquiriesRepository.findAllByCustomerIdAndProviderIdAndReadCheckIsFalse
                (chatMessageReplyReqDto.getCustomerId(), providerId)
                .orElseThrow(() -> new NotFoundException(IS_EMPTY_INQUIRE));
        for (Inquiries inquire : inquiries) {
            inquire.setReadCheck(true);
        }
        inquiriesRepository.saveAll(inquiries);

        return chatMessageId;
    }

    private void checkCanAccessChatBot(Long providerId, String chatRoomCode) {
        if (chatMessageMapper.canAccessChatBot(chatRoomCode, providerId) == 0) {
            throw new NotAccessException(NOT_ACCESS_CHAT_MESSAGE);
        }
    }
}
