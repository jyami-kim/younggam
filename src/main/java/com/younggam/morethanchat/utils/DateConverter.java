package com.younggam.morethanchat.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static DateTimeFormatter allFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String getNowAllDate() {
        return LocalDateTime.now().format(allFormatter);
    }

    public static String getNowDate() {
        return LocalDateTime.now().format(dateFormatter);
    }
}
