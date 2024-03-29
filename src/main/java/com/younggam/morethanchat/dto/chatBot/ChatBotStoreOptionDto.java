package com.younggam.morethanchat.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatBotStoreOptionDto {
    private boolean cool;
    private boolean packing;
}
