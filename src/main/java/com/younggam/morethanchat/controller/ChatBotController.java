package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageReqDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageResDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageWithOptionReqDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageWithOptionResDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ChatBotService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@RestController
@Slf4j
@RequestMapping("/auth/chatBot")
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatBotService chatBotService;
    private final JwtFactory jwtFactory;

    @GetMapping("reserve")
    public ResponseDto getReserveChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        ChatBotMessageResDto chatBotMessageResDto = chatBotService.getChatBotMessage(providerId, ChatCategory.RESERVE);
        return ResponseDto.of(HttpStatus.OK, messageCode("reserve", READ_CHAT_MESSAGE_SUCCESS), chatBotMessageResDto);
    }

    @PostMapping("reserve")
    public ResponseDto saveReserveChatBotMessage(AuthTokenDto authTokenDto, @RequestBody ChatBotMessageReqDto chatBotMessageReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        chatBotService.saveChatBotMessage(providerId, chatBotMessageReqDto, ChatCategory.RESERVE);
        return ResponseDto.of(HttpStatus.OK, messageCode("reserve", SAVE_CHAT_MESSAGE_SUCCESS));
    }

    @GetMapping("manage")
    public ResponseDto getManageChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        ChatBotMessageResDto chatBotMessageResDto = chatBotService.getChatBotMessage(providerId, ChatCategory.MANAGE);
        return ResponseDto.of(HttpStatus.OK, messageCode("manage", READ_CHAT_MESSAGE_SUCCESS), chatBotMessageResDto);
    }

    @PostMapping("manage")
    public ResponseDto saveManageChatBotMessage(AuthTokenDto authTokenDto, @RequestBody ChatBotMessageReqDto chatBotMessageReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        chatBotService.saveChatBotMessage(providerId, chatBotMessageReqDto, ChatCategory.MANAGE);
        return ResponseDto.of(HttpStatus.OK, messageCode("manage", SAVE_CHAT_MESSAGE_SUCCESS));
    }

    @GetMapping("answer")
    public ResponseDto getAnswerChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        ChatBotMessageWithOptionResDto chatBotQuestionMessage = chatBotService.getChatBotAnswerMessage(providerId);
        return ResponseDto.of(HttpStatus.OK, messageCode("answer", READ_CHAT_MESSAGE_SUCCESS), chatBotQuestionMessage);
    }

    @PostMapping("answer")
    public ResponseDto saveAnswerChatBotMessage(AuthTokenDto authTokenDto,
                                                @RequestBody ChatBotMessageWithOptionReqDto chatBotMessageWithOptionReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        chatBotService.saveChatBotAnswerMessage(providerId, chatBotMessageWithOptionReqDto);
        return ResponseDto.of(HttpStatus.OK, messageCode("answer", SAVE_CHAT_MESSAGE_SUCCESS));
    }


}
