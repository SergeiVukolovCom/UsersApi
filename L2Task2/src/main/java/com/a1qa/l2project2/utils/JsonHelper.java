package com.a1qa.l2project2.utils;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.models.TestsData;
import com.a1qa.l2project2.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHelper {

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

    public static TestsData getTestsData() {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        File filedata = new File("src/test/resources/testsdata.json");
        TestsData javaobject;
        try {
            javaobject = objectMapper.readValue(filedata, TestsData.class);
        } catch (IOException e) {
            throw new RuntimeException("File not found or another error", e);
        }
        return javaobject;
    }

    public static List<Post> toJavaList(String responseString) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        try {
            return objectMapper.readValue(responseString, new TypeReference<List<Post>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Post toPost(String responseString) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        try {
            return objectMapper.readValue(responseString, new TypeReference<Post>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> toJavaListUser(String responseString) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        try {
            return objectMapper.readValue(responseString, new TypeReference<List<User>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static User toJavaUser(String responseString) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        try {
            return objectMapper.readValue(responseString, new TypeReference<User>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
