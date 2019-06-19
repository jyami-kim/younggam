package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.UnauthorizedException;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDto handleExistUserException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "unauthorization!!");
    }

    @ExceptionHandler(AlreadyUserException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseDto handleAlreadyUserException() {
        return ResponseDto.of(HttpStatus.ALREADY_REPORTED, ResponseMessage.ALREADY_EXISTED_USER);
    }

    @ExceptionHandler(AlreadyUserException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto LoginFailException() {
        return ResponseDto.of(HttpStatus.NO_CONTENT, ResponseMessage.LOGIN_FAIL);
    }


}

