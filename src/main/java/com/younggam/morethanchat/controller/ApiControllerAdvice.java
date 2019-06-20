package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

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
    public ResponseDto handleAlreadyUserException(String message) {
        return ResponseDto.of(HttpStatus.ALREADY_REPORTED, message);
    }

    @ExceptionHandler(NotValidateTypeException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseDto handleNotValidTypeException(NotValidateTypeException ex){
        return ResponseDto.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


//    @ExceptionHandler(AlreadyUserException.class)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseDto LoginFailException() {
//        return ResponseDto.of(HttpStatus.NO_CONTENT, ResponseMessage.LOGIN_FAIL);
//    }


}

