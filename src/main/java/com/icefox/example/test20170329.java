package com.icefox.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class test20170329 {
	
	public static void main(String[] args) {
		//Integer转换成int的方法  Integer.intValue();  
		Integer i1 = new Integer(10);   
		int k = i1.intValue(); 
		//int转换成Integer  
		int i2 = 10;  
		Integer i3 = new Integer(i2); 
		
		//String转换成int的方法  int i = Integer.intValue(string);  
		String str = "10";    
		Integer i4 = new Integer(str);    
		int i5 = i4.intValue(); 
		
		//int转换成String  
		int i6 = 10;  
		String s1 = String.valueOf(i6);  
		String s2 = Integer.toString(i6);  
		String s3 = "" + i6;
		
		//String转换成Integer  
		String str1 = "10";  
		Integer i7 = Integer.valueOf(str1); 
		
		//Integer转换成String  
		Integer it = new Integer(10);  
		String str2 = it.toString(); 
		
		str2.equals("10");
		
		ArrayList<String> list = new ArrayList<String>();
		
	}
	
	public void sort(TreeMap<String,Integer> map){
		Set<Entry<String, Integer>> s = map.entrySet();
		List<Entry<String,Integer>> list =new ArrayList<Entry<String,Integer>>(s);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		    public int compare(Map.Entry<String, Integer> o1,
		            Map.Entry<String, Integer> o2) {
		        return (o2.getValue() - o1.getValue());
		    }
		});
	}
	
}
