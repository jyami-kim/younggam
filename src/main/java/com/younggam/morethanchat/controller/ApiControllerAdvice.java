package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler(AuthException.class)
    public ResponseDto handleExistUserException(AuthException ex) {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    }

    @ExceptionHandler(AlreadyUserException.class)
    public ResponseDto handleAlreadyUserException(AlreadyUserException ex) {
        return ResponseDto.of(HttpStatus.ALREADY_REPORTED, ex.getMessage());
    }

    @ExceptionHandler(NotValidateTypeException.class)
    public ResponseDto handleNotValidTypeException(NotValidateTypeException ex){
        return ResponseDto.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseDto handleNotFoundUserException(NotFoundUserException exception){
        return ResponseDto.of(HttpStatus.NO_CONTENT, exception.getMessage());
    }

    @ExceptionHandler(TokenException.class)
    public ResponseDto handleNotFoundUserException(TokenException exception){
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
    }

}

