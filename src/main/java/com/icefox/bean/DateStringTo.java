package com.icefox.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringTo {
	public static void main(String[] args) {
		
		String str1 = "2016-06-30 11:32:00";
		String str2 = "2016-06-29 23:28:00";
//		String str1 = args[0];
//		String str2 = args[1];
		SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		try {
			Date date1 = format.parse(str1);  
			Date date2 = format.parse(str2); 
			System.out.println(date1.getTime());
			System.out.println(date2.getTime());
			
			String strs1 = format.format(new Date(1470844800000L));
			String strs2 = format.format(date2);
			System.out.println(strs1);
			System.out.println(strs2);
		} catch (ParseException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
