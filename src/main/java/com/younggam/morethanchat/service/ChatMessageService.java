package com.younggam.morethanchat.service;

import com.younggam.morethanchat.dto.chatMessage.ChatMessageReplyReqDto;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageShowResDto;
import com.younggam.morethanchat.exception.NotAccessException;
import com.younggam.morethanchat.mapper.ChatMessageMapper;
import com.younggam.morethanchat.repository.InquiriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_ACCESS_CHAT_MESSAGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageMapper chatMessageMapper; //inquiries Save 로직도 담기
    private final InquiriesRepository inquiriesRepository;

    public List<ChatMessageShowResDto> getChatMessage(Long providerId,String chatRoomCode){

        if(chatMessageMapper.canAccessChatBot(chatRoomCode, providerId) == 0){
            throw new NotAccessException(NOT_ACCESS_CHAT_MESSAGE);
        }

        return chatMessageMapper.getChatMessages(chatRoomCode).stream()
                .map(ChatMessageShowResDto::new)
                .collect(Collectors.toList());
    }

    public Long saveChatReply(Long providerId, ChatMessageReplyReqDto chatMessageReplyReqDto){
        
    }
}
