package com.testng.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGLifecycle {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I'll run first!");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I'll run once before each TestNG class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I'll run before Each Test Method");
	}
	
	@Test(dataProvider = "credentials")
	public void myTest(String userName, String password) {
		System.out.println("This is a dummy Test");
		System.out.println(userName + "|" + password);
	}
	
	@Test
	public void myTest2() {
		System.out.println("This is a dummy Test2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("I'll run once After Each Test class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("I'll run once after each TestNG class");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("i'll run at last!");
	}
	
	@DataProvider(name = "credentials")
	public Object[][] credentialProvider() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/test-data.xlsx"));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("login_credentials");
		int numRows = sheet.getLastRowNum();
		int numcols = sheet.getRow(0).getLastCellNum();
		Object[][] myData = new Object[numRows+1][numcols];
		for(int i=0; i<=numRows; i++) {
			for(int j=0; j<numcols; j++) {
				myData[i][j] = sheet.getRow(i).getCell(0).getStringCellValue();
			}
		}
		return myData;
	}
}
