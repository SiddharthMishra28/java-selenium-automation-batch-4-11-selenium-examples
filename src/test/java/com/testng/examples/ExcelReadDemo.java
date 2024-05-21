package com.testng.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadDemo {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/test-data.xlsx"));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("login_credentials");
		int numRows = sheet.getLastRowNum();
		int numcols = sheet.getRow(0).getLastCellNum();
		List<Credential> credentials = new ArrayList<>();
		for(int i=0; i<=numRows; i++) {
			for(int j=0; j<numcols; j++) {
				Credential credential = new Credential();
				credential.setUserName(sheet.getRow(i).getCell(0).getStringCellValue());
				credential.setPassword(sheet.getRow(i).getCell(1).getStringCellValue());
				credentials.add(credential);
			}
		}
		System.out.println(credentials);
	}
}
