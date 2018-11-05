package com.computerDB.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsx {

	public static InputStream XlsxFileToRead = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	ReadXlsx() {

	}

	public static Row rowNumberForTest(String testCaseID, String excelPath, String sheetName) throws FileNotFoundException {
		int rowNum = 0;
		Row r = null;
		boolean flag = false;
		try {
			XlsxFileToRead = new FileInputStream(
					"C:\\Users\\KOMALROHIT\\workspace\\ComputerDBAutoFramework\\src\\test\\java\\Resources\\DataSet.xlsx");

			workbook = new XSSFWorkbook(XlsxFileToRead);
			sheet = workbook.getSheet("Create");
			
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				r = sheet.getRow(i);
				if (testCaseID.equalsIgnoreCase(r.getCell(0).getStringCellValue())) {
					rowNum = i;
					flag = true;
					r.setRowNum(i);
					break;

				}
			}

		

		} catch (IOException e) {

			e.printStackTrace();
		}
		return r;
		
	}
	public static HashMap<String, String> GetCellData(Row r){
		Row heading = null;
		heading = sheet.getRow(0);
		heading.setRowNum(0);
		Iterator<Cell> headIterator = heading.iterator();
		Iterator<Cell> cellIterator = r.iterator();
		HashMap<ArrayList<String>, ArrayList<String>> yt = new HashMap<ArrayList<String>, ArrayList<String>>();
		HashMap<String, String> testData = new HashMap<String, String>();
		ArrayList<String> header = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            Cell headingCell = headIterator.next();
            //getCellTypeEnum shown as deprecated for version 3.15
            //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
            if (currentCell.getCellTypeEnum() == CellType.STRING) {
                System.out.print(currentCell.getStringCellValue() + "--");
                System.out.print(headingCell.getStringCellValue() + "--");
                testData.put(headingCell.getStringCellValue(), currentCell.getStringCellValue());
                
            } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                System.out.print(currentCell.getNumericCellValue() + "--");
                System.out.print(headingCell.getNumericCellValue() + "--");
                testData.put(headingCell.getStringCellValue(), currentCell.getStringCellValue());
            }
            System.out.println();

        }
		return testData;
		
	}

	
		
	}

