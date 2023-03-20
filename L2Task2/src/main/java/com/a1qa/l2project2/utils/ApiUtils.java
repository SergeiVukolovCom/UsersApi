package com.a1qa.l2project2.utils;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.models.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiUtils {
    JsonHelper jsonHelper = new JsonHelper();

    public HttpResponse<Post[]> getAllPosts() throws UnirestException {
        return Unirest.get(jsonHelper.getValueFromJson("url") + "/posts").asObject(Post[].class);
    }

    public HttpResponse<Post> getUser() {
        try {
            return Unirest.get(jsonHelper.getValueFromJson("url") + "/posts/99").asObject(Post.class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<JsonNode> getUserWithIncorrectId() {
        try {
            return Unirest.get(jsonHelper.getValueFromJson("url") + "/posts/150").asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<JsonNode> postUser() {
        try {
            return Unirest.post(jsonHelper.getValueFromJson("url") + "/posts")
                    .field("userId" , JsonHelper.getUserPost().getUserId())
                    .field("title", JsonHelper.getUserPost().getTitle())
                    .field("body", JsonHelper.getUserPost().getBody()).asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<Post> checkCreateUser() {
        try {
            return Unirest.post(jsonHelper.getValueFromJson("url") + "/posts").asObject(Post.class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<User[]> getUsers() {
        try {
            return Unirest.get(jsonHelper.getValueFromJson("url") + "/users").asObject(User[].class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<User> getFifthUser() {
        try {
            return Unirest.get(jsonHelper.getValueFromJson("url") + "/users/5").asObject(User.class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

}
