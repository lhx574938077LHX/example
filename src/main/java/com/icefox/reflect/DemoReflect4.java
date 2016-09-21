package com.icefox.reflect;

import java.lang.reflect.Constructor;

public class DemoReflect4 {
	
	public static void main(String[] args) {
	    Class<?> demo=null;
	    Class<?> demo1=null;
		try{
		    demo=Class.forName("com.icefox.reflect.Person");
		    demo1=Class.forName("com.icefox.reflect.Person1");
		}catch (Exception e) {
		    e.printStackTrace();
		}
		Person per1=null;
		Person per2=null;
		Person per3=null;
		Person per4=null;
		
		Person1 pern1=null;
		Person1 pern2=null;
		
        //取得父类
        Class<?> temp=demo.getSuperclass();
//        System.out.println("继承的父类为：   "+temp.getName());
		
		//得到实现接口
		Class<?>[] inter = demo1.getInterfaces();
		for (int i = 0; i < inter.length; i++) {
//			System.out.println("实现的接口："+inter[i]);
		}
		
		//取得全部的构造函数
		Constructor<?> cons[]=demo.getConstructors();
		Constructor<?> cons1[]=demo1.getConstructors();
		try{
	
			for (int i = 0; i < cons.length; i++) {
				//方法参数个数
//				System.out.println("Person的参数个数："+cons[i].getParameterCount());
				//得到参数的类型
				Class<?> p[]=cons[i].getParameterTypes();
				for(int j=0;j<p.length;++j){
	                System.out.print(p[j].getName()+" arg"+i);
	                if(j<p.length-1){
	                    System.out.print(",");
	                }
	            }
				System.out.println();
			}
			
			for (int i = 0; i < cons1.length; i++) {
				//方法参数个数
//				System.out.println("Person1的参数个数："+cons1[i].getParameterCount());
			}
			
		    per1=(Person)cons[0].newInstance();
		    per2=(Person)cons[1].newInstance("Rollen");
		    per3=(Person)cons[2].newInstance(20);
		    per4=(Person)cons[3].newInstance("Rollen",20);
		    
		    pern1=(Person1)cons1[0].newInstance();
		    pern2=(Person1)cons1[1].newInstance("男");
		
		}catch(Exception e){
		    e.printStackTrace();
		}
		System.out.println(per1);
		System.out.println(per2);
		System.out.println(per3);
		System.out.println(per4);	
		
		pern2.sayChina();
		pern1.sayHello("李洪翔", 25);
	}
	
}
