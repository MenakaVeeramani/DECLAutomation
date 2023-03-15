package com.DECL.commonPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	public static final Logger logger = LogManager.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}
}
