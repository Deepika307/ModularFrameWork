package com.deepika.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.deepika.base.BaseTests;

public class LoginTest extends BaseTests {

    @Test
    public void verifyUserLoginWithCorrectCredentials() {

        reportUtils.createATestCase("Verify User Login With Correct Credentials");

        reportUtils.addTestLog(Status.INFO, "Reading username and password from config file");

        // Read credentials from config.properties
        String username = configProperty.getProperty("username");
        String password = configProperty.getProperty("password");

        reportUtils.addTestLog(Status.INFO, "Performing Login");

        loginpage.loginToApp(username, password);

        String expectedTitle = "GTPL Bank Manager HomePage";

        String actualTitle = cmnDriver.getTitleOfthePage();

        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
