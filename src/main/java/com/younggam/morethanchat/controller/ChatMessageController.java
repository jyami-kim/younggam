package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageShowResDto;
import com.younggam.morethanchat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.READ_CHAT_MESSAGE_SUCCESS;

@RestController
@Slf4j
@RequestMapping("/auth/chatMessage")
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @GetMapping("{chatRoomCode}")
    public ResponseDto chatBotMessageSet(@RequestAttribute Long providerId, @PathVariable String chatRoomCode) {
        List<ChatMessageShowResDto> chatMessage = chatMessageService.getChatMessage(providerId ,chatRoomCode);
        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatMessage);
    }

//    @PostMapping()
//    public ResponseDto saveReply(@RequestAttribute Long providerId, @PathVariable String chatRoomCode){
//
//    }
}
