package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageReplyReqDto;
import com.younggam.morethanchat.dto.chatMessage.ChatMessageShowResDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ChatMessageService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.READ_CHAT_MESSAGE_SUCCESS;
import static com.younggam.morethanchat.utils.ResponseMessage.SAVE_CHAT_BOT_REPLY_SUCCESS;
import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@RestController
@Slf4j
@RequestMapping("/auth/chatMessage")
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final JwtFactory jwtFactory;

    @GetMapping("{chatRoomCode}")
    public ResponseDto chatBotMessageSet(AuthTokenDto authTokenDto, @PathVariable String chatRoomCode) {
        Long providerId = checkAuth(authTokenDto);
        List<ChatMessageShowResDto> chatMessage = chatMessageService.getChatMessage(providerId, chatRoomCode);
        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatMessage);
    }

    @PostMapping()
    public ResponseDto saveReply(AuthTokenDto authTokenDto, @RequestBody ChatMessageReplyReqDto chatMessageReplyReqDto) {
        chatMessageReplyReqDto.setRegDate(getNowAllDate());
        Long providerId = checkAuth(authTokenDto);
        Long chatReplyMessageId = chatMessageService.saveChatReply(providerId, chatMessageReplyReqDto);
        return ResponseDto.of(HttpStatus.OK, SAVE_CHAT_BOT_REPLY_SUCCESS, chatReplyMessageId);
    }

    private Long checkAuth(AuthTokenDto authTokenDto) {
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }


}
