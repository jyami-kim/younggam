package com.younggam.morethanchat.exception;

import com.younggam.morethanchat.utils.ResponseMessage;

public class AlreadyUserException extends RuntimeException{
    public AlreadyUserException(String message){
        super(message);
    }
}
