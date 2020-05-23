package com.dveamer.comment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterUtil {

    public static <T> String toJson(T obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return "";
        }
    }

}
