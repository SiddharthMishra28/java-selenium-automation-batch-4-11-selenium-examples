package com.selenium.ui.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchTest {
	
	@Test
	public void launchBrowserTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}
}
