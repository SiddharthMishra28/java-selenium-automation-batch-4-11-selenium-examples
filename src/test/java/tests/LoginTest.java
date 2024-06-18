package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import config.Hooks;
import pages.LoginPage;

public class LoginTest extends Hooks{

	@Test(dataProvider = "login_provider", testName = "Login Test With Different Data")
	public void loginIntoPortal_test(String userId, String password) {
		LoginPage page = new LoginPage(driver);
		page.login("https://demo.guru99.com/V1/index.php", userId, password);
	}
	
	@Test(testName = "Form Reset Test")
	public void loginPortal_reset_input_test() {
		LoginPage page = new LoginPage(driver);
		page.reset("https://demo.guru99.com/V1/index.php", "mngr542003", "nyseqAn");
	}
	
	@Test(testName = "Dummy Failure Scenario")
	public void dummy_failure_scenario() throws InterruptedException {
		softAssert = new SoftAssert();
		softAssert.assertTrue(false);
		Thread.sleep(2000);
		softAssert.assertAll();
	}
	
	@Test
	public void assert_example() {
		LoginPage page = new LoginPage(driver);
		page.navigateToUrl("https://demo.guru99.com/V1/index.php");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Home Page ";
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
	
	@DataProvider(name = "login_provider")
	public Object[][] loginDataProvider() {
		return this.readExcel(configProps.get("test_data_path"), "loginData");
	}
	
	public Object[][] readExcel(String filePath, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			Object[][] data = new Object[rowCount][colCount];
			System.out.println(rowCount+" | "+colCount);
			for(int i=1; i<=rowCount; i++) {
				for(int j=0; j<colCount; j++) {
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		} catch (IOException e) {
			System.out.println("Error while Reading Test Data");
		}
		return null;
	}
}
