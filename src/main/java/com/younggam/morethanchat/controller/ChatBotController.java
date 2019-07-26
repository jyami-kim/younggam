package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.domain.ChatCategory;
import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageResDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageWithOptionResDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ChatBotService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.younggam.morethanchat.utils.ResponseMessage.READ_CHAT_MESSAGE_SUCCESS;

@RestController
@Slf4j
@RequestMapping("/auth/chatBot")
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatBotService chatBotService;
    private final JwtFactory jwtFactory;


//    @PostMapping("messageSet") //이건 수정 겸 등록으로 만들어야겠다.
//    public ResponseDto chatBotMessageSet(AuthTokenDto authTokenDto, @RequestBody ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
//        Long providerId = jwtFactory.getUserId(authTokenDto.getToken())
//                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
//        ChatBotMessageSaveResDto chatBotMessageSaveResDto = chatBotService.saveChatBotMessage(providerId, chatBotMessageSaveReqDto);
//        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_CHATBOT_MESSAGE, chatBotMessageSaveResDto.getCategory()), chatBotMessageSaveResDto.getId());
//    }

    @GetMapping("reserve")
    public ResponseDto getReserveChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = checkAuth(authTokenDto);
        ChatBotMessageResDto chatBotMessageResDto = chatBotService.getChatBotMessage(providerId, ChatCategory.RESERVE);
        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatBotMessageResDto);
    }
//
//    @PostMapping("reserve")
//    public ResponseDto saveReserveChatBotMessage(AuthTokenDto authTokenDto){
//        Long providerId = checkAuth(authTokenDto);
//        ChatBotMessageResDto chatBotMessageResDto = chatBotService.getChatBotMessage(providerId, ChatCategory.RESERVE);
//        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatBotMessageResDto);
//    }

    @GetMapping("reserveEdit")
    public ResponseDto getReserveEditChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = checkAuth(authTokenDto);
        ChatBotMessageResDto chatBotMessageResDto = chatBotService.getChatBotMessage(providerId, ChatCategory.RESERVE_EDIT);
        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatBotMessageResDto);
    }

    @GetMapping("question")
    public ResponseDto getQuestionChatBotMessage(AuthTokenDto authTokenDto) {
        Long providerId = checkAuth(authTokenDto);
        ChatBotMessageWithOptionResDto chatBotQuestionMessage = chatBotService.getChatBotQuestionMessage(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_CHAT_MESSAGE_SUCCESS, chatBotQuestionMessage);
    }

    private Long checkAuth(AuthTokenDto authTokenDto) {
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }

}
