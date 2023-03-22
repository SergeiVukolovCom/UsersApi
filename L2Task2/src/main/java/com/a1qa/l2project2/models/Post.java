package com.a1qa.l2project2.models;

import com.a1qa.l2project2.utils.JsonHelper;
import com.a1qa.l2project2.utils.RandomString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static String toJsonString() {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Post post = new Post(JsonHelper.getTestsData().getPostUserId(), builder().id, RandomString.getTitle().toString(), RandomString.getBody().toString());
        String json;
        try {
            json = objectMapper.writeValueAsString(post);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

}
