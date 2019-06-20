package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.LoginReqDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.service.LoginService;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("login")
    public ResponseDto login(@RequestBody LoginReqDto loginReqDto) {
        log.info(loginReqDto.getEmail());
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.LOGIN_SUCCESS, loginService.login(loginReqDto));
    }
}
