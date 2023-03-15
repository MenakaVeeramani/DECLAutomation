package com.DECL.Individual.testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DECL.commonPages.LogInPage;
import com.DECL.commonPages.LogOutPage;
import com.DECL.config.InitiateApplication;
import com.DECL.utils.ConfigurationFileReader;

@Listeners(com.DECL.config.Listeners.class)
public class LogIn extends InitiateApplication{
	
	WebDriver driver;
	
	@Test
	@Parameters({"inputDataIndex"})
	public void logInFlow(int inputDataIndex) throws Exception {

		driver = getDriver();
		LogInPage logInPage = new LogInPage(driver);
		LogOutPage logOutPage = new LogOutPage(driver);
		ConfigurationFileReader configFileReader = new ConfigurationFileReader();
		
		gotoApplication(configFileReader.getApplicationUrl());
		logInPage.logInAsUser("PROGRAM USER", configFileReader.getApplicationOrg());
		logOutPage.logOut();
	}

}
