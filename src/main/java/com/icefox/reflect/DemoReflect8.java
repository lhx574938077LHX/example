package com.icefox.reflect;

import java.lang.reflect.Array;

public class DemoReflect8 {
	public static void main(String[] args) {
		
		//获取类加载器
		Person person = new Person();
		System.out.println("类加载器  "+person.getClass().getClassLoader().getClass().getName());
		
        int[] temp={1,2,3,4,5,6,7,8,9};
        int[] newTemp=(int[])arrayInc(temp,15);//只能比之前的大
        print(newTemp);
        System.out.println();
        String[] atr={"a","b","c"};
        String[] str1=(String[])arrayInc(atr,8);
        print(str1);
    }
     
    /**
     * 修改数组大小
     * */
    public static Object arrayInc(Object obj,int len){
        Class<?>arr=obj.getClass().getComponentType();
        Object newArr=Array.newInstance(arr, len);
        int co=Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);//复制数组方法
        return newArr;
    }
    /**
     * 打印
     * */
    public static void print(Object obj){
        Class<?>c=obj.getClass();
        if(!c.isArray()){
            return;
        }
        System.out.println("数组长度为： "+Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i)+" ");
        }
    }
}
