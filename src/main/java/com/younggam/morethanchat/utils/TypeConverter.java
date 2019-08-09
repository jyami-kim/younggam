package com.younggam.morethanchat.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.younggam.morethanchat.dto.product.ProductSaveReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.exception.NotValidateTypeException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_JSON_PARSING_TYPE;

public class TypeConverter {
    private static DateTimeFormatter allFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String getNowAllDate() {
        return LocalDateTime.now().format(allFormatter);
    }

    public static String getNowDate() {
        return LocalDateTime.now().format(dateFormatter);
    }

    public static String getCalculateDate(int month) {
        return LocalDateTime.now().plusMonths(month).format(allFormatter);
    }

    public static StoreBasicInfoReqDto stringToStoreBasicInfoReqDto(String objectString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(objectString, StoreBasicInfoReqDto.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NotValidateTypeException(INVALID_JSON_PARSING_TYPE);
        }
    }

    public static ProductSaveReqDto stringToProductSaveReqDto(String objectString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(objectString, ProductSaveReqDto.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NotValidateTypeException(INVALID_JSON_PARSING_TYPE);
        }
    }

}
