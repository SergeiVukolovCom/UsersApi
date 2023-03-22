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

    public static void getAllPosts() {
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
    }

    public static boolean checkPostSorting() {
        String responseJsonString = ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts()).getBody().toString();
        List<Post> posts = JsonHelper.toJavaList(responseJsonString);
        for (int i = 0; i < posts.size() - 1; i++) {
            if (posts.get(i).getId() < posts.get(i + 1).getId()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static Post checkUser() {
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts99());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts99()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return JsonHelper.toPost(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts99()).getBody().toString());
    }

    public static JsonNode getUserWithIncorrectId() {
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts150());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts150()).getStatus(),
                JsonHelper.getTestsData().getCode404(), "Status code is not expected");
        return ApiUtils.getRequest(JsonHelper.getTestsData().getUrlposts150()).getBody();
    }

    public static String postUser() {
        ApiUtils.postRequest(JsonHelper.getTestsData().getUrlposts()).body(Post.toJsonString());
        try {
            Assert.assertEquals(ApiUtils.postRequest(JsonHelper.getTestsData().getUrlposts()).body(Post.toJsonString()).asJson().getStatus(),
                    JsonHelper.getTestsData().getCode201(), "Status code is not expected");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        try {
            return ApiUtils.postRequest(JsonHelper.getTestsData().getUrlposts()).body(Post.toJsonString()).asJson().getBody().toString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getUsers() {
        String responseJsonString = ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers()).getBody().toString();
        List<User> users = JsonHelper.toJavaListUser(responseJsonString);
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return users;
    }

    public static User getFifthUser() {
        String responseJsonString = ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers5()).getBody().toString();
        User user = JsonHelper.toJavaUser(responseJsonString);
        ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers5());
        Assert.assertEquals(ApiUtils.getRequest(JsonHelper.getTestsData().getUrlusers5()).getStatus(),
                JsonHelper.getTestsData().getCode200(), "Status code is not expected");
        return user;
    }

}
