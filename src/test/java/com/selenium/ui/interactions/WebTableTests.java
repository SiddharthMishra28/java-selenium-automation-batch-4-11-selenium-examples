package com.selenium.ui.interactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTests {
	
	@Test
	public void webTableRead() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		int rows = driver.findElements(By.xpath("//table/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				String cellValue = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(cellValue.equals("Luxembourg")) {
					System.out.println("Found Value on Row "+i+" and Column "+j);
				}
			}
		}
		driver.quit();
	}
	
	@Test
	public void discreetSearch() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Arabic']"));
				
	}
}
