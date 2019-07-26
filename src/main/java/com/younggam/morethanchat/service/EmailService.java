package com.younggam.morethanchat.service;
import com.younggam.morethanchat.dto.additional.MailReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String moreThanMail;


    public void sendSimpleMessage(MailReqDto mailReqDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(moreThanMail);
        String subject = mailReqDto.getDate() + "일 " + mailReqDto.getName() + "님 문의입니다";
        message.setSubject(subject);

        String content = "핸드폰 번호 : " + mailReqDto.getPhoneNum() + "\n\n" + mailReqDto.getContent();
        message.setText(content);

        emailSender.send(message);
    }
}
