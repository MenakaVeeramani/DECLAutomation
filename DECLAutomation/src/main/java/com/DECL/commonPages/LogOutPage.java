package com.DECL.commonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

public class LogOutPage extends BasePage{
   
	public LogOutPage(WebDriver driver) {
		super(driver);
	}
	
	ActionDriver actionDriver = new ActionDriver(driver);

	@FindBy(xpath = "//button[contains(@class,'neutral') and text()='Profile']")
	WebElement profileButton;
	
	@FindBy(xpath = "//a[contains(@href,'logout')]//span[text()='Log Out']")
	WebElement logOutLink;
	
	@FindBy(xpath = "//div[contains(@class,'header') and text()='Log In']")
	WebElement logInHeader;
    
	/**
     * <p>Public : This method will be used to logout from the application</p>
     * @author protta
     * @throws Exception 
     */
    public void logOut() throws Exception{
    	actionDriver.waitforElement(profileButton, "User Profile Button");
    	actionDriver.click(profileButton, "User Profile Button");
    	actionDriver.waitforElement(logOutLink, "LogOut Link");
    	actionDriver.jsClick(logOutLink, "LogOut Link");
    	actionDriver.waitforElement(logInHeader,"Provider Hub LogIn");
    	actionDriver.captureLogInReport(LogStatus.PASS, "User Logged Out Successfully.");
    }	
}