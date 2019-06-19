package com.younggam.morethanchat.exception;

import com.younggam.morethanchat.utils.ResponseMessage;

public class LoginFailException extends RuntimeException{
    public LoginFailException() {
        super(ResponseMessage.LOGIN_FAIL);
    }
}
