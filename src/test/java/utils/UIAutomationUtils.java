package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Hooks;

public class UIAutomationUtils extends Hooks {
	
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
