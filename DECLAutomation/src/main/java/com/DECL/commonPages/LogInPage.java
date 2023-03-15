package com.DECL.commonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DECL.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class LogInPage extends BasePage{

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	ActionDriver actionDriver = new ActionDriver(driver);

	@FindBy(xpath = "//input[@name='userName']")
	WebElement userNameField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@title='Register']")
	WebElement logInButton;
	
	@FindBy(xpath = "//a[contains(@href,'licensinghome')]//div[contains(@class,'text-body') and text()='Licensing']")
	WebElement licensingTile;
	
	String userColumnName = Constants.USER_COLUMN_NAME.toString();
	String userNameColumnName = Constants.USERNAME_COLUMN_NAME.toString();
	String passwordColumnName = Constants.PASSWORD_COLUMN_NAME.toString();
	String filePath = Constants.USERCREDENTIALS_PATH.toString();
	
    /**
     * <p>Public : This method will be used to login into the application</p>
     * @param strUserName
     * @param strPasword
     * @author protta
     * @throws Exception 
     */
    public void logIn(String userName, String strUserName, String strPasword) throws Exception{
    	actionDriver.sendKeys(userNameField, "Username", strUserName);
    	actionDriver.sendKeys(passwordField, "Password", strPasword);
    	actionDriver.sendKey("Tab");
    	actionDriver.sendKey("Tab");
    	actionDriver.jsClick(logInButton,"Log In Button");
    	actionDriver.waitforElement(licensingTile, "CDEC Provider Hub Licensing Tile");
    	actionDriver.captureLogInReport(LogStatus.PASS, userName+" User Logged In Successfully.");
    }
    
    /**
     * <p>Public : This method will be used to LogIn as specific User in the application org</p>
     * @param userName
     * @param applicationOrg
     * @author protta
     * @throws Exception 
     */
    public void logInAsUser(String userName, String applicationOrg) throws Exception{
    	int userRowNumber = -1;
    	String sheetName = applicationOrg;   	
    	ExcelReader excelReader = new ExcelReader();
    	try {
			excelReader.setExcelFile(filePath, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	userRowNumber =  excelReader.getCellRowNum(sheetName, userColumnName, userName);
    	String userNameValue = excelReader.getCellData(sheetName, userNameColumnName, userRowNumber);
    	String passwordValue = excelReader.getCellData(sheetName, passwordColumnName, userRowNumber);
    	this.logIn(userName, userNameValue, passwordValue);
    }
}