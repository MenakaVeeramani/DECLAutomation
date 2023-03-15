package com.DECL.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public void setExcelFile(String excelPath, String sheetName) throws Exception {
		try{
			File file = new File(excelPath);
			FileInputStream excelFile = new FileInputStream(file);
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			excelFile.close();
		}catch (Exception e) {
			throw (e);
		}
	}

	public void setCellData(String excelPath, String Result, String sheetName, String colName, int rowNumber) throws Exception {
		try{
			File file = new File(excelPath);
			FileInputStream excelFile = new FileInputStream(file);
			ExcelWBook = new XSSFWorkbook(excelFile);
			
			int index = ExcelWBook.getSheetIndex(sheetName);
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(0);
			int colNum = -1;
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					colNum = i;
			}
			
			ExcelWSheet.autoSizeColumn(colNum);
			Row = ExcelWSheet.getRow(rowNumber - 1);
			Cell = Row.getCell(colNum);
			if (Cell == null) {
				Cell = Row.createCell(colNum);
				Cell.setCellValue(Result);
			}else{
				Cell.setCellValue(Result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(excelPath);
			ExcelWBook.write(fileOut);
		    fileOut.close();
		} catch (Exception e){
			throw (e);
		}
	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = ExcelWBook.getSheetIndex(sheetName);
			int col_Num = -1;

			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(0);
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(rowNum - 1);
			Cell = Row.getCell(col_Num);

			return Cell.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}
	
	
	public String getCellDataAndVerify(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = ExcelWBook.getSheetIndex(sheetName);
			int col_Num = -1;

			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(0);
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(rowNum - 1);
			Cell = Row.getCell(col_Num);

			return Cell.getStringCellValue();

		} catch (Exception e) {
			return "";
		}
	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}

	public int getRowCount(String sheetName) {
		int indexNum = ExcelWBook.getSheetIndex(sheetName);
		if (indexNum == -1)
			return 0;
		else {
			ExcelWSheet = ExcelWBook.getSheetAt(indexNum);
			int rowCount = ExcelWSheet.getLastRowNum() + 1;
			return rowCount;
		}
	}
}