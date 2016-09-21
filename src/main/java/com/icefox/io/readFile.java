package com.icefox.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class readFile {
	
	public void readFile1() throws Exception{
		FileInputStream in = new FileInputStream(new File("D:\\workspace\\workspace2\\example\\src\\test\\java\\com\\icefox\\example\\notepad.txt"));
		 // 一次读一个字节
		System.out.println("一次读一个字节");
		int  tempbyte = 0 ;
		while ((tempbyte = in.read()) != -1) {
           System.out.write(tempbyte);
       }
		in.close();
	}
	
	public void readFile2() throws Exception{
		FileInputStream in = new FileInputStream(new File("D:\\workspace\\workspace2\\example\\src\\test\\java\\com\\icefox\\example\\notepad.txt"));
		// 一次读多个字节
		System.out.println("一次读多个字节");
        byte[] tempbytes = new byte[100];
        int byteread = 0;
        while ((byteread = in.read(tempbytes)) != -1) {
            System.out.write(tempbytes, 0, byteread);
        }
		in.close();
	}
	public void readFile3() throws Exception{
		File file = new File("D:\\workspace\\workspace2\\example\\src\\test\\java\\com\\icefox\\example\\notepad.txt");
		BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	public void readFile4() throws Exception{
		//设置文件编码
	    FileInputStream fr = new FileInputStream("D:\\workspace\\workspace2\\example\\src\\test\\java\\com\\icefox\\example\\notepad.txt");
	    InputStreamReader is = new InputStreamReader(fr,"GBK");
	    BufferedReader reader=new BufferedReader(is);
        String tempString = null;
	    int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            line++;
        }
        reader.close();
	}
	
}
