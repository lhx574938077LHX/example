package com.icefox.example;

import java.util.regex.Pattern;

public class test20161208 {
	
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^0[0-9]{2,3}[-|－][0-9]{7,8}([-|－][0-9]{1,4})?$");
		String phone = "";
		pattern.matcher(phone).matches();
	}
	
}
