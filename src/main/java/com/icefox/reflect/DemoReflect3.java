package com.icefox.reflect;

public class DemoReflect3 {
	
	public static void main(String[] args) {
		Class<?> demo=null;
		    try{
		        demo=Class.forName("com.icefox.reflect.Person");
		}catch (Exception e) {
		    e.printStackTrace();
		}
		Person per=null;
		try {
		    per=(Person)demo.newInstance();
		    
		} catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		}
		per.setName("Allen");
		per.setAge(40);
		System.out.println(per);		
	}
	
}
