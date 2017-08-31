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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.omnitest.omni.DriverFactory.getDriver;

public class Reporter{
	private static ExtentReports extent;
	private static ExtentTest logger;

	public static void startReport(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/reports/"+"report"+new Date().toString()+".html");
		logger = extent.startTest("Test Started");
		extent
                .addSystemInfo("Host Name", "OMNI REPORT")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "OMNI");
                extent.loadConfig(new File(System.getProperty("user.dir")+"Reporter-config.xml"));
	}

	public static String takeScreenShot(WebDriver driver, String screenshotName, String error) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/test-output"+"/screenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		logger.log(LogStatus.ERROR, error);
		return destination;
	}

	public static void logSuccess(String stepName) {
		logger.log(LogStatus.PASS, stepName);
		MarkupHelper.createLabel(" Test Case PASSED", ExtentColor.GREEN);
	}

	public static void endReport() throws Exception{
		getDriver().quit();
		extent.endTest(logger);
		extent.flush();
		extent.close();
	
	}

}