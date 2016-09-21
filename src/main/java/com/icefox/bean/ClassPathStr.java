package com.icefox.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClassPathStr {
	public static void main(String[] args) {
        System.out.println(Student.class.getResource("/cer/yijia.cer"));
        // 有"/"带表项目工程的目录，没有"/"带表当前类目录
        //不以"/" 开头，要加载的文件和.class文件在同一目录下    。 如果在子目录下，path为      子目录/yijia.cer
        System.out.println(ClassPathStr.class.getResourceAsStream("yijia.cer"));
        //读取文件内容
        InputStream path = Student.class.getResourceAsStream("yijia.cer");
        //InputStream path = Student.class.getResourceAsStream("/cer/yijia.cer");
       
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));   
        StringBuilder sb = new StringBuilder();   
        String line = null;   
        try {
			while ((line = reader.readLine()) != null) {   
			    sb.append(line);   
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			 try {path.close();} catch (IOException e) {e.printStackTrace();} 
		}
         
        System.out.println(line);
        //输出文件内容
        System.out.println(sb.toString());
	}
}
