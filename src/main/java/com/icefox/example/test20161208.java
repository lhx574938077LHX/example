package com.icefox.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class test20161208 {
	
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("^0[0-9]{2,3}[-|－][0-9]{7,8}([-|－][0-9]{1,4})?$");
//		String phone = "";
//		pattern.matcher(phone).matches();
//		String   s= "Hello"; 
//		s= "Java"; 
//		String   s1= "Hello"; 
//		System.out.println(s==s1);
//		String   s2=new   String( "Hello"); 
//		int a[] = {3,1,5,7,2,4,9,6}; 
//		test20161208 t = new test20161208();
//	    t.InsertSort(a);
//	    for(int i=0;i<a.length-1;i++) System.out.println(i+":"+a[i]);
//	    StringBuffer b=new StringBuffer("321");
//		t.lalala(b);
//		System.out.println(b);
//		int c=1;
//		t.lala(c);
//		System.out.println(c);
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
		Object p =new Object();
		
	}
	void InsertSort(int a[])  
	{  
	    for(int i= 1; i<a.length; i++){  
	        if(a[i] < a[i-1]){               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入  
	           int j= i-1;   
	           int x = a[i];        //复制为哨兵，即存储待排序元素  
	            a[i] = a[i-1];           //先后移一个元素  
	            while(j>=0&&x < a[j]){  //查找在有序表的插入位置  
	                a[j+1] = a[j];  
	                j--;         //元素后移  
	            }  
	            a[j+1] = x;      //插入到正确位置  
	        }  
	    }  
	     
	}  
	
	void lala(int a){
		a=4;
	}
	void lalala(StringBuffer a){
		a.append("123");
	}

}
