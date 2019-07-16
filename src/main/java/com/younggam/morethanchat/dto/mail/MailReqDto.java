package com.younggam.morethanchat.dto.mail;

import com.younggam.morethanchat.utils.TypeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MailReqDto {
    private String name;
    private String phoneNum;
    private String content;
    private String date;

    MailReqDto(){
        date = TypeConverter.getNowDate();
    }
}
