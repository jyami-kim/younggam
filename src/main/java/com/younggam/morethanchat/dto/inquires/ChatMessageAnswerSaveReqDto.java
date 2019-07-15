package com.younggam.morethanchat.dto.inquires;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ChatMessageAnswerSaveReqDto {

    private Long customerId;
    private String message;

}