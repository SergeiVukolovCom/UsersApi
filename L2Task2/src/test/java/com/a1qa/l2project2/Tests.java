package com.a1qa.l2project2;

import com.a1qa.l2project2.models.Post;
import com.a1qa.l2project2.requests.ApiApplicationRequests;
import com.a1qa.l2project2.utils.JsonHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class Tests extends BaseTest {

    @Test
    public void tests() {
        SoftAssert softAssert = new SoftAssert();
        ApiApplicationRequests.getAllPosts();
        Assert.assertTrue(ApiApplicationRequests.checkPostSorting(), "Posts are not sorted");
        softAssert.assertEquals(ApiApplicationRequests.checkUser().getUserId(), JsonHelper.getTestsData().getUserId(), "UserId is correct");
        softAssert.assertEquals(ApiApplicationRequests.checkUser().getId(), JsonHelper.getTestsData().getId(), "Id is correct");
        softAssert.assertNotEquals(ApiApplicationRequests.checkUser().getTitle().length(), Optional.ofNullable(JsonHelper.getTestsData().getLength()), "Title are not empty");
        softAssert.assertNotEquals(ApiApplicationRequests.checkUser().getBody().length(), Optional.ofNullable(JsonHelper.getTestsData().getLength()), "Body are not empty");
        softAssert.assertAll();
        Assert.assertEquals(ApiApplicationRequests.getUserWithIncorrectId().toString(), JsonHelper.getTestsData().getBody(), "This user is detected");
        Assert.assertEquals(ApiApplicationRequests.postUser(), Post.toJsonString(), "Post request is not correct");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getId().toString(),
                JsonHelper.getUser5Data().getId().toString(),"Id fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getName(),
                JsonHelper.getUser5Data().getName(),"Name fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getUsername(),
                JsonHelper.getUser5Data().getUsername(),"Username fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getStreet(),
                JsonHelper.getUser5Data().getAddress().getStreet(),"Street fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getSuite(),
                JsonHelper.getUser5Data().getAddress().getSuite(),"Suite fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getCity(),
                JsonHelper.getUser5Data().getAddress().getCity(),"City fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getZipcode(),
                JsonHelper.getUser5Data().getAddress().getZipcode(),"Zipcode fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getGeo().getLat(),
                JsonHelper.getUser5Data().getAddress().getGeo().getLat(),"Lat fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getAddress().getGeo().getLng(),
                JsonHelper.getUser5Data().getAddress().getGeo().getLng(),"Lng fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getPhone(),
                JsonHelper.getUser5Data().getPhone(),"Phone fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getWebsite(),
                JsonHelper.getUser5Data().getWebsite(),"Website fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getCompany().getName(),
                JsonHelper.getUser5Data().getCompany().getName(),"Companyname fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getCompany().getCatchPhrase(),
                JsonHelper.getUser5Data().getCompany().getCatchPhrase(),"Catchphrase fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getUsers().get(JsonHelper.getTestsData().getNumberUser()-1).getCompany().getBs(),
                JsonHelper.getUser5Data().getCompany().getBs(),"Bs fields do not match");
        softAssert.assertAll();
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getId().toString(),
                JsonHelper.getUser5Data().getId().toString(),"Id fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getName(),
                JsonHelper.getUser5Data().getName(),"Name fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getUsername(),
                JsonHelper.getUser5Data().getUsername(),"Username fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getStreet(),
                JsonHelper.getUser5Data().getAddress().getStreet(),"Street fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getSuite(),
                JsonHelper.getUser5Data().getAddress().getSuite(),"Suite fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getCity(),
                JsonHelper.getUser5Data().getAddress().getCity(),"City fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getZipcode(),
                JsonHelper.getUser5Data().getAddress().getZipcode(),"Zipcode fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getGeo().getLat(),
                JsonHelper.getUser5Data().getAddress().getGeo().getLat(),"Lat fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getAddress().getGeo().getLng(),
                JsonHelper.getUser5Data().getAddress().getGeo().getLng(),"Lng fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getPhone(),
                JsonHelper.getUser5Data().getPhone(),"Phone fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getWebsite(),
                JsonHelper.getUser5Data().getWebsite(),"Website fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getCompany().getName(),
                JsonHelper.getUser5Data().getCompany().getName(),"Companyname fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getCompany().getCatchPhrase(),
                JsonHelper.getUser5Data().getCompany().getCatchPhrase(),"Catchphrase fields do not match");
        softAssert.assertEquals(ApiApplicationRequests.getFifthUser().getCompany().getBs(),
                JsonHelper.getUser5Data().getCompany().getBs(),"Bs fields do not match");
        softAssert.assertAll();

    }

}
