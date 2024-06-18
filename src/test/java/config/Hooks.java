package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reporting.ReportingListener;

public class Hooks {

	public static WebDriver driver = null;
	public static Map<String, String> configProps = null;
	public SoftAssert softAssert;
	
	@BeforeSuite
	public void beforeSuite() {
		// READ CONFIG LOGIC
		configProps = readConfig();
	}
	
	@BeforeTest
	public void beforeTest() {
	
	}
	
	@BeforeMethod
	public void beforeMethod() {
		this.launchBrowser();
	}

	
	@AfterMethod
	public void afterMethod() {
		this.closeBrowser();
	}
	
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		// REPORTING
		// TEARDOWN
	}
	
	public void launchBrowser() {
		if(configProps.get("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProps.get("browser_driver_path"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		// OTHER BROWSERS
	}
	
	public static Map<String, String> readConfig() {
		try {
			FileInputStream fis = new FileInputStream(new File("./src/test/resources/config.properties"));
			Properties properties = new Properties();
			properties.load(fis);
			Map<Object, Object> configProps = properties;
			return new HashMap(configProps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeBrowser() {
		if(this.driver != null) {
			this.driver.quit();
		}
	}
}
