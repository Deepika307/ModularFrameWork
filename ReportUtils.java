package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ReportUtils(String reportFilePath) {

        sparkReporter = new ExtentSparkReporter(reportFilePath);

        extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);
    }

    public void createATestCase(String testcaseName) {

        extentTest = extentReports.createTest(testcaseName);
    }

    public void addTestLog(Status status, String comment) {

        extentTest.log(status, comment);
    }

    public void flushReport() {

        extentReports.flush();
    }
}
