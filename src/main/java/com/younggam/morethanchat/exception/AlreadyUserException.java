package com.younggam.morethanchat.exception;

import com.younggam.morethanchat.utils.ResponseMessage;

public class AlreadyUserException extends Exception{
    public AlreadyUserException() {
        super(ResponseMessage.ALREADY_EXISTED_USER);
    }
}
