package com.icefox.io;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFile3 {
	
	public static void main(String[] args) throws Exception {
		//XSSF xlsx HSSF xls
		String path = "C:\\Users\\LHX\\Desktop\\war\\test.xlsx";
		InputStream is = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(is);
        //获得sheet工作簿 
        XSSFSheet sheet = wb.getSheetAt(0);
        //获得行
        //获得行中的列，即单元格
        //获取值
        for(int i=0;i<30;i++){
        	XSSFRow row = sheet.getRow(i);
        	if(row!=null){
        		XSSFCell str = row.getCell(0);
        		System.out.println(str.getStringCellValue());
        	}
        }
	}
	
}
