package com.hcl.cm.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonApi {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Generic implementation for converting Java objects from JSON string.
     *
     * @param <T>   the generic type
     * @param json  the json string
     * @param clazz the clazz
     * @return the t
     * @throws Exception the exception
     */
    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return mapper.readValue(json, clazz);
    }

    /**
     * Generic implementation for converting Java objects from JSON string
     * written in file.
     *
     * @param <T>   the generic type
     * @param file  the file containig JSON string
     * @param clazz the clazz
     * @return the t
     * @throws Exception the exception
     */
    public static <T> T fromJson(File file, Class<T> clazz) throws Exception {
        return mapper.readValue(file, clazz);
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) throws Exception {
        return mapper.readValue(json, new TypeReference<Map<String, String>>(){});
    }


    /**
     * Generic implementation for converting JSON to Java objects.
     *
     * @param <T> the generic type
     * @param obj the obj to be conberted to JSON string
     * @return the string
     * @throws Exception the exception
     */
    public static <T> String toJson(T obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }
}

