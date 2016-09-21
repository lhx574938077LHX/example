package com.icefox.bean;

import java.io.FileInputStream;
import java.io.InputStream;

import sun.misc.BASE64Encoder;

public class PictureToString {
	
	public static void main(String[] args) {
		String pathStr = "C:\\Users\\LHX\\Desktop\\91征信接口开发文件\\abc.jpg";
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(pathStr);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println((new BASE64Encoder()).encodeBuffer(data)); //Base64编码过的字节数组字符串
	}
	
}
