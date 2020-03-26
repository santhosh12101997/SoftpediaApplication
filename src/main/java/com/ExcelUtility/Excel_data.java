package com.ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel_data 
{
	// To Read username from excel sheet
	public  String excel_username(int i) throws IOException 
	{	
		//Create an object of File class to open xlsx file and an object of FileInputStream class to read excel file
		FileInputStream file = new FileInputStream(new File("src\\test\\resources\\TestData\\exceldata.xlsx"));
		//create object of XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row =sheet.getRow(i);
		XSSFCell cell =row.getCell(0);
		cell.setCellType(CellType.STRING);
		String uname =cell.getStringCellValue();
		return uname;
	}
	
	// To Read Email from excel sheet
	public  String Email(int i) throws IOException
	{	
		//Create an object of File class to open xlsx file and an object of FileInputStream class to read excel file
		FileInputStream file = new FileInputStream(new File("src\\test\\resources\\TestData\\exceldata.xlsx"));
		//create object of XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row =sheet.getRow(i);
		XSSFCell cell1 =row.getCell(1);
		cell1.setCellType(CellType.STRING);
		String Email =cell1.getStringCellValue();
		return Email;
	}
	
	// To Read Password from excel sheet
	public  String excel_password(int i) throws IOException 
	{ 	
		//Create an object of File class to open xlsx file and an object of FileInputStream class to read excel file
		FileInputStream file = new FileInputStream(new File("src\\test\\resources\\TestData\\exceldata.xlsx"));
		//create object of XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row =sheet.getRow(i);
		XSSFCell cell2 =row.getCell(2);
		cell2.setCellType(CellType.STRING);
		String pwd =cell2.getStringCellValue();
		return pwd;
		
	}
	
	// To Read Re-password from excel sheet
	public  String excel_repassword(int i) throws IOException 
	{ 
		//Create an object of File class to open xlsx file and an object of FileInputStream class to read excel file
		FileInputStream file = new FileInputStream(new File("src\\test\\resources\\TestData\\exceldata.xlsx"));
		//create object of XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row =sheet.getRow(i);
		XSSFCell cell3 =row.getCell(3);
		cell3.setCellType(CellType.STRING);
		String re_pwd =cell3.getStringCellValue();
		return re_pwd;
		
	}
}