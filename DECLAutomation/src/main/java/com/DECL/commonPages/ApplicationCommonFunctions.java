package com.DECL.commonPages;

import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.apache.tools.ant.taskdefs.Ant.TargetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DECL.config.InitiateApplication;
import com.relevantcodes.extentreports.LogStatus;

public class ApplicationCommonFunctions extends BasePage {
	public ApplicationCommonFunctions(WebDriver driver) {
		super(driver);
	}

	ActionDriver actionDriver = new ActionDriver(driver);

	@FindBy(xpath = "//button[contains(@class,'today')]")
	WebElement todayLink;

	@FindBy(xpath = "//div[contains(@class,'active')]//span[text()='Ignore']//ancestor::records-record-layout-checkbox//input[@name='Ignore__c']")
	WebElement ignoreCheckbox;

	@FindBy(xpath = "//*[@aria-haspopup='listbox' and @name='County__c']/span")
	WebElement countyDropDwn;

	private static final String neutralButtonLocator = "//button[contains(@class,'button_neutral') and text()='##BUTTON_NAME##']";

	private static final String buttonLocator = "//button[contains(@class,'button') and text()='##BUTTON_NAME##']";

	private static final String inputTextFieldLocator = "//*[text()='##FIELD_NAME##']//ancestor::lightning-input//input";

	private static final String linkLocator = "//a[text()='##LINK_NAME##']";

	private static final String fieldLocator = "//*[text()='##FIELD_NAME##']//..//input";

	// private static final String fieldNameLocator =
	// "//*[class()='##FIELD_NAME##']";

	private static final String radioButtonLocator = "//*[contains(text(),'##FIELD_NAME##')]"
			+ "//..//span[text()='##FIELD_VALUE##']//ancestor::span//span[contains(@class,'radio_faux')]";

	private static final String radioFieldDataNameLocator = "//*[contains(data-name(),'##FIELD_NAME##']"
			+ "//..//span[text()='##FIELD_VALUE##']//ancestor::span//span[contains(@class,'radio_faux')]";

	private static final String checkboxFieldLocator = "//span[text()='##CHECKBOX_FIELD##']//ancestor::span//span[contains(@class,'slds-checkbox_faux')]";

	private static final String checkboxFieldLocatorauth = "//*[@name='Authorization']/following-sibling::label[1]/span\"";

	private static final String comboboxFieldLocator = "//*[text()='##FIELD_NAME##']//ancestor::lightning-combobox//button";
	
	private static final String comboboxPaymentFieldLocator = "//*[text()='##FIELD_NAME##']";

	private static final String comboboxFieldValueLocator = "//div[contains(@id,'dropdown')]//lightning-base-combobox-item//span[@title='##FIELD_VALUE##']";
	
	private static final String comboboxPaymentFieldValueLocator = "//*[text()='##FIELD_VALUE##']";

	/**
	 * <p>
	 * Public: Method is to click on Neutral Button
	 * </p>
	 * 
	 * @param buttonName
	 * @author protta
	 * @throws Exception
	 */
	public void clickOnNeutralButton(String buttonName) throws Exception {
		String neutralButton = neutralButtonLocator.replaceAll("##BUTTON_NAME##", buttonName);
		WebElement neutralButtonElement = actionDriver.findElement(neutralButton);
		actionDriver.waitforElement(neutralButtonElement, buttonName + " Button");
		actionDriver.jsClick(neutralButtonElement, buttonName + " Button");
	}

	/**
	 * <p>
	 * Public: Method is to click on Neutral Button
	 * </p>
	 * 
	 * @param buttonName
	 * @author protta
	 * @throws Exception
	 */
	public void clickOnButton(String buttonName) throws Exception {
		String button = buttonLocator.replaceAll("##BUTTON_NAME##", buttonName);
		WebElement buttonElement = actionDriver.findElement(button);
		actionDriver.waitforElement(buttonElement, buttonName + " Button");
		actionDriver.jsClick(buttonElement, buttonName + " Button");
	}

	/**
	 * <p>
	 * Public: Method is to click on Neutral Button
	 * </p>
	 * 
	 * @param buttonName
	 * @author protta
	 * @throws Exception
	 */
	public void clickOnTextField(String fieldName) throws Exception {
		String field = fieldLocator.replaceAll("##FIELD_NAME##", fieldName);
		WebElement fieldElement = actionDriver.findElement(field);
		actionDriver.waitforElement(fieldElement, fieldName + " Field");
		actionDriver.jsClick(fieldElement, fieldName + " Field");
	}
	/*
	 * public void findTextFieldName(String fieldName) throws Exception{ String
	 * field = fieldNameLocator.replaceAll("##FIELD_NAME##", fieldName); WebElement
	 * fieldElement = actionDriver.findElement(field);
	 * actionDriver.waitforElement(fieldElement, fieldName+" Field");
	 * actionDriver.jsClick(fieldElement, fieldName+" Field"); }
	 */

	/*
	 * public void selectRadioButtonssn(String fieldName, String fieldValue) throws
	 * Exception{ String radioFieldNameLocatorssn =
	 * fieldNameLocator.replaceAll("##FIELD_NAME##", fieldName);
	 * radioFieldNameLocatorssn =
	 * radioFieldNameLocatorssn.replaceAll("##FIELD_VALUE##", fieldValue);
	 * WebElement radioFieldNameElementssn =
	 * actionDriver.findElementWithoutException(radioFieldNameLocatorssn);
	 * actionDriver.jsClickWithoutException(radioFieldNameElementssn,
	 * fieldName+" field "+fieldValue+" Radio Button");
	 * actionDriver.captureLogInReport(LogStatus.PASS,
	 * "Selected "+fieldName+" field "+fieldValue+" Radio Button"); }
	 */
	public void clickOnCanvas(String canvas) throws Exception {
		WebElement canvasElement = actionDriver.findCanvasElement(canvas);
		actionDriver.waitforElement(canvasElement, canvas + " Canvas");
		actionDriver.dragAndDrop(canvasElement, 200, 0).build().perform();

	}

	/**
	 * <p>
	 * Public: Method is to click on Link
	 * </p>
	 * 
	 * @param buttonName
	 * @author protta
	 * @throws Exception
	 */
	public void clickOnLink(String linkName) throws Exception {
		String link = linkLocator.replaceAll("##LINK_NAME##", linkName);
		List<WebElement> linkElement = actionDriver.findElements(link);
		actionDriver.waitforElements(linkElement, linkName + " Link");
		actionDriver.jsClick(linkElement.get(0), linkName + " Link");
	}

	/**
	 * <p>
	 * Public: Method is to select Radio button field value
	 * </p>
	 * 
	 * @param fieldName, fieldValue
	 * @author protta
	 * @throws Exception
	 */
	public void selectRadioButton(String fieldName, String fieldValue) throws Exception {
		String radioFieldNameLocator = radioButtonLocator.replaceAll("##FIELD_NAME##", fieldName);
		radioFieldNameLocator = radioFieldNameLocator.replaceAll("##FIELD_VALUE##", fieldValue);
		WebElement radioFieldNameElement = actionDriver.findElementWithoutException(radioFieldNameLocator);
		actionDriver.jsClickWithoutException(radioFieldNameElement,fieldName + " field " + fieldValue + " Radio Button");
		actionDriver.captureLogInReport(LogStatus.PASS,"Selected " + fieldName + " field " + fieldValue + " Radio Button");
	}
	
	public void waitforelementToLoad(WebDriver driver, By paymentpage22, int sec) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.presenceOfElementLocated(paymentpage22));
	}
	/*
	 * public void selectRadioButton(String fieldName, String fieldValue, String
	 * akash) throws Exception { String radioFieldNameLocator =
	 * radioButtonLocator.replaceAll("##FIELD_NAME##", fieldName);
	 * radioFieldNameLocator = radioFieldNameLocator.replaceAll("##FIELD_VALUE##",
	 * fieldValue); WebElement radioFieldNameElement =
	 * actionDriver.findElementWithoutException(radioFieldNameLocator);
	 * actionDriver.jsClickWithoutException(radioFieldNameElement,fieldName +
	 * " field " + fieldValue + " Radio Button");
	 * actionDriver.captureLogInReport(LogStatus.PASS,"Selected " + fieldName +
	 * " field " + fieldValue + " Radio Button"); }
	 */

	//public void selectRadioButtonByDataName(String fieldName, String YesNo) throws Exception {
	/*
	 * public void selectRadioButtonByDataName(String dataname, String fieldValue)
	 * throws Exception {
	 * 
	 * WebElement webeledup = driver.findElement(By.xpath(
	 * "//*[@data-name='Does_Applicant_2_have_a_SSN__c']")); int i = 0;
	 * 
	 * if(fieldValue=="Yes") i = 1; else i = 2;
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@data-name='++fieldname++']/fieldset/div/span['"+i+"']"));
	 * 
	 * 
	 * }
	 */

	/**
	 * <p>
	 * Public: Method is to enter value in input field
	 * </p>
	 * 
	 * @param fieldName, fieldValue
	 * @author protta
	 * @throws Exception
	 */
	public void enterInputTextFieldValue(String fieldName, String fieldValue) throws Exception {
		String inputFieldLocator = inputTextFieldLocator.replaceAll("##FIELD_NAME##", fieldName);
		WebElement fieldNameElement = actionDriver.findElementWithoutException(inputFieldLocator);

		actionDriver.waitforElementWithoutException(fieldNameElement, fieldName);
		actionDriver.clearWithoutException(fieldNameElement, fieldName);
		actionDriver.typeWithoutException(fieldNameElement, fieldName, fieldValue);
	}

	InitiateApplication initiate = new InitiateApplication();

	public void SignatureOperation() {
		Actions builder = new Actions(initiate.getDriver());
		WebElement canvasElement = initiate.getDriver().findElement(By.xpath("//*[@name='canvasItem']"));
		Action signature = builder.contextClick(canvasElement).clickAndHold().moveToElement(canvasElement, 20, -50)
				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release(canvasElement).build();
		signature.perform();
	}

	/**
	 * <p>
	 * Public: Method is to select field value from combobox drop down menu
	 * </p>
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @author protta
	 * @throws Exception
	 */
	public void selectComboboxFieldDropDownValue(String fieldName, String fieldValue) throws Exception {
		String comboboxDropDownFieldNameOptions = comboboxFieldLocator.replace("##FIELD_NAME##", fieldName);
		List<WebElement> dropDownFieldNameElements = actionDriver
				.findElementsWithoutException(comboboxDropDownFieldNameOptions);
		actionDriver.waitforElementsWithoutException(dropDownFieldNameElements, fieldName);
		actionDriver.jsClickWithoutException(dropDownFieldNameElements, fieldName + " dropdown field", 0);
		String dropDownFieldValuesOptions = comboboxFieldValueLocator.replace("##FIELD_VALUE##", fieldValue);
		List<WebElement> dropDownFieldValuesOptionElements = actionDriver
				.findElementsWithoutException(dropDownFieldValuesOptions);
		int lastElementNo = dropDownFieldValuesOptionElements.size() - 1;
		actionDriver.jsClickWithoutException(dropDownFieldValuesOptionElements,
				fieldName + " field dropdown value : " + fieldValue, lastElementNo);
	}
	
	public void selectComboboxPaymentFieldDropDownValue(String fieldName, String fieldValue) throws Exception {
		String comboboxDropDownPaymentFieldNameOptions = comboboxPaymentFieldLocator.replace("##FIELD_NAME##", fieldName);
		List<WebElement> dropDownPaymentFieldNameElements = actionDriver
				.findElementsWithoutException(comboboxDropDownPaymentFieldNameOptions);
		actionDriver.waitforElementsWithoutException(dropDownPaymentFieldNameElements, fieldName);
		actionDriver.jsClickWithoutException(dropDownPaymentFieldNameElements, fieldName + " dropdown field", 0);
		String dropDownPaymentFieldValuesOptions = comboboxPaymentFieldValueLocator.replace("##FIELD_VALUE##", fieldValue);
		List<WebElement> dropDownPaymentFieldValuesOptionElements = actionDriver
				.findElementsWithoutException(dropDownPaymentFieldValuesOptions);
		int lastElementNo = dropDownPaymentFieldValuesOptionElements.size() - 1;
		actionDriver.jsClickWithoutException(dropDownPaymentFieldValuesOptionElements,
				fieldName + " field dropdown value : " + fieldValue, lastElementNo);
	}
	
	public static void selectfromDropdownByText(WebDriver driver, By locator, String value) {
		
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void selectFieldByText(WebDriver driver, By locator, String value) {
		
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}

	public void selectComboboxFieldDropDownValueGeneric(WebElement fieldNameElement, String fieldName)
			throws Exception {
		/*
		 * String inputFieldLocator = inputTextFieldLocator.replaceAll("##FIELD_NAME##",
		 * fieldName); WebElement fieldNameElement =
		 * actionDriver.findElementWithoutException(inputFieldLocator);
		 */
		countyDropDwn.click();
		Thread.sleep(2000);
		countyDropDwn.sendKeys(Keys.ARROW_DOWN);
		countyDropDwn.sendKeys(Keys.ARROW_DOWN);
		countyDropDwn.sendKeys(Keys.ENTER);
		// countyDropDwn.sendKeys(Keys.ENTER);

	}

	/**
	 * <p>
	 * Public: Method is to select checkbox field value
	 * </p>
	 * 
	 * @param fieldValue
	 * @author mveeramani
	 * @throws Exception
	 */
	public void selectCheckboxFieldValue(String fieldValue) throws Exception {
		String checkboxFieldNameLocator = checkboxFieldLocatorauth.replaceAll("##CHECKBOX_FIELD##", fieldValue);
		List<WebElement> checkboxFieldNameElements = actionDriver.findElements(checkboxFieldNameLocator);
		actionDriver.ScrollIntoView(checkboxFieldNameElements.get(0), fieldValue + " Checkbox");
		actionDriver.jsClick(checkboxFieldNameElements.get(0), fieldValue + " Checkbox");
	}

	public void selectCheckboxFieldValue1(String fieldValue) throws Exception {
		String checkboxFieldNameLocator = checkboxFieldLocator.replaceAll("##CHECKBOX_FIELD##", fieldValue);
		List<WebElement> checkboxFieldNameElements = actionDriver.findElements(checkboxFieldNameLocator);
		actionDriver.ScrollIntoView(checkboxFieldNameElements.get(0), fieldValue + " Checkbox");
		actionDriver.jsClick(checkboxFieldNameElements.get(0), fieldValue + " Checkbox");
	}
	

}