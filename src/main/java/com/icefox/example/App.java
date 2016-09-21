package com.icefox.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String source = "5/13/2012 12:00:00 AM";
    	String format = "MM/dd/yyyy hh:mm:ss";
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			result = sdf.parse(source);
			System.out.println(result);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间格式不正确！");
		}
    }
}
