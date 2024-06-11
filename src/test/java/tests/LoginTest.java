package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Hooks;
import pages.LoginPage;

public class LoginTest extends Hooks{

	
	@Test(dataProvider = "login_provider")
	public void LoginIntoPortal_test(String userId, String password) {
		LoginPage page = new LoginPage(driver);
		page.login("https://demo.guru99.com/V1/index.php", userId, password);
	}
	
	@Test
	public void loginPortal_reset_input_test() {
		LoginPage page = new LoginPage(driver);
		page.reset("https://demo.guru99.com/V1/index.php", "mngr542003", "nyseqAn");
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
			Object[][] data = new Object[rowCount+1][colCount];
			System.out.println(rowCount+" | "+colCount);
			for(int i=0; i<rowCount; i++) {
				for(int j=0; j<colCount; j++) {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		} catch (IOException e) {
			System.out.println("Error while Reading Test Data");
		}
		return null;
	}
}
