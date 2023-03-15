package com.DECL.Individual.testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DECL.config.InitiateApplication;
import com.DECL.pages.HomePage;
import com.DECL.pages.NonHomeOriginalLicenseApplicationPage;
import com.DECL.utils.ConfigurationFileReader;
import com.DECL.utils.ExcelReader;
import com.DECL.commonPages.Constants;
import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.ApplicationCommonFunctions;
import com.DECL.commonPages.LogInPage;
import com.DECL.commonPages.LogOutPage;

@Listeners(com.DECL.config.Listeners.class)
public class Basic extends InitiateApplication{

WebDriver driver;
	
	@Test
	@Parameters({"inputDataIndex"})
	public void basicFlow(int inputDataIndex) throws Exception {

		driver = getDriver();
		HomePage homePage = new HomePage(driver);
		ExcelReader excelReader = new ExcelReader();
		LogInPage logInPage = new LogInPage(driver);
		LogOutPage logOutPage = new LogOutPage(driver);
		ActionDriver actionDriver = new ActionDriver(driver);
		ConfigurationFileReader configFileReader = new ConfigurationFileReader();
		ApplicationCommonFunctions appCommonFunctions = new ApplicationCommonFunctions(driver);
		NonHomeOriginalLicenseApplicationPage nonHomeOriginalLicenseApplicationPage = new NonHomeOriginalLicenseApplicationPage(driver);
		
		String inputTestDataExcelPath = Constants.INPUT_TESTDATA_PATH;
		String licensingSheetName = Constants.licensingSheetName;
		
		gotoApplication(configFileReader.getApplicationUrl());
		logInPage.logInAsUser("PROGRAM USER", configFileReader.getApplicationOrg());
		homePage.clickOnLicensingTile();
		actionDriver.switchToChildWindow();
		appCommonFunctions.clickOnLink("START A NEW FORM");
		appCommonFunctions.clickOnNeutralButton("View");
		appCommonFunctions.clickOnButton("Start New full application");
		excelReader.setExcelFile(inputTestDataExcelPath, licensingSheetName);
		appCommonFunctions.selectRadioButton("Where do you plan to provide care?", 
				excelReader.getCellData(licensingSheetName, "Where do you plan to provide care?", inputDataIndex));
		appCommonFunctions.clickOnLink("Get Started");
		nonHomeOriginalLicenseApplicationPage.waitForFacilityInformationPageLoad();
		excelReader.setExcelFile(inputTestDataExcelPath, licensingSheetName);
		appCommonFunctions.enterInputTextFieldValue("Provider Facility Name", 
				excelReader.getCellData(licensingSheetName, "Provider Facility Name", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("FEIN", 
				excelReader.getCellData(licensingSheetName, "FEIN", inputDataIndex));
		appCommonFunctions.selectComboboxFieldDropDownValue("License Type", 
				excelReader.getCellData(licensingSheetName, "License Type", inputDataIndex));
		appCommonFunctions.selectComboboxFieldDropDownValue("Sub Service Type", 
				excelReader.getCellData(licensingSheetName, "Sub Service Type", inputDataIndex));
		logOutPage.logOut();
	}
}