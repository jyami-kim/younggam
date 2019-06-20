package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.chatBot.ChatBotMessageSaveReqDto;
import com.younggam.morethanchat.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.SAVE_CHATBOT_MESSAGE;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

@RestController
@Slf4j
@RequestMapping("/auth/chatBot")
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatBotService chatBotService;

    @PostMapping("messageSet") //이건 수정 겸 등록으로 만들어야겠다.
    public ResponseDto chatBotMessageSet(@RequestAttribute Long providerId, @RequestBody ChatBotMessageSaveReqDto chatBotMessageSaveReqDto) {
        Long messageSetId = chatBotService.saveChatBotMessage(providerId, chatBotMessageSaveReqDto);
        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_CHATBOT_MESSAGE, messageSetId.toString()));

    }
}
