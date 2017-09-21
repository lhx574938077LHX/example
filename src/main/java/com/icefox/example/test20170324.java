package com.icefox.example;

public class test20170324 {
	
	public static void main(String[] args) {
		test20170324 test = new test20170324();
		StringBuffer str=new StringBuffer("a");
		Integer i=1;
		test.changeInt(i);
		System.out.println(i);
		test.changeStr(str);
		System.out.println(str);
		
		String str1 = "abc";
		System.out.println(str1.indexOf("b"));
		System.out.println(str1.length());
		System.out.println(str1.contains("abc"));
		
		char [] stringArr = str1.toCharArray(); 
	}
	
	public void changeStr(StringBuffer str){
		str=str.append("abc");
	}
	
	public void changeInt(Integer i){
		i=i+5;
	}
}
