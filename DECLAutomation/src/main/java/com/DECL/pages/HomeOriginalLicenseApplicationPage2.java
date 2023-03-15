package com.DECL.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DECL.commonPages.ActionDriver;
import com.DECL.commonPages.ApplicationCommonFunctions;
import com.DECL.commonPages.BasePage;

public class HomeOriginalLicenseApplicationPage2 extends BasePage{

	public HomeOriginalLicenseApplicationPage2(WebDriver driver) {
		super(driver);
	}

	ActionDriver actionDriver = new ActionDriver(driver);
	ApplicationCommonFunctions appCommonFunction = new ApplicationCommonFunctions(driver);

	@FindBy(xpath = "//p[text()='Section A: General Application and Household Information']")
	WebElement sectionAGeneralApplicationandHouseholdInformation;

	@FindBy(xpath = "//p[text()='Section B: Previous License Information']")
	WebElement SectionBPreviousLicenseInformation;
	
	@FindBy(xpath = "//p[text()='Section C: Household Member Information']")
	WebElement SectionCHouseholdMemberInformation;
	
	@FindBy(xpath = "//p[text()='Section D: Provider address and Operating information']")
	WebElement SectionDProvideraddressandOperatinginformation;

	@FindBy(xpath = "//p[text()='Section E: Background Authorization Information']")
	WebElement SectionEBackgroundAuthorizationInformation;
	
	@FindBy(xpath = "//p[text()='Section F: Application Acknowledgement']")
	WebElement SectionFApplicationAcknowledgement;
	
	@FindBy(xpath = "//p[text()='Section G: Experienced Child Care Provider']")
	WebElement SectionGExperiencedChildCareProvider;
	
	@FindBy(xpath = "//span[text()='I certify that I have downloaded the authorization form.']//ancestor::span//span[contains(@class,'slds-checkbox_faux')]")
	WebElement IcertifythatIhavedownloadedtheauthorizationform;
	
	@FindBy(xpath = "//p[text()=' Summary']")
	WebElement SummaryPage;
	
	@FindBy(xpath = "//p[text()=' Payment']")
	WebElement PaymentPage;
	
	@FindBy(xpath = "//*[@id=\"transactionDetailHeader\"]")
	WebElement TransactionDetailPage;
	
	
	/**
	 * <p>Public: Method is to wait for Section A: General Application and Household Information Page to load successfully.</p>
	 * @author protta
	 * @throws Exception 
	 */ 
	public void waitForGeneralApplicationandHouseholdInformationPageLoad() throws Exception{
		actionDriver.waitforElementWithoutException(sectionAGeneralApplicationandHouseholdInformation, "Section A: General Application and Household Information");
	}
	
	public void waitForGeneralApplicationandHouseholdInformationPageLoad2() throws Exception{
		actionDriver.waitforElementWithoutException(SectionBPreviousLicenseInformation, "Section B: Previous License Information");
	}
	
	/*
	 * public void verifyandselectCheckbox() throws Exception {
	 * 
	 * if(!IcertifythatIhavedownloadedtheauthorizationform.isSelected()) {
	 * appCommonFunction.
	 * selectCheckboxFieldValue("I certify that I have downloaded the authorization form."
	 * , "True" ); }
	 * 
	 * }
	 */
	public void waitForGeneralApplicationandHouseholdInformationPageLoad3() throws Exception{
		actionDriver.waitforElementWithoutException(SectionCHouseholdMemberInformation, "Section C: Household Member Information");
	}
	
	public void waitForGeneralApplicationandHouseholdInformationPageLoad4() throws Exception{
		actionDriver.waitforElementWithoutException(SectionDProvideraddressandOperatinginformation, "Section D: Provider address and Operating information");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad5() throws Exception{
		actionDriver.waitforElementWithoutException(SectionEBackgroundAuthorizationInformation, "Section E: Background Authorization Information");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad6() throws Exception{
		actionDriver.waitforElementWithoutException(SectionFApplicationAcknowledgement, "Section F: Application Acknowledgement");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad7() throws Exception{
		actionDriver.waitforElementWithoutException(SectionGExperiencedChildCareProvider, "Section G: Experienced Child Care Provider");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad8() throws Exception{
		actionDriver.waitforElementWithoutException(SummaryPage, "Summary");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad9() throws Exception{
		actionDriver.waitforElementWithoutException(PaymentPage, "Payment");
	}
	public void waitForGeneralApplicationandHouseholdInformationPageLoad10() throws Exception{
		actionDriver.waitforElementWithoutException(TransactionDetailPage, "Transaction Detail");
	}
}

