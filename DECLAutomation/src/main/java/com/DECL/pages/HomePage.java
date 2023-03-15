package com.DECL.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	ActionDriver actionDriver = new ActionDriver(driver);

	@FindBy(xpath = "//a[contains(@href,'licensinghome')]//div[text()='Licensing']")
	WebElement licensingTile;
	
	/**
	 * <p>Public: Method is to click on Licensing Tile</p>
	 * @author protta
	 * @throws Exception 
	 */ 
	public void clickOnLicensingTile() throws Exception{
		actionDriver.waitforElement(licensingTile, "Licensing Tile");
		actionDriver.jsClick(licensingTile, "Licensing Tile");
	}
	
	
}
