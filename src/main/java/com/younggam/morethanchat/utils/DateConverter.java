package com.younggam.morethanchat.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    public static String getNowDate(){
        return LocalDateTime.now().format(formatter);
    }
}
