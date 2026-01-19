package com.deepika.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.deepika.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTests {

    protected CommonDriver cmnDriver;
    protected WebDriver driver;
    protected LoginPage loginpage;
    protected String url;

    protected Properties configProperty;

    protected String reportFilename;
    protected ReportUtils reportUtils;
    protected String currentWorkingDirectory;

    protected ScreenshotUtils screenshot;

    @BeforeSuite
    public void preSetup() {

        configProperty = ConfigUtils.readProperties("config.properties");

        currentWorkingDirectory = System.getProperty("user.dir");

        reportFilename = currentWorkingDirectory + "/reports/guru99testReport.html";

        System.out.println("Report Path: " + reportFilename);

        reportUtils = new ReportUtils(reportFilename);
    }

    @BeforeClass
    public void setup() throws Exception {

        url = configProperty.getProperty("baseUrl");

        String browserType = configProperty.getProperty("browserType");

        cmnDriver = new CommonDriver(browserType);

        driver = cmnDriver.getDriver();

        cmnDriver.navigateToURL(url);

        loginpage = new LoginPage(driver);

        screenshot = new ScreenshotUtils(driver);
    }

    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {

        String testCaseName = result.getName();

        String timeStamp = String.valueOf(System.currentTimeMillis());

        String screenshotFilename =
                currentWorkingDirectory + "/screenshots/" + testCaseName + "_" + timeStamp + ".png";
        System.out.println("Screenshot Path: " + screenshotFilename);


        if (result.getStatus() == ITestResult.FAILURE) {

            reportUtils.addTestLog(Status.FAIL, "Test Case Failed");

            screenshot.captureAndSaveSS(screenshotFilename);
        }
    }

    @AfterClass
    public void tearDown() {

        cmnDriver.closeBrowser();

        reportUtils.flushReport();
    }

    @AfterSuite
    public void postTeardown() {

        reportUtils.flushReport();
    }
}
