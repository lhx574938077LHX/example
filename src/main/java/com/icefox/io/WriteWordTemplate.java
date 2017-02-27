package com.icefox.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.impl.execchain.MainClientExec;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.icefox.bean.Student;

public class WriteWordTemplate {
	
	
	public static void main(String[] args) throws Exception {
		WriteWordTemplate writeWordTemplate = new WriteWordTemplate();
		Student student = new Student();
		student.setAge((short) 14);
		student.setSex((short) 1);
		student.setName("James");		
		writeWordTemplate.writeWord3(student);
	}
	
	//word模板插入数据
	public void writeWord3(Student student) throws Exception{
		  Map<String, Object> params = new HashMap<String, Object>();  
		  
	      params.put("ageStr", "30岁");  
	      params.put("sexStr", "男");  
	      params.put("name", student.getName());  
	      params.put("date", "2016-11-1");
	      InputStream is = WriteWordTemplate.class.getResourceAsStream("text.docx");
//	      String filePath = "C:\\Users\\LHX\\Desktop\\war\\text.docx";  
//	      InputStream is = new FileInputStream(filePath);  
	      XWPFDocument doc = new XWPFDocument(is);  
	      //替换表格里面的变量  
	      this.replaceInTable(doc, params); 
	      //替换段落里面的变量  
	      this.replaceInPara(doc, params);   
	      OutputStream os = new FileOutputStream("C:\\Users\\LHX\\Desktop\\war\\text8.docx");  
	      doc.write(os);
	      is.close();
	      os.close();
		
	}
	
   /** 
    * 替换段落里面的变量 
    * @param doc 要替换的文档 
    * @param params 参数 
    */  
   private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {  
      Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();  
      XWPFParagraph para;  
      while (iterator.hasNext()) {  
         para = iterator.next();  
         this.replaceInPara(para, params);  
      }  
   }  
	
   
   /** 
    * 替换段落里面的变量 
    * @param para 要替换的段落 
    * @param params 参数 
    */  
   private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {  
      List<XWPFRun> runs;  
      Matcher matcher;  
      if (this.matcher(para.getParagraphText()).find()) {  
         runs = para.getRuns();  
         for (int i=0; i<runs.size(); i++) {  
            XWPFRun run = runs.get(i);  
            String runText = run.toString();  
            matcher = this.matcher(runText);  
            if (matcher.find()) {  
                while ((matcher = this.matcher(runText)).find()) {  
                   runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));  
                }  
                //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，  
                //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。  
                para.removeRun(i);  
                para.insertNewRun(i).setText(runText);  
            }  
         }  
      }  
   } 
   
   
   /** 
    * 替换表格里面的变量 
    * @param doc 要替换的文档 
    * @param params 参数 
    */  
   private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {  
      Iterator<XWPFTable> iterator = doc.getTablesIterator();  
      XWPFTable table;  
      List<XWPFTableRow> rows;  
      List<XWPFTableCell> cells;  
      List<XWPFParagraph> paras;  
      while (iterator.hasNext()) {  
         table = iterator.next();  
         rows = table.getRows();  
         for (XWPFTableRow row : rows) {  
            cells = row.getTableCells();  
            for (XWPFTableCell cell : cells) {  
                paras = cell.getParagraphs();  
                for (XWPFParagraph para : paras) {  
                   this.replaceInPara(para, params);  
                }  
            }  
         }  
      }  
   } 
   
   /** 
    * 正则匹配字符串 
    * @param str 
    * @return 
    */  
   private Matcher matcher(String str) {  
      Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);  
      Matcher matcher = pattern.matcher(str);  
      return matcher;  
   }
}
