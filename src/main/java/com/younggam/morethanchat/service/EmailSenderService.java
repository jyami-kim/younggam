package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Email;

import javax.mail.MessagingException;

public interface EmailSenderService {
    public void sendEmail(Email email) throws MessagingException, Exception;
}
