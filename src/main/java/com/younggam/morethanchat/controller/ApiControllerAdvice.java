package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler(CustomAuthException.class)
    public ResponseEntity<ResponseDto> handleCustomAuthException(CustomAuthException ex) {
        return new ResponseEntity<>(ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ResponseDto> handleEmptyException(EmptyException ex) {
        return new ResponseEntity<>(ResponseDto.of(HttpStatus.RESET_CONTENT, ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(NotAccessException.class)
    public ResponseDto handleNotAccessException(NotAccessException ex) {
        return ResponseDto.of(HttpStatus.FORBIDDEN, ex.getMessage());
    }

    @ExceptionHandler(AlreadyUserException.class)
    public ResponseDto handleAlreadyUserException(AlreadyUserException ex) {
        return ResponseDto.of(HttpStatus.ALREADY_REPORTED, ex.getMessage());
    }

    @ExceptionHandler(NotValidateTypeException.class)
    public ResponseDto handleNotValidTypeException(NotValidateTypeException ex) {
        return ResponseDto.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseDto handleNotFoundUserException(NotFoundException exception) {
        return ResponseDto.of(HttpStatus.NO_CONTENT, exception.getMessage());
    }

    @ExceptionHandler(TokenException.class)
    public ResponseDto handleNotFoundUserException(TokenException exception) {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
    }

}