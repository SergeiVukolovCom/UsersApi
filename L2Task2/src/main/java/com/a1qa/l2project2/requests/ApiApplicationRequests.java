package com.a1qa.l2project2.requests;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.models.User;
import com.a1qa.l2project2.utils.ApiUtils;
import com.a1qa.l2project2.utils.JsonHelper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import java.util.List;

public class ApiApplicationRequests {

    public static List<Post> getAllPosts() {
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlPosts());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlPosts()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        String responseJsonString = ApiUtils.getRequest(JsonHelper.getTestsData().getUrlPosts()).getBody().toString();
        return JsonHelper.toJavaList(responseJsonString);
    }

    public static Post getPost(int numberOfUser) {
        ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser));
        Assert.assertEquals(ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser)).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return JsonHelper.toPost(ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser)).getBody().toString());
    }

    public static JsonNode getUserWithIncorrectId(int numberOfUser) {
        ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser));
        Assert.assertEquals(ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser)).getStatus(),
                JsonHelper.getTestsData().getCode404(), "Status code is not expected");
        return ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlPosts() + "/%s", numberOfUser)).getBody();
    }

    public static String postUser() {
        ApiUtils.postRequest(JsonHelper.getTestsData().getUrlPosts()).body(Post.toJsonString());
        try {
            Assert.assertEquals(ApiUtils.postRequest(JsonHelper.getTestsData().getUrlPosts()).body(Post.toJsonString()).asJson().getStatus(),
                    JsonHelper.getTestsData().getCode201(), "Status code is not expected");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        try {
            return ApiUtils.postRequest(JsonHelper.getTestsData().getUrlPosts()).body(Post.toJsonString()).asJson().getBody().toString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getUsers() {
        String responseJsonString = ApiUtils.getRequest(JsonHelper.getTestsData().getUrlUsers()).getBody().toString();
        List<User> users = JsonHelper.toJavaListUser(responseJsonString);
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlUsers());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlUsers()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return users;
    }

    public static User getUser(int numberOfUser) {
        String responseJsonString = ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlUsers() + "/%s", numberOfUser)).getBody().toString();
        User user = JsonHelper.toJavaUser(responseJsonString);
        ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlUsers() + "/%s", numberOfUser));
        Assert.assertEquals(ApiUtils.getRequest(String.format(JsonHelper.getTestsData().getUrlUsers() + "/%s", numberOfUser)).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return user;
    }

}
