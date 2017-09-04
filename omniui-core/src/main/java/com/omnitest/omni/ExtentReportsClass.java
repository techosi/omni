package com.omnitest.omni;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.omnitest.omni.DriverFactory.getDriver;

/**
 * Created by rtatavarty on 9/1/17.
 */
public class ExtentReportsClass {

    private ExtentReports extent;
    private static ExtentTest logger;

    @BeforeSuite
    public void startReport(){
        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/reports/"+"report"+new Date().toString()+".html");
        logger = extent.startTest("Test Started");
        extent
                .addSystemInfo("Host Name", "OMNI REPORT")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "OMNI");
        extent.loadConfig(new File(System.getProperty("user.dir")+"Reporter-config.xml"));
    }

    private static String getScreenshot(String screenshotName, String error) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/test-output"+"/screenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        logger.log(LogStatus.ERROR, error);
        return destination;
    }

    protected static void logSuccess(String stepName) {
        logger.log(LogStatus.PASS, stepName);
        MarkupHelper.createLabel(" Test Case PASSED", ExtentColor.GREEN);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
            String screenshotPath = getScreenshot(result.getName(), result.getName());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        extent.endTest(logger);
    }

    @AfterSuite
    public void endReport(){
        extent.flush();
        extent.close();
        getDriver().quit();
    }
}

