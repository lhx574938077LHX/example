package com.icefox.security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import com.it.RSAUtil;

public class TestService {
	
	private static String publicKey;  //公钥
	private static String privateKey; //私钥
	private static String companyCode = "P2P4HJK0000100010";
	
	public static void main(String[] args) {
		
		try {
			CloseableHttpClient httpclient =  HttpClients.createDefault();
			String url = "http://localhost:9080/jyzxclient_web/search/sendTestSecurity.do";
			HttpPost post = new HttpPost(url);
			publicKey = readFile("D:\\workspace\\workspace2\\example\\src\\main\\java\\cer\\filePulbicKey.cer");
			privateKey = readFile("D:\\workspace\\workspace2\\example\\src\\main\\java\\cer\\filePrivateKey.jks");
			
			String data = changeStr("李洪翔","230381199103106018");
			//私钥加密
			byte[] dataByte = RSAUtils.encryLongData(data.getBytes(), privateKey);
			//设置签名
			String sign = RSAUtils.sign(dataByte, privateKey);
			//加密的内容信息
			String dataBase = RSAUtil.encryptBASE64(dataByte);
			
			ReqPkg reqPkg = new ReqPkg(); 
			reqPkg.setCompanyCode(companyCode);
			reqPkg.setData(dataBase);
			reqPkg.setSign(sign);
			String reqPkgStr = reqPkg.toString();
			
			ByteArrayEntity reqEntity;
			reqEntity = new ByteArrayEntity(reqPkgStr.getBytes("UTF-8"));
			post.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			
			String result = IOUtils.toString(entity.getContent(), "UTF-8");
			String[] strs = result.split("\\|");
			
			String dataResult = strs[0];
			String companyCodeResult = strs[1];
			String signResult = strs[2];
			
			//验证数字签名
			boolean legal = RSAUtils.verify(KeyGenerater.decryptBASE64(dataResult), publicKey, signResult);
			
			if(legal){
				//解密数据
				byte[] dataResultByte = RSAUtils.decryLongData(KeyGenerater.decryptBASE64(dataResult), publicKey);
				String dataResultFinal = new String(dataResultByte);
				System.out.println("客户端："+dataResultFinal);
				System.out.println("客户端："+companyCodeResult);
				
				JSONObject resultJson = new JSONObject(dataResultFinal);	
//				boolean isBlack = (boolean) resultJson.get("isBlack");
				String repayDate = (String) resultJson.get("repayDate");
//				System.out.println("是否逾期："+isBlack+"---逾期天数："+repayDate);
			}else{
				System.out.println("签名不对！");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String changeStr(String name, String idCard) {
		StringBuffer sb = new StringBuffer();
		sb.append("{")
		.append("\"idCard\":")
		.append("\"" + idCard + "\",")
		.append("\"name\":")
		.append("\"" + name + "\"")
		.append("}");
		return sb.toString();
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
	
}
