package com.icefox.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import demo.Field;

public class writeFile {
	
	public static void main(String[] args) throws Exception {
		writeFile writeFile = new writeFile();
		writeFile.write();
	}
	
	public void write() throws Exception{
		Field field = new Field();
		field.setCode("111");
		field.setDataType("222");
		field.setName("333");
		
		String path="D:\\notepad.txt";
		File f = new File(path) ;
//		FileOutputStream out = new FileOutputStream(new File(path));		
		OutputStream out = new FileOutputStream(f,true) ;
		ObjectOutputStream oos = new ObjectOutputStream(out);
		
		oos.writeObject(field);
		
		oos.close();
		out.close();
		
	}
	
}
