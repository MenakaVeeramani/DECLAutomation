package com.DECL.commonPages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.DECL.config.CustomAssertion;
import com.DECL.config.InitiateApplication;
import com.relevantcodes.extentreports.LogStatus;

public class ActionDriver extends BasePage{

	CustomAssertion customAssertion;
	public ActionDriver(WebDriver driver) {
		super(driver);
		customAssertion = new CustomAssertion();
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void jsClick(WebElement element, String elementName) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jse.executeScript("arguments[0].click();", element);
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
			throw e;
		}
	}
	/** Menaka **/
	public void  dragAndDropBy(WebElement canvaselement,int xoffset, int yoffset ) throws Exception{ 
		try {
			dragAndDropBy();			
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + canvaselement);
		}catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform Drag and Drop action on:  " + canvaselement);
		}
		}
	
	
	private Actions dragAndDropBy() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void jsClickWithoutException(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jse.executeScript("arguments[0].click();", element);
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void multiSelectJsClickWithoutException(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jse.executeScript("arguments[0].click();", element);
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}
	
	
	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void jsClickWithoutException(List<WebElement> elements, String elementName, int index) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));
			jse.executeScript("arguments[0].click();", elements.get(index));
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void click(WebElement element, String elementName) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void clickWithoutException(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void clickWithoutException(List<WebElement> elements, String elementName, int elementIndexNo) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elements.get(elementIndexNo)));
			elements.get(elementIndexNo).click();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void actionClick(WebElement element, String elementName) throws Exception {
		try {
			Actions action = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(element));
			action.click(element).build().perform();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void actionClickWithoutException(WebElement element, String elementName) {
		try {
			Actions action = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(element));
			action.click(element).build().perform();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to perform click on links, button, text boxes, checkbox and radio button</p>
	 *   @param element
	 *   @param elementName
	 *   @author protta
	 */ 
	public void actionClickWithoutException(List<WebElement> elements, String elementName, int index) {
		try {
			Actions action = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));
			action.click(elements.get(index)).build().perform();
			this.captureLogInReport(LogStatus.PASS, "Performed click action successfully on : " + elementName);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Perform click action on : " + elementName);
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void waitforElement(WebElement element, String elementName) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to wait for " + elementName +" element");
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void waitforElementWithoutException(WebElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, elementName +" element is not visible/displayed.");
		}
	}
	
	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void waitforElementWithoutException(List<WebElement> elements, String elementName, int index) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, elementName +" element is not visible/displayed.");
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Elements Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void waitforElements(List<WebElement> elements, String elementName) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to wait for " + elementName +" elements");
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Elements Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void waitforElementsWithoutException(List<WebElement> elements, String elementName){
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, elementName +" elements are not visible/displayed.");
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void isDisplayed(WebElement element, String elementName) throws Exception {
		Assert.assertTrue(element.isDisplayed(), elementName+" element is not displayed.");
		this.captureLogInReport(LogStatus.PASS, elementName+" is displayed.");
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void isDisplayedWithoutException(WebElement element, String elementName) {
		if(element.isDisplayed()) {
			this.captureLogInReport(LogStatus.PASS, elementName+" is displayed.");
		}
		else {
			this.captureLogInReport(LogStatus.FAIL, elementName+" element is not displayed.");
		}
	}
	
	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param element, elementName
	 *   @param elementIndex
	 *   @author protta
	 */
	public void isDisplayedWithoutException(List<WebElement> elements, String elementName, int elementIndex) {
		if(elements.get(elementIndex).isDisplayed()) {
			this.captureLogInReport(LogStatus.PASS, elementName+" is displayed.");
		}
		else {
			this.captureLogInReport(LogStatus.FAIL, elementName+" element is not displayed.");
		}
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param elementPath
	 *   @author protta
	 */
	public WebElement findElement(String elementPath) throws Exception {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(elementPath));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to find element path : " +elementPath);
			throw e;
		}
		return element;
	}
	/** Menaka **/
	public WebElement findCanvasElement(String canvaselementPath) throws Exception {
		WebElement canvaselement = null;
		try {
			canvaselement = driver.findElement(By.name("canvasItem"));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to find element path1 : " +canvaselementPath);
			throw e;
		}
		return canvaselement;
	}

	/**
	 *  <p>Public: Method is used to wait for Element Visibility</p>
	 *   @param elementPath
	 *   @author protta
	 */
	public WebElement findElementWithoutException(String elementPath) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(elementPath));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to find element path : " +elementPath);
		}
		return element;
	}

	/**
	 *  <p>Public: Method is used to wait for Elements Visibility</p>
	 *   @param elementsPath
	 *   @author protta
	 */
	public List<WebElement> findElements(String elementsPath) throws Exception {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(elementsPath));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to find elements path : " +elementsPath);
			throw e;
		}
		return elements;
	}

	/**
	 *  <p>Public: Method is used to wait for Elements Visibility</p>
	 *   @param elementsPath
	 *   @author protta
	 */
	public List<WebElement> findElementsWithoutException(String elementsPath) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(elementsPath));
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to find elements path : " +elementsPath);
		}
		return elements;
	}

	/**
	 *  <p>Public: Method is used to clear Input Element</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void clear(WebElement element, String elementName) throws Exception {
		try {
			waitforElement(element, elementName);
			element.clear();
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to clear " + elementName +" element");
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to clear Input Element</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void clearWithoutException(WebElement element, String elementName) {
		try {
			waitforElement(element, elementName);
			element.clear();
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to clear " + elementName +" element");
		}
	}
	
	/**
	 *  <p>Public: Method is used to clear Input Element</p>
	 *   @param element, elementName
	 *   @author protta
	 */
	public void clearWithoutException(List<WebElement> elements, String elementName, int index) {
		try {
			waitforElements(elements, elementName);
			elements.get(index).clear();
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to clear " + elementName +" element");
		}
	}

	/**
	 *  <p>Public: Method is used to verify the atleast one element in list is present</p>
	 *   @param listElements, elementName
	 *   @author protta
	 */
	public void verifyElementIsPresent(List<WebElement> listElements, String elementName) throws Exception {
		this.waitforElements(listElements, elementName);
		Assert.assertTrue(listElements.size()!=0, elementName+" is not present.");
		this.captureLogInReport(LogStatus.PASS, '\u0022' + elementName + '\u0022' + " is present.");
	}

	/**
	 *  <p>Public: Method is used to verify the atleast one element in list is present</p>
	 *   @param listElements, elementName
	 *   @author protta
	 * @throws Exception 
	 */
	public void verifyElementIsPresentWithoutException(List<WebElement> listElements, String elementName) throws Exception {
		this.waitforElements(listElements, elementName);
		if(listElements.size()!=0) {
			this.captureLogInReport(LogStatus.PASS, '\u0022' + elementName + '\u0022' + " is present.");
		}
		else {
			this.captureLogInReport(LogStatus.FAIL, elementName+" is not present.");
		}
	}

	/**
	 *  <p>Public: Method is used to verify the atleast one element in list is present</p>
	 *   @param listElements, elementName
	 *   @author protta
	 */
	public void verifyElementIsNotPresent(List<WebElement> listElements, String elementName) throws Exception {
		Assert.assertTrue(listElements.size() == 0, elementName+" is present.");
		this.captureLogInReport(LogStatus.PASS, '\u0022' + elementName + '\u0022' + " is not present.");
	}

	/**
	 *  <p>Public: Method is used to verify the atleast one element in list is present</p>
	 *   @param listElements, elementName
	 *   @author protta
	 */
	public void verifyElementIsNotPresentWithoutException(List<WebElement> listElements, String elementName) {
		if(listElements.size() == 0) {
			this.captureLogInReport(LogStatus.PASS, '\u0022' + elementName + '\u0022' + " is not present.");
		}
		else {
			this.captureLogInReport(LogStatus.FAIL, elementName+" is present.");
		}
	}
	
	/**
	 *  <p>Public: Method is used to verify the text</p>
	 *   @param actualText, expectedText
	 *   @author protta
	 */
	public void getAttributeAndVerifyText(WebElement element, String elementName, String expectedText) {
		String actualText = "";
		try {
			actualText = element.getAttribute("value").toString();
			if(actualText.contains(expectedText)) {
				this.captureLogInReport(LogStatus.PASS, '\u0022' + actualText + '\u0022'+ " text is displayed on the field : "+elementName);
			}else {
				this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
			}
		}
		catch(Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Expected Result : "+expectedText+" not displayed on the field : "+elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to verify the text</p>
	 *   @param actualText, expectedText
	 *   @author protta
	 */
	public void verifyText(WebElement element, String elementName, String expectedText) {
		String actualText = "";
		try {
			actualText = element.getText();
			if(actualText.contains(expectedText)) {
				this.captureLogInReport(LogStatus.PASS, '\u0022' + actualText + '\u0022'+ " text is displayed on the field : "+elementName);
			}else {
				this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
			}
		}
		catch(Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Expected Result : "+expectedText+" not displayed on the field : "+elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to verify the text</p>
	 *   @param actualText, expectedText
	 *   @author protta
	 */
	public void verifyText(List<WebElement> elements, String elementName, String expectedText, int index) {
		String actualText = "";
		try {
			actualText = elements.get(index).getText();
			if(actualText.contains(expectedText)) {
				this.captureLogInReport(LogStatus.PASS, '\u0022' + actualText + '\u0022'+ " text is displayed on the field : "+elementName);
			}else {
				this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
			}
		}
		catch(Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Expected Result : "+expectedText+" not displayed on the field : "+elementName);
		}
	}
	
	/**
	 *  <p>Public: Method is used to verify the text</p>
	 *   @param actualText, expectedText
	 *   @author protta
	 */
	public void verifyEqualText(WebElement element, String elementName, String expectedText) {
		String actualText = "";
		try {
			actualText = element.getText();
			if(actualText.equalsIgnoreCase(expectedText)) {
				this.captureLogInReport(LogStatus.PASS, '\u0022' + expectedText + '\u0022' + " is displayed on the field : "+elementName);
			}
			else {
				this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
			}
		}catch(Exception e) {
			this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
		}		
	}
	
	/**
	 *  <p>Public: Method is used to verify the text</p>
	 *   @param actualText, expectedText
	 *   @author protta
	 */
	public void verifyEqualText(List<WebElement> elements, String elementName, String expectedText, int index) {
		String actualText = "";
		try {
			actualText = elements.get(index).getText();
			if(actualText.equalsIgnoreCase(expectedText)) {
				this.captureLogInReport(LogStatus.PASS, '\u0022' + expectedText + '\u0022' + " is displayed on the field : "+elementName);
			}
			else {
				this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
			}
		}catch(Exception e) {
			this.captureLogInReport(LogStatus.FAIL, actualText+" is diplayed instaed of "+expectedText+" on the field : "+elementName);
		}		
	}

	/**
	 *  <p>Public: Method is used to perform type action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void type(WebElement element, String elementName, String testData) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jse.executeScript("arguments[0].value='"+testData+"';", element);
			this.captureLogInReport(LogStatus.PASS, "Performed type in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to type in : " + elementName + " field with data : " + testData);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to perform type action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void typeWithoutException(WebElement element, String elementName, String testData) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jse.executeScript("arguments[0].value='"+testData+"';", element);
			/*
			 * String tabout = Keys.chord(Keys.CONTROL, "a"); element.sendKeys(tabout);
			 */
			element.sendKeys(Keys.TAB);
			this.captureLogInReport(LogStatus.PASS, "Performed type in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to type in : " + elementName + " field with data : " + testData);
		}
	}
	
	/**
	 *  <p>Public: Method is used to perform type action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void typeWithoutException(List<WebElement> elements, String elementName, String testData, int index) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			jse.executeScript("arguments[0].value='"+testData+"';", elements.get(index));
			this.captureLogInReport(LogStatus.PASS, "Performed type in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to type in : " + elementName + " field with data : " + testData);
		}
	}

	/**
	 *  <p>Public: Method is used to perform sendKeys action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void sendKeys(WebElement element, String elementName, String testData) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(testData);
			this.captureLogInReport(LogStatus.PASS, "Entered value in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to enter value in : " + elementName + " field with data : " + testData);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to perform sendKeys action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void sendKeysWithoutException(WebElement element, String elementName, String testData) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(testData);
			this.captureLogInReport(LogStatus.PASS, "Entered value in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to enter value in : " + elementName + " field with data : " + testData);
		}
	}
	
	/**
	 *  <p>Public: Method is used to perform sendKeys action in textbox and text area</p>
	 *   @param element, elementName
	 *   @param testData
	 *   @author protta
	 */ 
	public void sendKeysWithoutException(List<WebElement> elements, String elementName, String testData, int index) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elements.get(index)));
			elements.get(index).sendKeys(testData);
			this.captureLogInReport(LogStatus.PASS, "Entered value in : " + elementName + " field with data : " + testData);
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to enter value in : " + elementName + " field with data : " + testData);
		}
	}

	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValue(WebElement element, String elementName, String testData) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select fieldLable = new Select(element);
			fieldLable.selectByVisibleText(testData);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " as : " + testData);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " as : " + testData);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValueWithoutException(WebElement element, String elementName, String testData) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select fieldLable = new Select(element);
			fieldLable.selectByVisibleText(testData);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " as : " + testData);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " as : " + testData);
		}
	}
	
	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValueWithoutException(List<WebElement> elements, String elementName, String testData, int index) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elements.get(index)));
			Select fieldLable = new Select(elements.get(index));
			fieldLable.selectByVisibleText(testData);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " as : " + testData);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " as : " + testData);
		}
	}

	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValueByIndex(WebElement element, String elementName, int index) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select fieldLable = new Select(element);
			fieldLable.selectByIndex(index);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " field Index : " + index);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " field Index : " + index);
			throw e;
		}
	}

	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValueByIndexWithoutException(WebElement element, String elementName, int index) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select fieldLable = new Select(element);
			fieldLable.selectByIndex(index);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " field Index : " + index);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " field Index : " + index);
		}
	}
	
	/**
	 *  <p>Public: Method is used to select the dropdown value</p>
	 *   @param element
	 *   @param testData
	 *   @author protta
	 */ 
	public void selectDropDownValueByIndexWithoutException(List<WebElement> elements, String elementName, int index, int indexNo) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elements.get(indexNo)));
			Select fieldLable = new Select(elements.get(indexNo));
			fieldLable.selectByIndex(index);
			this.captureLogInReport(LogStatus.PASS, "Selected : " + elementName + " field Index : " + index);
		}
		catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to select : " + elementName + " field Index : " + index);
		}
	}

	/**
	 * <p>Public: Method is used to ScrollDown</p>
	 * @author protta
	 */ 
	public void ScrollDown() {
		try {
			jse.executeScript("window.scrollBy(0,500)", "");
			this.captureLogInReport(LogStatus.PASS, "Scrolled Down successfully");
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Scroll Down");
		}
	}

	/**
	 * <p>Public: Method is used to ScrollIntoElementView</p>
	 * @param element, elementName
	 * @author protta
	 */ 
	public void ScrollIntoView(WebElement element, String elementName) {
		try{
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e){
			this.captureLogInReport(LogStatus.FAIL, "Unable to Scroll Into the element : "+elementName);
		}
	}
	
	/**
	 * <p>Public: Method is used to ScrollIntoElementView</p>
	 * @param element, elementName
	 * @author protta
	 */ 
	public void ScrollIntoView(List<WebElement> elements, String elementName, int index) {
		try{
			jse.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
		}catch(Exception e){
			this.captureLogInReport(LogStatus.FAIL, "Unable to Scroll Into the element : "+elementName);
		}
	}

	/**
	 * <p>Public: Method is used to ScrollDown to Bottom</p>
	 * @author protta
	 */ 
	public void ScrollDownToBottom() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "Scrolling to Bottom of the page");
			this.captureLogInReport(LogStatus.PASS, "Scrolled Bottom of the Page successfully.");
		} catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Scroll to Bottom");
		}
	}

	/**
	 * <p>Public: Method is to capture the Screenshot</p>
	 * @param driver
	 * @author protta
	 */ 
	public String screenShotCapture(WebDriver driver) throws IOException {
		Date date = new Date();
		String screenShotFileName = date.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + screenShotFileName);
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	/**
	 * <p>Public: Method is to wait - Thread Sleep</p>
	 * @author protta
	 * @throws Exception
	 */
	public void sleepWait(int sleepTime) throws Exception{
		Thread.sleep(sleepTime);
	}

	/**
	 * <p>Public: Swith To Frame</p>
	 * @author protta
	 * @throws IOException 
	 */
	public void switchToFrame(int frameindex) throws Exception {
		try{
			driver.switchTo().frame(frameindex);
			this.captureLogInReport(LogStatus.PASS, "Switched to Frame Index : " + frameindex);
			this.sleepWait(3000);
		}catch(Exception e){
			this.captureLogInReport(LogStatus.FAIL, "Unable to Switch to Frame Index : " + frameindex);
			throw e;
		}
	}

	/**
	 * <p>Public: Swith To Frame</p>
	 * @author protta
	 */
	public void switchToFrameWithoutException(int frameindex) {
		try{
			driver.switchTo().frame(frameindex);
			this.captureLogInReport(LogStatus.PASS, "Switched to Frame Index : " + frameindex);
			this.sleepWait(3000);
		}catch(Exception e){
			this.captureLogInReport(LogStatus.FAIL, "Unable to Switch to Frame Index : " + frameindex);
		}
	}

	/**
	 * <p>Public: Switch To Default Frame</p>
	 * @author protta
	 * @throws Exception
	 */
	public void switchToDefaultFrame() throws Exception {
		this.sleepWait(3000);
		driver.switchTo().defaultContent();
		this.captureLogInReport(LogStatus.PASS, "Switched to Default Content");
	}

	/**
	 * <p>Public: Method is used to Send Key</p>
	 * @author protta
	 * @throws IOException 
	 */
	public void sendKey(String key) throws Exception {
		Actions actions = new Actions(driver);
		if(key.equalsIgnoreCase("Tab"))
			actions.sendKeys(Keys.TAB).perform();
		else if(key.equalsIgnoreCase("Enter"))
			actions.sendKeys(Keys.ENTER).build().perform(); 
		else if(key.equalsIgnoreCase("PageDown"))
			actions.sendKeys(Keys.PAGE_DOWN).build().perform(); 
		else if(key.equalsIgnoreCase("Shift"))
			actions.sendKeys(Keys.SHIFT).build().perform(); 
		else if(key.equalsIgnoreCase("ctrl+shift"))
			actions.keyUp(Keys.CONTROL).sendKeys(Keys.SHIFT).build().perform(); 
		else{
		}
	}

	/**
	 * <p>Public: Method is used to switch Window</p>
	 * @param windowName
	 * @author protta
	 */
	public void switchToWindow(String windowName) throws Exception{
		try{
			driver.switchTo().window(windowName);
		}catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Switch to Window " + windowName);
			throw e;
		}
	}

	/**
	 * <p>Public: Method is used to switch Child Window</p>
	 * @param windowName
	 * @author protta
	 */
	public void switchToChildWindow() throws Exception{
		String parentWindowHandle = driver.getWindowHandle(); 
		Set<String> winHandles = driver.getWindowHandles();
		for(String childWindow: winHandles){
			if(!childWindow.equals(parentWindowHandle)){
				this.switchToWindow(childWindow);
			}
		}
		this.captureLogInReport(LogStatus.PASS, "Switched to Child Window");
	}
	public void switchToPaymentWindow() throws Exception{
		String parentWindowHandle = driver.getWindowHandle(); 
		Set<String> winHandles = driver.getWindowHandles();
		for(String paymentWindow: winHandles){
			if(!paymentWindow.equals(parentWindowHandle)){
				this.switchToWindow(paymentWindow);
			}
		}
		this.captureLogInReport(LogStatus.PASS, "Switched to Child Window");
	}


	/**
	 * <p>Public: Method is used to switch Child Window</p>
	 * @author protta
	 */
	public void switchToParentWindow() throws Exception{
		String parentWindowHandle = driver.getWindowHandle(); 
		this.switchToWindow(parentWindowHandle);
		this.captureLogInReport(LogStatus.PASS, "Switched to Parent Window");
	}

	/**
	 * <p>Public: Method is used to Switch Tab</p>
	 * @author protta
	 */
	public void switchToTab(int index) throws Exception{
		try{
			ArrayList<String> Tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(Tabs.get(index));
			this.captureLogInReport(LogStatus.PASS, "Switched to Tab Index : "+index);
		}catch (Exception e) {
			this.captureLogInReport(LogStatus.FAIL, "Unable to Switch to Tab Index : "+index);
			throw e;
		}
	}

	/**
	 * <p>Public: Method is to refresh the Page.</p>
	 * @author protta
	 */
	public void refresh() throws Exception{
		driver.navigate().refresh();
		this.sleepWait(10000);
		this.captureLogInReport(LogStatus.PASS, "Page Refreshed.");
	}

	/**
	 * <p>Public: Method is to refresh the Page.</p>
	 * @author protta
	 */
	public void navigateBack() throws Exception{
		driver.navigate().back();
		this.sleepWait(10000);
		this.captureLogInReport(LogStatus.PASS, "Navigated to Back");
	}

	/**
	 * <p>Public: Swith To Frame</p>
	 * @author protta
	 * @throws IOException 
	 */
	public void switchToFrame() throws Exception {
		try {
			driver.switchTo().frame(0);
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
		}
	}
	
	/**
	 * <p>Public: Capture Log Status in Extent Report</p>
	 * @param testStepStatus, testStepMessage
	 * @author protta
	 */
	public void captureLogInReport(LogStatus testStepStatus, String testStepMessage){
		LogStatus failureStatus = LogStatus.FAIL;
		InitiateApplication.threadLocalExtentTest.get().log(testStepStatus, testStepMessage);
		if(testStepStatus.equals(failureStatus))
			this.captureScreenshot();
		logger.info(testStepMessage);
	}

	/**
	 * <p>Public: Capture Screenshot of the Page and add it in Extent Report</p>
	 * @author protta
	 */
	public void captureScreenshot() {
		InitiateApplication initiateApplication = new InitiateApplication();
		this.driver = initiateApplication.getDriver();
		try {
			InitiateApplication.threadLocalExtentTest.get().log(LogStatus.FAIL,InitiateApplication.threadLocalExtentTest.get().
					addScreenCapture(screenShotCapture(driver))+" Failed Screenshot");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * <p>Public: Method is to get Current URL</p>
	 * @author protta
	 */
	public String getCurrentURL(){
		String currenURLValue = driver.getCurrentUrl();
		return currenURLValue;	
	}

	/**
	 * <p>Public: Method is to close the current browser</p>
	 * @author protta
	 */
	public void closeCurrentBrowserWindow() throws Exception{
		driver.close();
	}

	public WebElement fieldElement(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public Actions dragAndDrop(WebElement canvasElement, int xoffset, int yoffset) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public WebElement findElement(By name) {
		// TODO Auto-generated method stub
		return null;
	}

}