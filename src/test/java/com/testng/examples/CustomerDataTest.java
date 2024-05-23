package com.testng.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CustomerDataTest {

		@Test
		public void customerDataReadTest(Customer c) {
			System.out.println(c);
		}
		
		public Object[][] getCustomerData() throws IOException {
			FileInputStream fis = new FileInputStream(new File("./src/test/resources/test-data.xlsx"));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("customer");
			int numRows = sheet.getLastRowNum();
			int numcols = sheet.getRow(0).getLastCellNum();
			Object[][] myData = new Object[4][12];
			List<Customer> customers = new ArrayList<>();
			for(int i=1; i<=numRows; i++) {
				for(int j=0; j<numcols; j++) {
					Customer c = new Customer();
					c.setFirstName(sheet.getRow(i).getCell(0).getStringCellValue());
					// SETTERS
					customers.add(c);
					myData[i][j] = c;
				}
			}
			// FOR LOOP
			return myData;
		}
}
