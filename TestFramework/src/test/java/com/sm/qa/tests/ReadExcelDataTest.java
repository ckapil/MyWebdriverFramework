package com.sm.qa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.sm.qa.util.TestUtil;

public class ReadExcelDataTest {

	public static String TESTDATA_SHEET_PATH = "D:\\eclipse-workspace\\TestFramework\\src\\main\\java\\com\\sm\\qa\\testdata\\SMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	@Test(enabled = false)
	public void readExcelTest() {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("ListingPage");
		Row headers = sheet.getRow(0);
		System.out.println(headers.toString());
	}

	@Test
	public void readRowTest() {
		Object[][] row = new Object[1][1];
		row = TestUtil.getTestData("ListingPage", 0);
		System.out.println(row.toString());
	}
}
