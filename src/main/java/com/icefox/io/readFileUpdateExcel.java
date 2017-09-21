package com.icefox.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFileUpdateExcel {
	
	public static void main(String[] args) throws Exception {
		String filePath = "D:\\bill\\2016\\";
		File file = new File(filePath); 
		String[] list = file.list();
		for(String str:list){
			InputStream is = null;
	        OutputStream os=null;
			try {
				String path = "D:\\bill\\2016\\"+str;
				is = new FileInputStream(path);
				XSSFWorkbook wb = new XSSFWorkbook(is);
		        XSSFSheet sheet = wb.getSheetAt(0);
		        XSSFCell cell = sheet.getRow(2).getCell(1);
		        cell.setCellValue("2016-11-1");
				os=new FileOutputStream(path);
				wb.write(os);
				System.out.println(str+"   ---成功");
			}catch (Exception e) {
				e.printStackTrace();
			} 
			finally {
				is.close();
			}
		}
		
	}
	
}
