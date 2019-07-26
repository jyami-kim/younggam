package com.younggam.morethanchat.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
@Builder
public class ChatBotMessageWithOptionResDto {

    private ChatBotMessageResDto chatBotMessageResDto;
    private boolean packing;
    private boolean cold;

}
