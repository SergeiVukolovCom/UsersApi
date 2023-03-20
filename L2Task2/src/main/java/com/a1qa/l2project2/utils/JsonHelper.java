package com.a1qa.l2project2.utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import java.io.File;
import java.io.IOException;

public class JsonHelper {
    private ISettingsFile environment = new JsonSettingsFile("testsdata.json");

    public static void setupUnirest() {
        Unirest.setObjectMapper(new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static Post getUserPost() {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        File filedata = new File("src/test/resources/postuser.json");
        Post javaobject;
        try {
            javaobject = objectMapper.readValue(filedata, Post.class);
        } catch (IOException e) {
            throw new RuntimeException("File not found or another error", e);
        }
        return javaobject;
    }

    public static User getUser5Data() {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        File filedata = new File("src/test/resources/user5.json");
        User javaobject;
        try {
            javaobject = objectMapper.readValue(filedata, User.class);
        } catch (IOException e) {
            throw new RuntimeException("File not found or another error", e);
        }
        return javaobject;
    }

    public String getValueFromJson(String key) {
        return environment.getValue(String.format("/%s", key)).toString();
    }

}
