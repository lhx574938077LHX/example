package com.icefox.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class DemoReflect7 {
	
	//操作属性
	public static void main(String[] args) {
        Class<?> demo = null;
        Object obj = null;
        try {
        	 demo = Class.forName("com.icefox.reflect.Person1");
             obj = demo.newInstance();
             
             Field field = demo.getDeclaredField("sex");
             field.setAccessible(true);
             field.set(obj, "男");
             System.out.println(field.get(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        //反射操作数组
        int[] temp={1,2,3,4,5};
        Class<?> demo1=temp.getClass().getComponentType();
        System.out.println("数组类型： "+demo1.getName());
        System.out.println("数组长度  "+Array.getLength(temp));
        System.out.println("数组的第一个元素: "+Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： "+Array.get(temp, 0));
        
	}
	
}
