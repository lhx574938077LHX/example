package com.icefox.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

import com.icefox.bean.Student;

public class wordPoi {

	//读取word
	public static void main(String[] args) throws Exception  {
		writeWord2();
	}
	
	
	//word里创建表格
	public static void writeWord2() throws Exception{
	      XWPFDocument doc = new XWPFDocument();  
       //创建一个5行5列的表格  
       	  XWPFTable table = doc.createTable(5, 5);  
	      //这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。  
//		    table.addNewCol(); //给表格增加一列，变成6列  
	      table.createRow(); //给表格新增一行，变成6行  
	      List<XWPFTableRow> rows = table.getRows();  
	      //表格属性  
	      CTTblPr tablePr = table.getCTTbl().addNewTblPr();  
	      //表格宽度  
	      CTTblWidth width = tablePr.addNewTblW();  
	      width.setW(BigInteger.valueOf(8000));  
	      XWPFTableRow row;  
	      List<XWPFTableCell> cells;  
	      XWPFTableCell cell;  
	      int rowSize = rows.size();  
	      int cellSize;  
	      for (int i=0; i<rowSize; i++) {  
	         row = rows.get(i);  
	         //新增单元格  
	         row.addNewTableCell();  
	         //设置行的高度  
	         row.setHeight(500);  
	         //行属性  
//		       CTTrPr rowPr = row.getCtRow().addNewTrPr();  
	         //这种方式是可以获取到新增的cell的。  
//		       List<CTTc> list = row.getCtRow().getTcList();  
	         cells = row.getTableCells();  
	         cellSize = cells.size();  
	         for (int j=0; j<cellSize; j++) {  
	            cell = cells.get(j);  
	            if ((i+j)%2==0) {  
	                //设置单元格的颜色  
//	                cell.setColor("ff0000"); //红色  
	            } else {  
//	                cell.setColor("0000ff"); //蓝色  
	            }  
	            //单元格属性  
	            CTTcPr cellPr = cell.getCTTc().addNewTcPr();  
	            cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);  
	            if (j == 3) {  
	                //设置宽度  
	                cellPr.addNewTcW().setW(BigInteger.valueOf(3000));  
	            }  
	            cell.setText(i + ", " + j);  
	         }  
	      }  
	      //文件不存在时会自动创建  
	      OutputStream os = new FileOutputStream("C:\\Users\\LHX\\Desktop\\war\\text2.docx");  
	      //写入文件  
	      doc.write(os);  
	      os.close();
	}
	
	//通过XWPFDocument生成
	public static void writeWord1() throws Exception{
		//新建一个文档  
	      XWPFDocument doc = new XWPFDocument();  
	      //创建一个段落  
	      XWPFParagraph para = doc.createParagraph();  	       
	      //一个XWPFRun代表具有相同属性的一个区域。  
	      XWPFRun run = para.createRun();  
	      run.setBold(true); //加粗  
	      run.setText("加粗的内容");  
	      run = para.createRun();  
	      run.setColor("FF0000");  
	      run.setText("红色的字。");  
	      
	      //创建一个段落  
	      XWPFParagraph para1 = doc.createParagraph();  	       
	      //一个XWPFRun代表具有相同属性的一个区域。  
	      XWPFRun run1 = para1.createRun();  
	      run1.setText("红色的字");  
	      run1 = para1.createRun(); 
	      run1.setColor("FF0000");   
	      run1.setText("正常的字。");  
	      
	      OutputStream os = new FileOutputStream("C:\\Users\\LHX\\Desktop\\war\\text1.docx");  
	      //把doc输出到输出流  
	      doc.write(os);  
	      os.close();;  
	}
	
	//通过XWPFWordExtractor读
	public static void readWord(){
		Student student = new Student();
		student.setAge((short) 14);
		student.setName("小王");
		student.setSex((short) 1);
		String path = "C:\\Users\\LHX\\Desktop\\war\\text.docx";
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			XWPFDocument  wb = new XWPFDocument(is);
			XWPFWordExtractor extractor = new XWPFWordExtractor(wb);
	        String text = extractor.getText();  
	        System.out.println(text);  
		}
		catch (Exception e) {
		}
		finally {
			try {is.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	//通过XWPFDocument读
	public static void readWord2(){
		InputStream is = null;
		try {
			  is = new FileInputStream("C:\\Users\\LHX\\Desktop\\war\\text.docx");  
		      XWPFDocument doc = new XWPFDocument(is);  
		      List<XWPFParagraph> paras = doc.getParagraphs();  
		      for (XWPFParagraph para : paras) {  
		         //当前段落的属性  
	//	       CTPPr pr = para.getCTP().getPPr();  
		         System.out.println(para.getText());  
		      }  
		      //获取文档中所有的表格  
		      List<XWPFTable> tables = doc.getTables();  
		      List<XWPFTableRow> rows;  
		      List<XWPFTableCell> cells;  
		      for (XWPFTable table : tables) {  
		         //表格属性  
	//	       CTTblPr pr = table.getCTTbl().getTblPr();  
		         //获取表格对应的行  
		         rows = table.getRows();  
		         for (XWPFTableRow row : rows) {  
		            //获取行对应的单元格  
		            cells = row.getTableCells();  
		            for (XWPFTableCell cell : cells) {  
		                System.out.println(cell.getText());;  
		            }  
		         }  
		      }
		}
		catch (Exception e) {
		}
		finally {
			try {is.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
}
