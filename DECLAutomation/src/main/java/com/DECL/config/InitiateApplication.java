package com.DECL.config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.DECL.commonPages.BasePage;
import com.DECL.utils.ConfigurationFileReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateApplication {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>(); 
	public static ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<ExtentTest>();

	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	BasePage basePage;
	ConfigurationFileReader configurationFileReader  = new ConfigurationFileReader();

	@BeforeSuite
	public void generateExtentReport() {
		extentReports = new ExtentReports(System.getProperty("user.dir") + "\\Report\\ExtentReport.html");
	}
	
	@BeforeMethod
	public void setup(Method method) {		
		if(configurationFileReader.getBrowserName().equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			threadLocal.set(driver);
			basePage = new BasePage(threadLocal.get());
			BasePage.logger.info("Chrome Browser Initiated Successfully.");
		}
		else if(configurationFileReader.getBrowserName().equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			threadLocal.set(driver);
			basePage = new BasePage(threadLocal.get());
			BasePage.logger.info("Firefox Browser Initiated Successfully.");
		}
		else{
			BasePage.logger.info("Inavlid browser name provided.");
		}
		
		extentTest = extentReports.startTest(method.getName());
		threadLocalExtentTest.set(extentTest);
	}

	@AfterMethod
	public void tearDown() {
		extentReports.endTest(threadLocalExtentTest.get());
		extentReports.flush();
		threadLocal.get().quit();
	}

	/**
	 * <p> Public: Method is to get the driver instance</p>
	 * @author protta
	 */
	public WebDriver getDriver(){
		return threadLocal.get();
	}

	/**
	 * <p>
	 * Public: Method is to open the Application URL
	 * </p>
	 * 
	 * @param applicationURL
	 * @author protta
	 */
	public void gotoApplication(String applicationURL) {
		threadLocal.get().get(applicationURL);
		threadLocalExtentTest.get().log(LogStatus.PASS, "Application URL " + applicationURL + " launched successfully.");
		BasePage.logger.info("Application URL " + applicationURL + " launched successfully.");
	}
}