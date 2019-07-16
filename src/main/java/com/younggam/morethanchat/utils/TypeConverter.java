package com.younggam.morethanchat.utils;

import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TypeConverter {
    private static DateTimeFormatter allFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String getNowAllDate() {
        return LocalDateTime.now().format(allFormatter);
    }

    public static String getNowDate() {
        return LocalDateTime.now().format(dateFormatter);
    }
}
