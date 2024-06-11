package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIAutomationUtils {
	
	WebDriver driver;
	
	public UIAutomationUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	
	public void clickElement(By locatorType) {
		driver.findElement(locatorType).click();
	}
	
	public void typeIntoInput(By locatorType, String input) {
		driver.findElement(locatorType).sendKeys(input);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
