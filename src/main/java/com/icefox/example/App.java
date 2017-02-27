package com.icefox.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.commons.lang3.RandomUtils;

import com.fasterxml.jackson.core.base.GeneratorBase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	//数组 List 相互转换
    	List<String> list = new ArrayList<String>();
    	list.add("a");
    	list.add("b");
    	Object[] strs = list.toArray();
    	System.out.println(strs[0]);
    	
    	String[] strss = list.toArray(new String[1]);
    	System.out.println(strss[0]);
    	
    	List list1 = Arrays.asList(strss);
    	System.out.println(list1.get(0));
    	
    	
    	System.out.println(RandomUtils.nextInt(1, 999999));
    	System.out.println(String.format("P2P%06d", RandomUtils.nextInt(1, 999999)));
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
