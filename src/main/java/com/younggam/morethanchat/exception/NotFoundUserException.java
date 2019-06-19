package com.younggam.morethanchat.exception;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_USER;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super(NOT_FOUND_USER);
    }
}
