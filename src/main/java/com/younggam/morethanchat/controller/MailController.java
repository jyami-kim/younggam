package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.mail.MailReqDto;
import com.younggam.morethanchat.service.EmailService;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
@Slf4j
public class MailController {

    private final EmailService emailService;

    @PostMapping("")
    public ResponseDto sendMail(@RequestBody MailReqDto mailReqDto){
        emailService.sendSimpleMessage(mailReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.SEND_MAIL_SUCCESS);
    }
}
