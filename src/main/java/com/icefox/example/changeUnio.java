package com.icefox.example;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class changeUnio {
		
	public static void main(String[] args)  {
		String str = "缁廌ataX鏅鸿兘鍒嗘瀽,璇ヤ换鍔℃渶鍙兘鐨勯敊璇師鍥犳槸:com.alibaba.datax.common.exception.DataXException: Code:[DBUtilErrorCode-01], Description:[鑾峰彇琛ㄥ瓧娈电浉鍏充俊鎭け璐?].  - 鑾峰彇琛?BLACK_ONE 鐨勫瓧娈电殑鍏冧俊鎭椂澶辫触. 璇疯仈绯?DBA 鏍告煡璇ュ簱銆佽〃淇℃伅. - java.sql.SQLSyntaxErrorException: ORA-00904: REAL_NAME: 鏍囪瘑绗︽棤鏁?";
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
