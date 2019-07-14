package com.younggam.morethanchat.dto.mail;

import com.younggam.morethanchat.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class MailReqDto {
    private String name;
    private String phoneNum;
    private String content;
    private String date;

    MailReqDto(){
        date = DateConverter.getNowDate();
    }
}
