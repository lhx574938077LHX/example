package com.icefox.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class init {
    public static Properties getPro() throws FileNotFoundException, IOException{
        Properties pro=new Properties();
//        File f=new File("fruit.properties");
//        if(f.exists()){
//        	System.out.println(f);
//            pro.load(new FileInputStream(f));
//        }else{
            pro.setProperty("apple", "com.icefox.reflect.Apple");
            pro.setProperty("orange", "com.icefox.reflect.Orange");
//            pro.store(new FileOutputStream(f), "FRUIT CLASS");
//        }
        return pro;
    }
}
