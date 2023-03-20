package com.a1qa.l2project2.requests;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.models.User;
import com.a1qa.l2project2.utils.ApiUtils;
import com.a1qa.l2project2.utils.JsonHelper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;

public class ApiApplicationRequests extends ApiUtils {
    JsonHelper jsonHelper = new JsonHelper();

    public boolean checkAllPosts() throws UnirestException {
        if (getAllPosts().getStatus() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPostSorting() throws UnirestException {
        List<Post> posts = Arrays.stream(getAllPosts().getBody()).toList();
        for (int i = 0; i < posts.size()-1; i++) {
            if (posts.get(i).getId() < posts.get(i + 1).getId()) {
                continue;
            } else {
                return false;
            }
        } return true;
    }

    public boolean checkUser() {
        if (getUser().getStatus() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkInformationAboutUser() {
        if ((getUser().getBody().getUserId() == 10) &
                (getUser().getBody().getId() == 99) &
                (getUser().getBody().getTitle().length() > 0) &
                (getUser().getBody().getBody().length() > 0)
        ) return true;
        else {
            return false;
        }
    }

    public boolean checkUserWithIncorrectId() {
        if ((getUserWithIncorrectId().getStatus() == 404) &
                (getUserWithIncorrectId().getBody().toString().equals(jsonHelper.getValueFromJson("body")))) {
        } else {
            return false;
        }
        return true;
    }

    public boolean checkStatusPostUser() {
        if (postUser().getStatus() == 201) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPostUser() {
        if (postUser().getBody().toString().contains(JsonHelper.getUserPost().getBody()) &
                (postUser().getBody().toString().contains(JsonHelper.getUserPost().getTitle()))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkGetUsers() {
        if (getUsers().getStatus() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public void informationAboutUser() {
        List<User> users = Arrays.stream(getUsers().getBody()).toList();
        for (int i = 0; i < users.size(); i++) {
            Assert.assertEquals(JsonHelper.getUser5Data().getId().toString(), users.get(4).getId().toString(), "Id fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getName(), users.get(4).getName(), "Name fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getUsername() ,users.get(4).getUsername(), "Username fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getStreet(), users.get(4).getAddress().getStreet(), "Street fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getSuite(), users.get(4).getAddress().getSuite(), "Suite fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getCity(), users.get(4).getAddress().getCity(), "City fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getZipcode(), users.get(4).getAddress().getZipcode(), "Zipcode fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getGeo().getLat(), users.get(4).getAddress().getGeo().getLat(), "Lat fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getAddress().getGeo().getLng(), users.get(4).getAddress().getGeo().getLng(), "Lng fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getPhone(), users.get(4).getPhone(), "Phone fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getWebsite(), users.get(4).getWebsite(), "Website fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getCompany().getName(), users.get(4).getCompany().getName(), "Name fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getCompany().getCatchPhrase(), users.get(4).getCompany().getCatchPhrase(), "Catchphrase fields do not match");
            Assert.assertEquals(JsonHelper.getUser5Data().getCompany().getBs(), users.get(4).getCompany().getBs(), "Bs fields do not match");
        }
    }

    public void compareOFUsers() {
        List<User> users = Arrays.stream(getUsers().getBody()).toList();
        for (int i = 0; i < users.size(); i++) {
            Assert.assertEquals(users.get(4).getId().toString(), getFifthUser().getBody().getId().toString(), "Id fields do not match");
            Assert.assertEquals(users.get(4).getName(), getFifthUser().getBody().getName(), "Name fields do not match");
            Assert.assertEquals(users.get(4).getUsername(), getFifthUser().getBody().getUsername(), "Username fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getStreet(), getFifthUser().getBody().getAddress().getStreet(), "Street fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getSuite(), getFifthUser().getBody().getAddress().getSuite(), "Suite fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getCity(), getFifthUser().getBody().getAddress().getCity(), "City fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getZipcode(), getFifthUser().getBody().getAddress().getZipcode(), "Zipcode fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getGeo().getLat(), getFifthUser().getBody().getAddress().getGeo().getLat(), "Lat fields do not match");
            Assert.assertEquals(users.get(4).getAddress().getGeo().getLng(), getFifthUser().getBody().getAddress().getGeo().getLng(), "Lng fields do not match");
            Assert.assertEquals(users.get(4).getPhone(), getFifthUser().getBody().getPhone(), "Phone fields do not match");
            Assert.assertEquals(users.get(4).getWebsite(), getFifthUser().getBody().getWebsite(), "Website fields do not match");
            Assert.assertEquals(users.get(4).getCompany().getName(), getFifthUser().getBody().getCompany().getName(), "Name fields do not match");
            Assert.assertEquals(users.get(4).getCompany().getCatchPhrase(), getFifthUser().getBody().getCompany().getCatchPhrase(), "Catchphrase fields do not match");
            Assert.assertEquals(users.get(4).getCompany().getBs(), getFifthUser().getBody().getCompany().getBs(), "Bs fields do not match");
        }
    }

}
