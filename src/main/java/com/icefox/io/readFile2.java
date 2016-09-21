package com.icefox.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class readFile2 {
	
	 // 源文件夹   
    static String url1 = "C:/Users/LHX/Desktop/userfile";  
    // 目标文件夹   
    static String url2 = "C:/Users/LHX/Desktop/newUserFile"; 
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\LHX\\Desktop\\data.txt");
		BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

                File file1 = new File("C:\\Users\\LHX\\Desktop\\userfile\\"+tempString);
                if (file1.isFile()) {  
                    // 复制文件   
                    copyFile(file1,new File(url2+file1.getName()));  
                }  
                if (file1.isDirectory()) {  
                    // 复制目录   
                    String sourceDir=url1+File.separator+file1.getName();  
                    String targetDir=url2+File.separator+file1.getName();  
                    copyDirectiory(sourceDir, targetDir);  
                } 
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
	
	public static void copyFile(File sourceFile,File targetFile)   
			throws IOException{  
        // 新建文件输入流并对它进行缓冲   
        FileInputStream input = new FileInputStream(sourceFile);  
        BufferedInputStream inBuff=new BufferedInputStream(input);  
  
        // 新建文件输出流并对它进行缓冲   
        FileOutputStream output = new FileOutputStream(targetFile);  
        BufferedOutputStream outBuff=new BufferedOutputStream(output);  
          
        // 缓冲数组   
        byte[] b = new byte[1024 * 5];  
        int len;  
        while ((len =inBuff.read(b)) != -1) {  
            outBuff.write(b, 0, len);  
        }  
        // 刷新此缓冲的输出流   
        outBuff.flush();  
          
        //关闭流   
        inBuff.close();  
        outBuff.close();  
        output.close();  
        input.close();  
    }  
    // 复制文件夹   
    public static void copyDirectiory(String sourceDir, String targetDir)  
            throws IOException {  
        // 新建目标目录   
        (new File(targetDir)).mkdirs();  
        // 获取源文件夹当前下的文件或目录   
        File[] file = (new File(sourceDir)).listFiles();  
        for (int i = 0; i < file.length; i++) {  
            if (file[i].isFile()) {  
                // 源文件   
                File sourceFile=file[i];  
                // 目标文件   
               File targetFile=new   
		File(new File(targetDir).getAbsolutePath()  
		+File.separator+file[i].getName());  
                copyFile(sourceFile,targetFile);  
            }  
            if (file[i].isDirectory()) {  
                // 准备复制的源文件夹   
                String dir1=sourceDir + "/" + file[i].getName();  
                // 准备复制的目标文件夹   
                String dir2=targetDir + "/"+ file[i].getName();  
                copyDirectiory(dir1, dir2);  
            }  
        }  
    }  
	
}
