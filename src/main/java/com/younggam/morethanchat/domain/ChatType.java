package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@Builder
@AllArgsConstructor
public class ChatType {
    private String category;
    private String message;
}
