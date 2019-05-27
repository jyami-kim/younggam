package com.younggam.morethanchat.exception;

import com.younggam.morethanchat.utils.ResponseMessage;

public class LoginFailException extends Exception{
    public LoginFailException() {
        super(ResponseMessage.LOGIN_FAIL);
    }
}
