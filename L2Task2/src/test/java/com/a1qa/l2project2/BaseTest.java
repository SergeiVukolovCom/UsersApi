package com.a1qa.l2project2;

import com.a1qa.l2project2.utils.ApiUtils;
import com.a1qa.l2project2.utils.JsonHelper;
import com.mashape.unirest.http.Unirest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class BaseTest {

    @BeforeClass
    public void setupClass() {
        JsonHelper.setupUnirest();
    }

    @AfterClass
    public void tearDown() throws IOException {
        Unirest.shutdown();
    }
}
