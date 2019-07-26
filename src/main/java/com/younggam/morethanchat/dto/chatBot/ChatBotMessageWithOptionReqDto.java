package com.younggam.morethanchat.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ChatBotMessageWithOptionReqDto {

    private ChatBotMessageReqDto chatBotMessageReqDto;
    private boolean packing;
    private boolean cold;

}
