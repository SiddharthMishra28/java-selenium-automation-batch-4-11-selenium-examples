package com.selenium.ui.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFromUITest {
	
	//XPATH - / - absolute path
	//        // - relative
	//        //tagname[@attribute=value]
	
	@Test
	public void fetchTextFromUI() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		String headerText = driver.findElement(By.xpath("//h2[@class='barone']")).getText();
		System.out.println(headerText);
		driver.quit();
	}
}
