package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@RequiredArgsConstructor
@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public void sendEmail(Email email) throws Exception {
        MimeMessage msg = mailSender.createMimeMessage();
        msg.setSubject(email.getSubject());
        msg.setText(email.getContent());
        msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email.getReceiver()));

        mailSender.send(msg);
    }
}
