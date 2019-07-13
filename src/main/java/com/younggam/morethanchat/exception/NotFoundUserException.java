package com.younggam.morethanchat.exception;

import com.younggam.morethanchat.utils.ResponseMessage;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super(ResponseMessage.NOT_FOUND_USER);
    }
}
