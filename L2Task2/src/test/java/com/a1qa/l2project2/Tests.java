package com.a1qa.l2project2;

import com.a1qa.l2project2.requests.ApiApplicationRequests;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    private ApiApplicationRequests apiApplicationRequests = new ApiApplicationRequests();

    @Test
    public void tests() throws UnirestException {
        Assert.assertTrue(apiApplicationRequests.checkAllPosts(), "Status code is not expected");
        Assert.assertTrue(apiApplicationRequests.checkPostSorting(), "Not sort");
        Assert.assertTrue(apiApplicationRequests.checkUser(), "Status code is not expected");
        Assert.assertTrue(apiApplicationRequests.checkInformationAboutUser(), "Incorrect information about User");
        Assert.assertTrue(apiApplicationRequests.checkUserWithIncorrectId(), "This User is detected");
        Assert.assertTrue(apiApplicationRequests.checkStatusPostUser(), "Status code is not expected");
        Assert.assertTrue(apiApplicationRequests.checkPostUser(), "Post request isn't correct");
        Assert.assertTrue(apiApplicationRequests.checkGetUsers(), "Status code is not expected");
        apiApplicationRequests.informationAboutUser();
        apiApplicationRequests.compareOFUsers();
    }

}
