package com.it;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import com.alibaba.fastjson.JSONObject;


public class TestBlackQuery {

	private static String publicKey;
	private static String privateKey;
	
	
	public static void main(String[] args) throws Exception {
		//从物理硬盘地址读取文件
		publicKey = readFile("D:\\workspace\\workspace2\\example\\src\\main\\java\\cer\\yijia.cer");
		privateKey = readFile("D:\\workspace\\workspace2\\example\\src\\main\\java\\cer\\yijia.jks");
		
		//从项目中读取文件
//		publicKey = readFile(TestBlackQuery.class.getResourceAsStream("/cer/yijia.cer"));
//		privateKey = readFile(TestBlackQuery.class.getResourceAsStream("/cer/yijia.jks"));
		
		
		String url = "http://inside.puhuifinance.com/puhui-blacklist-http/blacklistTQuery/queryBlacklist";
		//拼装为json				   //授权码
		String data = paramsJson("12345678", "132828197507096076", "李明", "13145697410");
		//私钥加密
		byte[] databyte = RSAUtil.encryLongData(data.getBytes(), privateKey);
		//加密的内容信息
		String dataBase = RSAUtil.encryptBASE64(databyte);
		//签名
		String sign = RSAUtil.sign(databyte, privateKey);
		//请求的参数													   //机构码
		UrlEncodedFormEntity entity = HttpReq.paramInfo("companyCode", "yijia", "necessaryInfo", dataBase, "signature", sign);
		//发起请求，获得返回的结果
		String returnInfo = HttpReq.sendJsonWithHttps(url, entity);
		//将json串转为json对象
		JSONObject jsonObject = JSONObject.parseObject(returnInfo);
		String signature = jsonObject.getString("signature");//签名信息
		String resultData = jsonObject.getString("resultData");//返回的信息
		//如果机构码校验没有通过或发生异常会返回false信息
		if(signature.equals("false")){
			System.out.println(resultData);
		}else{
			//校验签名信息!!一定要验证签名信息
			boolean legal = RSAUtil.verify(RSAUtil.decryptBASE64(resultData), publicKey, signature);
			if(legal){
				byte[] resultDataByte = RSAUtil.decryLongData(RSAUtil.decryptBASE64(resultData), publicKey);
				String result = new String(resultDataByte);//返回的结果
				System.out.println(result);
				JSONObject jsObj = JSONObject.parseObject(result);
				boolean success = jsObj.getBoolean("success");
				if(success == true){//正确
					System.out.println("严重逾期:"+jsObj.getString("isOverdue"));//严重逾期
					System.out.println("欺诈客户:"+jsObj.getString("isCheat"));//欺诈客户
				}else{
					//错误的消息
					String mes = jsObj.getString("mes");
					System.out.println(mes);
				}
			}
		}
		
		
	}
	
	/**
	 * 读取信息
	 */
	public static String readFile(String filePath) throws Exception {
		File file = new File(filePath);
		StringBuilder sb = new StringBuilder();
		String s = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}
	/**
	 * 读取信息
	 */
	public static String readFile(InputStream in) throws Exception {
		StringBuilder sb = new StringBuilder();
		String s = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}
	
	/**
	 * 查询参数信息
	 * @param companyCode	机构码
	 * @param authorCode	授权码
	 * @param idNo			身份证号
	 * @param name			姓名
	 * @param phone			手机号
	 * @return
	 */
	public static String paramsJson(String authorCode, String idNo, String name, String phone){
		StringBuffer sb = new StringBuffer();
		sb.append("{")
		.append("\"authorCode\":")
		.append("\"" + authorCode + "\",")
		.append("\"idNo\":")
		.append("\"" + idNo + "\",")
		.append("\"name\":")
		.append("\"" + name + "\",")
		.append("\"phone\":")
		.append("\"" + phone + "\"")
		.append("}");
		return sb.toString();
	}
	
}
