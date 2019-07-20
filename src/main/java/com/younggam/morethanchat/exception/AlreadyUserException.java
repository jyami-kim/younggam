package com.younggam.morethanchat.exception;

public class AlreadyUserException extends RuntimeException {
    public AlreadyUserException(String message) {
        super(message);
    }
}
