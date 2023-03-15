package com.DECL.config;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import com.DECL.commonPages.ActionDriver;
import com.relevantcodes.extentreports.LogStatus;

public class CustomAssertion extends Assertion{

	WebDriver driver;
	ActionDriver actionDriver;
	InitiateApplication initiateApplication;
	
	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		initiateApplication = new InitiateApplication();
		driver = initiateApplication.getDriver();
		actionDriver = new ActionDriver(driver);
		actionDriver.captureLogInReport(LogStatus.FAIL, assertCommand.getMessage());
	}
}
