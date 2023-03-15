package com.DECL.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.ApplicationCommonFunctions;
import com.DECL.commonPages.BasePage;

public class HouseholdMemberInformation extends BasePage{

	public HouseholdMemberInformation(WebDriver driver) {
		super(driver);
	}

	ActionDriver actionDriver = new ActionDriver(driver);
	ApplicationCommonFunctions appCommonFunction = new ApplicationCommonFunctions(driver);

	@FindBy(xpath = "//p[text()='New Household Member']")
	WebElement NewHouseholdMember;	
	/**
	 * <p>Public: Method is to wait for New Household Member.</p>
	 * @author mveera
	 * @throws Exception 
	 */ 
	public void waitForNewHouseholdMemberInfoPageLoad() throws Exception{
		actionDriver.waitforElementWithoutException(NewHouseholdMember, "New Household Member");
	}
	
	
}

