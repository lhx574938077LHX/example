package com.icefox.reflect;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoReflect10 {
   public static void main(String[] a) throws FileNotFoundException, IOException{
        Properties pro=init.getPro();
        fruit f=Factory.getInstance(pro.getProperty("orange"));
        if(f!=null){
            f.eat();
        }
    }
}
