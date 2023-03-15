package com.DECL.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.BasePage;

public class NonHomeOriginalLicenseApplicationPage extends BasePage{

	public NonHomeOriginalLicenseApplicationPage(WebDriver driver) {
		super(driver);
	}

	ActionDriver actionDriver = new ActionDriver(driver);

	@FindBy(xpath = "//p[text()='Section A: Facility Information']")
	WebElement sectionAFacilityInformation;

	/**
	 * <p>Public: Method is to wait for Section A: Facility Information Page to load successfully.</p>
	 * @author protta
	 * @throws Exception 
	 */ 
	public void waitForFacilityInformationPageLoad() throws Exception{
		actionDriver.waitforElementWithoutException(sectionAFacilityInformation, "Section A: Facility Information Page Load");
	}
}
