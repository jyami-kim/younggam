package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.younggam.morethanchat.utils.ResponseMessage.READ_NOTICE_SUCCESS;

@RestController
@Slf4j
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("")
    public ResponseDto chatBotMessageSet() {
        return ResponseDto.of(HttpStatus.OK, READ_NOTICE_SUCCESS, noticeService.getNotices());
    }
}
