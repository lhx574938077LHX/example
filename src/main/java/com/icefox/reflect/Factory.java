package com.icefox.reflect;


public class Factory {
   public static fruit getInstance(String ClassName){
        fruit f=null;
        try{
        	System.out.println(ClassName);
            f=(fruit)Class.forName(ClassName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
