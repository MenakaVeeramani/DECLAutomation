package com.DECL.Individual.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.ApplicationCommonFunctions;
import com.DECL.commonPages.Constants;
import com.DECL.commonPages.LogInPage;
import com.DECL.commonPages.LogOutPage;
import com.DECL.config.InitiateApplication;
import com.DECL.pages.HomeOriginalLicenseApplicationPage2;
import com.DECL.pages.HomePage;
import com.DECL.pages.HouseholdMemberInformation;
import com.DECL.utils.ConfigurationFileReader;
import com.DECL.utils.ExcelReader;

@Listeners(com.DECL.config.Listeners.class)
public class BasicHome extends InitiateApplication {

	@FindBy(xpath = "//*[@id='combobox-button-723' and @name='County__c']")
	WebElement countyDropDwn;
	@FindBy(id = "CustomerInfo_Countrys")
	WebElement countryselectbyText;

	@FindBy(xpath = "(//*[@class='qris-text-body_small qris-m-bottom_medium'])[3]")
	WebElement SSN1;

	WebDriver driver;

	@Test
	@Parameters({ "inputDataIndex" })
	public void basicFlow(int inputDataIndex) throws Exception {

		driver = getDriver();
		HomePage homePage = new HomePage(driver);
		ExcelReader excelReader = new ExcelReader();
		LogInPage logInPage = new LogInPage(driver);
		LogOutPage logOutPage = new LogOutPage(driver);
		ActionDriver actionDriver = new ActionDriver(driver);
		ConfigurationFileReader configFileReader = new ConfigurationFileReader();
		ApplicationCommonFunctions appCommonFunctions = new ApplicationCommonFunctions(driver);
		HomeOriginalLicenseApplicationPage2 HomeOriginalLicenseApplicationPage2 = new HomeOriginalLicenseApplicationPage2(
				driver);
		// HouseholdMemberInformation HouseholdMemberInformation = new
		// HouseholdMemberInformation(driver);
		String inputTestDataExcelPath = Constants.INPUT_TESTDATA_PATH;
		String homelicensingSheetName = Constants.homelicensingSheetName;
		String paymentpage = Constants.paymentpage;
		String newhouseholdmemberSheetName = Constants.newhouseholdmemberSheetName;
		gotoApplication(configFileReader.getApplicationUrl());
		logInPage.logInAsUser("PROGRAM USER", configFileReader.getApplicationOrg());
		homePage.clickOnLicensingTile();
		Thread.sleep(2000);
		actionDriver.switchToChildWindow();
		appCommonFunctions.clickOnLink("START A NEW FORM");
		appCommonFunctions.clickOnNeutralButton("View");
		appCommonFunctions.clickOnButton("Start New full application");
		excelReader.setExcelFile(inputTestDataExcelPath, homelicensingSheetName);
		excelReader.setExcelFile(inputTestDataExcelPath, newhouseholdmemberSheetName);
		appCommonFunctions.selectRadioButton("Where do you plan to provide care?",
				excelReader.getCellData(homelicensingSheetName, "Where do you plan to provide care?", inputDataIndex));
		appCommonFunctions.clickOnLink("Get Started");
		// section A
		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad();
		excelReader.setExcelFile(inputTestDataExcelPath, homelicensingSheetName);
		appCommonFunctions.selectCheckboxFieldValue1("I certify that I have downloaded the authorization form.");
		appCommonFunctions.selectRadioButton("Select your reason for submitting the application:",
				excelReader.getCellData(homelicensingSheetName, "Select your reason for submitting the application:",
						inputDataIndex));
		appCommonFunctions.selectRadioButton("Select the type of home license that you are applying for:",
				excelReader.getCellData(homelicensingSheetName,
						"Select the type of home license that you are applying for:", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("Facility Phone Number",
				excelReader.getCellData(homelicensingSheetName, "Facility Phone Number", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("Primary Email Address",
				excelReader.getCellData(homelicensingSheetName, "Primary Email Address", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("First Name",
				excelReader.getCellData(homelicensingSheetName, "First Name", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("Last Name",
				excelReader.getCellData(homelicensingSheetName, "Last Name", inputDataIndex));

		// WebElement SSN1 =
		// driver.findElement(By.xpath("(//*[@data-name='Does_Applicant_1_have_a_SSN__c'])"));

		//Thread.sleep(5000);
		//appCommonFunctions.selectRadioButtonByDataName(paymentpage, newhouseholdmemberSheetName);
		appCommonFunctions.selectRadioButton("Do you have a Social Security Number?", excelReader
				.getCellData(homelicensingSheetName, "Do you have a Social Security Number?1", inputDataIndex));
		Thread.sleep(3000);
		String SSNITIN1 = excelReader.getCellData(homelicensingSheetName, "Do you have a Social Security Number?1",
				inputDataIndex);
		if (SSNITIN1.equals("Yes")) {
			appCommonFunctions.enterInputTextFieldValue("Applicant 1 Social Security Number", excelReader
					.getCellData(homelicensingSheetName, "Applicant 1 Social Security Number", inputDataIndex));
		} else {
			appCommonFunctions.enterInputTextFieldValue("Applicant 1 ITIN (Individual Taxpayer Identification Number)",
					excelReader.getCellData(homelicensingSheetName,
							"Applicant 1 ITIN (Individual Taxpayer Identification Number)", inputDataIndex));
		}
		WebElement dobTextBox = driver.findElement(By.xpath("//*[@name='a365c0000021mEqAAI']"));
		dobTextBox.clear();
		dobTextBox.sendKeys(excelReader.getCellData(homelicensingSheetName, "Date of Birth", inputDataIndex));
		dobTextBox.sendKeys(Keys.TAB);

		appCommonFunctions.selectComboboxFieldDropDownValue("Gender",
				excelReader.getCellData(homelicensingSheetName, "Gender", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("FEIN",
				excelReader.getCellData(homelicensingSheetName, "FEIN", inputDataIndex));
		appCommonFunctions.selectRadioButton(
				"Have you been convicted or entered into a deferred sentence for ANY felony offense, ANY child abuse, or unlawful sexual behavior (in ANY state) before?",
				excelReader.getCellData(homelicensingSheetName,
						"Have you been convicted or entered into a deferred sentence for ANY felony offense, ANY child abuse, or unlawful sexual behavior (in ANY state) before?",
						inputDataIndex));
		appCommonFunctions.selectRadioButton(
				"Will your spouse/significant other  or another adult in the home be responsible for care of children served?",
				excelReader.getCellData(homelicensingSheetName,
						"Will your spouse/significant other  or another adult in the home be responsible for care of children served?",
						inputDataIndex));
		Thread.sleep(5000);
		appCommonFunctions.clickOnTextField("Applicant 1 Signature");
		appCommonFunctions.enterInputTextFieldValue("Applicant 1 Signature",
				excelReader.getCellData(homelicensingSheetName, "Applicant 1 Signature", inputDataIndex));
		appCommonFunctions.SignatureOperation();
		appCommonFunctions.clickOnButton("Save");

		String Spouse = excelReader.getCellData(homelicensingSheetName,
				"Will your spouse/significant other  or another adult in the home be responsible for care of children served?",
				inputDataIndex);

		if (Spouse.equals("Yes")) {
			//// *[@data-name='First_Name_2__c']/label[contains(text(),'Applicant 2 First
			//// Name')]
			appCommonFunctions.enterInputTextFieldValue("Applicant 2 First Name",
					excelReader.getCellData(homelicensingSheetName, "Applicant 2 First Name", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Applicant 2 Last Name",
					excelReader.getCellData(homelicensingSheetName, "Applicant 2 Last Name", inputDataIndex));
			/*
			 * appCommonFunctions.
			 * selectRadioButton("(//*[@class='qris-text-body_small qris-m-bottom_medium'])[6]"
			 * , excelReader .getCellData(homelicensingSheetName,
			 * "Do you have a Social Security Number?2", inputDataIndex)); String SSNITIN2 =
			 * excelReader.getCellData(homelicensingSheetName,
			 * "Do you have a Social Security Number?2", inputDataIndex);
			 * 
			 */
			String SSNITIN2 = excelReader.getCellData(homelicensingSheetName, "Do you have a Social Security Number?2",
					inputDataIndex);
			if (SSNITIN2.equals("Yes")) {
				driver.findElement(By.xpath("//*[@data-name='Does_Applicant_2_have_a_SSN__c']/fieldset/div/span[1]"))
						.click();
				appCommonFunctions.enterInputTextFieldValue("Applicant 2 Social Security Number", excelReader
						.getCellData(homelicensingSheetName, "Applicant 2 Social Security Number", inputDataIndex));
			} else {
				driver.findElement(By.xpath("//*[@data-name='Does_Applicant_2_have_a_SSN__c']/fieldset/div/span[2]"))
						.click();
				appCommonFunctions
						.enterInputTextFieldValue("Applicant 2 ITIN (Individual Taxpayer Identification Number))",
								excelReader.getCellData(homelicensingSheetName,
										"Applicant 2 ITIN (Individual Taxpayer Identification Number))",
										inputDataIndex));
			}
			// appCommonFunctions.selectRadioButtonByDataName(SSNITIN1, Spouse);
			/*
			 * WebElement SSN2 = driver.findElement(By.
			 * xpath("(//*[@class='qris-text-body_small qris-m-bottom_medium'])[6]"));
			 * //SSN2.clear(); SSN2.sendKeys(excelReader.getCellData(homelicensingSheetName,
			 * "Do you have a Social Security Number?2", inputDataIndex));
			 * 
			 * WebElement SSN2 = driver.findElement(By.
			 * xpath("(//*[@class='qris-text-body_small qris-m-bottom_medium'])[6]"));
			 * SSN2.click();
			 */
			Thread.sleep(5000);
			/*
			 * appCommonFunctions.selectRadioButton("SSN2", excelReader.getCellData(
			 * homelicensingSheetName,"Do you have a Social Security Number?2",
			 * inputDataIndex)); Thread.sleep(5000);
			 */


			WebElement dobTextBoxapp2 = driver.findElement(By.xpath("//*[@name='a365c0000021mbmAAA']"));
			dobTextBoxapp2.clear();
			dobTextBoxapp2.sendKeys(
					excelReader.getCellData(homelicensingSheetName, "Applicant 2 Date of Birth", inputDataIndex));
			dobTextBoxapp2.sendKeys(Keys.TAB);

			appCommonFunctions.selectComboboxFieldDropDownValue("Applicant 2 Gender",
					excelReader.getCellData(homelicensingSheetName, "Applicant 2 Gender", inputDataIndex));
			appCommonFunctions.selectRadioButton(
					"Has this person been convicted or entered into a deferred sentence for ANY felony offense, ANY child abuse, or unlawful sexual behavior (in ANY state) before?",
					excelReader.getCellData(homelicensingSheetName,
							"Have you been convicted or entered into a deferred sentence for ANY felony offense, ANY child abuse, or unlawful sexual behavior (in ANY state) before?",
							inputDataIndex));
			appCommonFunctions.clickOnTextField("Applicant 2 Signature");
			appCommonFunctions.enterInputTextFieldValue("Applicant 2 Signature",
					excelReader.getCellData(homelicensingSheetName, "Applicant 2 Signature", inputDataIndex));
			appCommonFunctions.SignatureOperation();
			appCommonFunctions.clickOnButton("Save");

		}

		appCommonFunctions.clickOnButton("Next");

		// section B

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad2();
		appCommonFunctions.selectRadioButton("Have you previously held a license to provide childcare in Colorado?",
				excelReader.getCellData(homelicensingSheetName,
						"Have you previously held a license to provide childcare in Colorado?", inputDataIndex));
		String Haveyou = excelReader.getCellData(homelicensingSheetName,
				"Have you previously held a license to provide childcare in Colorado?", inputDataIndex);

		if (Haveyou.equals("Yes")) {
			appCommonFunctions.enterInputTextFieldValue("Prior License Name",
					excelReader.getCellData(homelicensingSheetName, "Prior License Name", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Prior Street Address",
					excelReader.getCellData(homelicensingSheetName, "Prior Street Address", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Prior City",
					excelReader.getCellData(homelicensingSheetName, "Prior City", inputDataIndex));
			appCommonFunctions.selectComboboxFieldDropDownValue("Prior State",
					excelReader.getCellData(homelicensingSheetName, "Prior State", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Prior Zip Code",
					excelReader.getCellData(homelicensingSheetName, "Prior Zip Code", inputDataIndex));
		}

		appCommonFunctions.clickOnButton("Next");

		// section C

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad3();
		Thread.sleep(5000);

		String NewMember = excelReader.getCellData(homelicensingSheetName, "New Member", inputDataIndex);

		if (NewMember.equals("YES")) {
			appCommonFunctions.clickOnButton("New");
			
			//householdMemberInformation.waitForNewHouseholdMemberInfoPageLoad();
			appCommonFunctions.enterInputTextFieldValue("FIRST NAME",
					excelReader.getCellData(newhouseholdmemberSheetName, "FIRST NAME", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("LAST NAME",
					excelReader.getCellData(newhouseholdmemberSheetName, "LAST NAME", inputDataIndex));
			appCommonFunctions.selectRadioButton("Does this person have a Social Security Number?",
					excelReader.getCellData(newhouseholdmemberSheetName,
							"Does this person have a Social Security Number?", inputDataIndex));
			WebElement dobTextBox2 = driver.findElement(By.xpath("//*[@id='input-844' and @type='text']"));
			dobTextBox2.clear();
			dobTextBox2.sendKeys(excelReader.getCellData(newhouseholdmemberSheetName, "Date of Birth", inputDataIndex));
			dobTextBox2.sendKeys(Keys.TAB);
			appCommonFunctions.selectComboboxFieldDropDownValue("Gender",
					excelReader.getCellData(newhouseholdmemberSheetName, "Gender", inputDataIndex));
			appCommonFunctions.selectComboboxFieldDropDownValue("Relationship to Applicant",
					excelReader.getCellData(newhouseholdmemberSheetName, "Relationship to Applicant", inputDataIndex));
			appCommonFunctions.clickOnButton("Save");

		}

		appCommonFunctions.clickOnButton("Next");

		// section D

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad4();
		appCommonFunctions.enterInputTextFieldValue("Street Address",
				excelReader.getCellData(homelicensingSheetName, "Street Address", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("City",
				excelReader.getCellData(homelicensingSheetName, "City", inputDataIndex));
		appCommonFunctions.enterInputTextFieldValue("Zip Code",
				excelReader.getCellData(homelicensingSheetName, "Zip Code", inputDataIndex));
		/*
		 * appCommonFunctions.selectComboboxFieldDropDownValueGeneric(countyDropDwn,
		 * excelReader.getCellData(homelicensingSheetName, "County", inputDataIndex));
		 */

		WebElement County = driver.findElement(By.xpath("//*[@name='County__c']/span"));
		County.click();
		appCommonFunctions.selectComboboxFieldDropDownValue("County",
				excelReader.getCellData(homelicensingSheetName, "County", inputDataIndex));

		appCommonFunctions.selectRadioButton("Is your mailing address the same as your physical location address?",
				excelReader.getCellData(homelicensingSheetName,
						"Is your mailing address the same as your physical location address?", inputDataIndex));
		/*
		 * String MailingAddress = excelReader.getCellData(homelicensingSheetName,
		 * "Is your mailing address the same as your physical location address?",
		 * inputDataIndex); if (MailingAddress.equals("NO")) {
		 * appCommonFunctions.enterInputTextFieldValue("Street Address",
		 * excelReader.getCellData(homelicensingSheetName, "Street Address",
		 * inputDataIndex)); appCommonFunctions.enterInputTextFieldValue("City",
		 * excelReader.getCellData(homelicensingSheetName, "City", inputDataIndex));
		 * WebElement MailingState =
		 * driver.findElement(By.xpath("//*[ @name='Mailing_State__c']/span"));
		 * MailingState.click();
		 * appCommonFunctions.selectComboboxFieldDropDownValue("Mailing State",
		 * excelReader.getCellData(homelicensingSheetName, "Mailing State",
		 * inputDataIndex)); appCommonFunctions.enterInputTextFieldValue("Zip Code",
		 * excelReader.getCellData(homelicensingSheetName, "Zip Code", inputDataIndex));
		 * }
		 */
		appCommonFunctions.selectRadioButton("Operates Monday to Friday?",
				excelReader.getCellData(homelicensingSheetName, "Operates Monday to Friday?", inputDataIndex));

		WebElement starttime = driver.findElement(By.xpath("//*[@name='a365c0000021mH9AAI']"));
		starttime.sendKeys(excelReader.getCellData(homelicensingSheetName, "Monday-Friday Start Time", inputDataIndex));
		WebElement endtime = driver.findElement(By.xpath("//*[@name='a365c0000021mH8AAI']"));
		endtime.sendKeys(excelReader.getCellData(homelicensingSheetName, "Monday-Friday End Time", inputDataIndex));

		appCommonFunctions.selectRadioButton("Operates Year round Only?",
				excelReader.getCellData(homelicensingSheetName, "Operates Year round Only?", inputDataIndex));
		appCommonFunctions.selectRadioButton("Open Summer Only?",
				excelReader.getCellData(homelicensingSheetName, "Open Summer Only?", inputDataIndex));
		appCommonFunctions.selectRadioButton("Open School Year Only?",
				excelReader.getCellData(homelicensingSheetName, "Open School Year Only?", inputDataIndex));
		Thread.sleep(3000);
		appCommonFunctions.clickOnButton("Next");
		Thread.sleep(3000);

		// section E

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad5();
		WebElement POA = driver.findElement(By.xpath("//*[@name='Authorization']/following-sibling::label[1]/span"));
		POA.click();
		Thread.sleep(2000);
		// String Spouse1 = excelReader.getCellData(homelicensingSheetName,"Will your
		// spouse/significant other or another adult in the home be responsible for care
		// of children served?" , inputDataIndex);
		if (Spouse.equals("Yes")) {
			WebElement POA1 = driver
					.findElement(By.xpath("(//*[@name='Authorization']/following-sibling::label[1]//span)[3]"));
			POA1.click();
		}
		Thread.sleep(3000);
		appCommonFunctions.clickOnButton("Next");
		Thread.sleep(3000);

		// section F

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad6();
		appCommonFunctions.selectCheckboxFieldValue1(
				"I have read and am fully familiar with the licensing rules regulating family care homes and/or the general rules and regulations for child care facilities issued by the Colorado Department of Early Childhood (CDEC) and I agree to fully comply with them.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that until a license is issued, it is illegal for me to care for children other than specified in Statute or specifically listed under the exemptions in the general rules and regulations.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that before a child care license is issued, a licensing inspection must be completed. I agree to cooperate with the Department in its inspection to determine conformity with the regulations. I understand that if issued a child care license, it will designate the number and ages of children for which care may be given. Further, I understand that if I fail to maintain the rules and regulations, the license is subject to revocation.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I authorize the Colorado Department of Early Childhood (CDEC) to run the child abuse and neglect check for all people listed as living in the family child care home, regardless of age, including myself.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I authorize the Colorado Department of Early Childhood (CDEC) to obtain child abuse and neglect reports for all people listed on this application, regardless of age, upon initial licensure and every five years thereafter.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that the applicant(s) AND any person 18 years of age or older who resides in the family care home are required to submit a complete set of fingerprints to the Colorado Bureau of Investigation (CBI) for a criminal check of CBI and FBI records.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that those who require fingerprinting are responsible for paying for all fingerprinting costs.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that all adults who submit fingerprints for this license must sign the Privacy Act Notification prior to, or at the time of, being fingerprinted. I also understand the Privacy Act Notification must be maintained at the licensed child care home and made available to the Department upon request.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand and authorize the Department to check the status of any fingerprints for people listed as living in the family child care home through the approved fingerprint vendor.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I agree to adhere to the non-discrimination provisions of Title VI of the Civil Rights Act of 1964, the Age Discrimination Act of 1975, the Rehabilitation Act of 1973, and Titles I through V of the Americans with Disabilities Act, as amended, and their implementation regulations which prohibit discrimination on the grounds of race, color, national origin, age, or disability.");
		appCommonFunctions.selectCheckboxFieldValue1(
				"I understand that upon receipt by the Colorado Department of Early Childhood, this application becomes a public record.");

		WebElement Iclarify = driver.findElement(By.xpath(
				"//span[text()='The responses I provide on this application are correct to the best of my ability. I understand that providing false information to the Colorado Department of Early Childhood could result in my being fined as much as $100 a day to a maximum of $10,000.']//ancestor::span//span[contains(@class,'slds-checkbox_faux')]"));
		Iclarify.click(); 

		// appCommonFunctions.selectCheckboxFieldValue1("The responses I provide on this
		// application are correct to the best of my ability. I understand that
		// providing false information to the Colorado Department of Human Services
		// could result in my being fined as much as $100 a day to a maximum of
		// $10,000.");

		appCommonFunctions.clickOnTextField("Signature of Applicant 1 (Primary Applicant)");
		appCommonFunctions.enterInputTextFieldValue("Signature of Applicant 1 (Primary Applicant)", excelReader
				.getCellData(homelicensingSheetName, "Signature of Applicant 1 (Primary Applicant)", inputDataIndex));
		appCommonFunctions.SignatureOperation();
		appCommonFunctions.clickOnButton("Save");
		// String Spouse2 = excelReader.getCellData(homelicensingSheetName,"Will your
		// spouse/significant other or another adult in the home be responsible for care
		// of children served?", inputDataIndex);
		if (Spouse.equals("Yes")) {
			appCommonFunctions.clickOnTextField("Signature of Applicant 2 (Secondary Applicant)");
			appCommonFunctions.enterInputTextFieldValue("Signature of Applicant 2 (Secondary Applicant)",
					excelReader.getCellData(homelicensingSheetName, "Signature of Applicant 2 (Secondary Applicant)",
							inputDataIndex));
			appCommonFunctions.SignatureOperation();
			appCommonFunctions.clickOnButton("Save");
		}

		appCommonFunctions.clickOnButton("Next");

		// section G
		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad7();
		String Licensetype = excelReader.getCellData(homelicensingSheetName,
				"Select the type of home license that you are applying for:", inputDataIndex);

		if (Licensetype.equals("Experienced Child Care Provider (ECCP)")) {

			appCommonFunctions.selectCheckboxFieldValue1(
					"I affirm that I have been a family child care home provider in Colorado for at least the last 6 consecutive years.");
			appCommonFunctions.selectCheckboxFieldValue1(
					"I affirm that I have completed 90 clock hours of training (excluding Universal Precautions, First Aid and CPR, and Medication Administration) within the preceding 6 years, including the State Department approved Infant and Toddler course.");
			appCommonFunctions.selectCheckboxFieldValue1(
					"I affirm that I have had no negative licensing action taken against my license in the preceding 2 years. I affirm that I am in compliance with local zoning restrictions.");
			appCommonFunctions.selectCheckboxFieldValue1(
					"I affirm that I am in compliance with all rules regulating Experienced Family Child Care Home Providers, as well as, all other rules regulating Family Child Care Home Providers.");
			appCommonFunctions.clickOnTextField("Signature of Applicant 1 (Primary Applicant)");
			/*
			 * appCommonFunctions.
			 * enterInputTextFieldValue("Signature of Applicant 1 (Primary Applicant)",
			 * excelReader.getCellData(homelicensingSheetName,
			 * "Signature of Applicant 1 (Primary Applicant)", inputDataIndex));
			 * appCommonFunctions.SignatureOperation();
			 * appCommonFunctions.clickOnButton("Save");
			 */
		}
		appCommonFunctions.clickOnButton("Next");

		// summary section
		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad8();
		appCommonFunctions.clickOnButton("Print PDF");
		Thread.sleep(3000);
		actionDriver.switchToParentWindow();
		//HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad7();
		//Thread.sleep(2000);

		// payment section

		appCommonFunctions.clickOnButton("Next");

		HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad9();
		//WebElement paymentpage22 = driver.findElement(By.xpath(""));
		//appCommonFunctions.waitforelementToLoad(driver, By.xpath("//*[@class='qris-text-header2' and contains(text(),'Payment')]"), 10);
		appCommonFunctions.selectRadioButton(
				"Please select your payment option below. Different information and instructions will appear after the method of payment has been selected.",
				excelReader.getCellData(homelicensingSheetName,
						"Please select your payment option below. Different information and instructions will appear after the method of payment has been selected.",
						inputDataIndex));
		//Thread.sleep(30000);
		String Paymenttype = excelReader.getCellData(homelicensingSheetName,
				"Please select your payment option below. Different information and instructions will appear after the method of payment has been selected.",
				inputDataIndex);

		if (Paymenttype.equals("Pay with Credit Card OR eCheck Online")) {
			appCommonFunctions.clickOnButton("Submit & Proceed to Payment");
			
			//actionDriver.switchToPaymentWindow();
			
			HomeOriginalLicenseApplicationPage2.waitForGeneralApplicationandHouseholdInformationPageLoad10();
			//WebElement countryDrpDown = driver.findElement(By.id("CustomerInfo_Country"));
			ApplicationCommonFunctions.selectfromDropdownByText(driver, By.id("CustomerInfo_Country"), 
					excelReader.getCellData(paymentpage, "Country *", inputDataIndex));
			
			ApplicationCommonFunctions.selectFieldByText(driver, By.id("CustomerInfo_FirstName"), 
					excelReader.getCellData(paymentpage, "First Name *", inputDataIndex));
			 
			/*
			 * //appCommonFunctions.selectComboboxPaymentFieldDropDownValue("Country *",
			 * appCommonFunctions.enterInputTextFieldValue("First Name *",
			 * excelReader.getCellData(paymentpage, "First Name *", inputDataIndex));
			 */
			appCommonFunctions.enterInputTextFieldValue("Last Name *",
					excelReader.getCellData(paymentpage, "Last Name *", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Company Name",
					excelReader.getCellData(paymentpage, "Company Name", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Address *",
					excelReader.getCellData(paymentpage, "Address *", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("City *",
					excelReader.getCellData(paymentpage, "City *", inputDataIndex));
			appCommonFunctions.selectComboboxFieldDropDownValue("State",
					excelReader.getCellData(paymentpage, "State", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("ZIP/Postal Code *",
					excelReader.getCellData(paymentpage, "ZIP/Postal Code *", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Phone Number *",
					excelReader.getCellData(paymentpage, "Phone Number *", inputDataIndex));
			appCommonFunctions.enterInputTextFieldValue("Email *",
					excelReader.getCellData(paymentpage, "Email *", inputDataIndex));
			appCommonFunctions.clickOnButton("Next");

		}

		else if (Paymenttype.equals("Mail in Check")) {
			
			appCommonFunctions.clickOnButton("Submit Application");
			
		}
		Thread.sleep(30000);
		appCommonFunctions.clickOnButton("Close");

		
		// logOutPage.logOut();
	}
}