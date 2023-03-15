package com.DECL.config;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class Listeners implements ITestListener{

	WebDriver driver;

	public void onTestStart(ITestResult result) {}

	public void onTestSuccess(ITestResult result) {}

	public void onTestFailure(ITestResult result) {
		InitiateApplication initiateApplication = new InitiateApplication();
		this.driver = initiateApplication.getDriver();
		try {
			InitiateApplication.threadLocalExtentTest.get().log(LogStatus.FAIL,InitiateApplication.threadLocalExtentTest.get().
					addScreenCapture(screenShotCapture(driver))+ result.getName()+" Test Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void onTestSkipped(ITestResult result) {}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	public void onStart(ITestContext context) {}

	public void onFinish(ITestContext context) {}

	/**
	 * <p>Public: Method is to capture the Screenshot</p>
	 * @param driver
	 * @author protta
	 * @throws IOException 
	 */ 
	public static String screenShotCapture(WebDriver driver) throws IOException {
		Date date = new Date();
		String screenShotFileName = date.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + screenShotFileName);
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}
