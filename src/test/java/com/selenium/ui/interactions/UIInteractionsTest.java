package com.selenium.ui.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UIInteractionsTest {
	
	
	
	@Test
	public void navigateTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.quit();
	}
	
	@Test
	public void typeIntoInputBoxTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.findElement(By.name("uid")).sendKeys("mngr571718");
		driver.findElement(By.name("password")).sendKeys("patygYh");
		driver.quit();
	}
	
	@Test
	public void clickOnLoginButtonTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.findElement(By.name("uid")).sendKeys("mngr571718");
		driver.findElement(By.name("password")).sendKeys("patygYh");
		driver.findElement(By.name("btnLogin")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test
	public void fetchTextFromUITest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.findElement(By.name("uid")).sendKeys("mngr571718");
		driver.findElement(By.name("password")).sendKeys("patygYh");
		driver.findElement(By.name("btnLogin")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DEFAULT LOCATORS
		// ID
		// NAME
		// XPATH
		// CSS
		// LINKTEXT
		// TAGNAME
		// PARTIALLINKTEXT
		
		// XPATH 
		// / - Absolute - /html/body/div[2]/h2
		// // - Relative - //tagname[@attributename='value'] //h2[@class='barone']
		// TEXT MATCH CAN BE USED - //a[text()='Edit Customer']
		// PARTIAL TEXT MATCH - //a[contains(text(), 'Gateway')]
		
		// CSSPATH
		// .barone - . for class # for id
		String welcomeText = driver.findElement(By.xpath("//marquee[contains(text(), 'Welcome To')]")).getText();
		System.out.println(welcomeText);
		driver.quit();
	}
	
	@Test
	public void alertTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.findElement(By.name("uid")).sendKeys("mngr571718");
		driver.findElement(By.name("password")).sendKeys("patygYh");
		driver.findElement(By.name("btnLogin")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		String successfulLogoutText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(successfulLogoutText);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test
	public void dropdownSelectTest() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/");
		driver.findElement(By.name("uid")).sendKeys("mngr571718");
		driver.findElement(By.name("password")).sendKeys("patygYh");
		driver.findElement(By.name("btnLogin")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//li/a[text()='New Customer']")).click();
		WebElement dropdownElement = driver.findElement(By.name("selaccount"));
		Select accountTypeSelect = new Select(dropdownElement);
		accountTypeSelect.selectByVisibleText("current");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
