package com.icefox.example;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class changeUnio {
		
	public static void main(String[] args)  {
		String str = "浠诲姟鍚姩鏃跺埢"+
					"浠诲姟缁撴潫鏃跺埢 "+
					"浠诲姟鎬昏鑰楁椂 "+
					"浠诲姟骞冲潎娴侀噺 "+
					"璁板綍鍐欏叆閫熷害  "+
					"璇诲嚭璁板綍鎬绘暟 "+
					"璇诲啓澶辫触鎬绘暟";
		try {
			byte[] temp=str.getBytes("gbk");
			String newStr=new String(temp,"utf-8");
			System.out.println(newStr);
			
			String[] postDataStr = StringUtils.splitPreserveAllTokens("a|b|c","|");
			System.out.println(postDataStr[1]);
			
			//unicode to String
			String s = "\\u79fb\\u52a8\\u4e92\\u8054\\u7f51\\u5e94\\u7528";
	        String s2 = StringEscapeUtils.unescapeJava(s);
	        System.out.println(s);
	        System.out.println(s2);
			
	        String str1 = "{\"index\":\"1\"}";
			//url 编码解码
	        String result = java.net.URLEncoder.encode(str1, "UTF-8");
	        System.out.println(result);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
