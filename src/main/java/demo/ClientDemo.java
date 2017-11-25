package demo;

import com.google.gson.Gson;
import entity.FourElements;
import entity.GsSearch;
import entity.IdPhoto;
import entity.ThreeElements;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class ClientDemo {
	
	public static void main(String[] args) {
//		sfAuth3JO(); //三要素
//		idCardPhotoJO();//身份证照片接口
	    String str = new String("***");
	    String str1 = new String("***");
	    System.out.println(str.equalsIgnoreCase(str1));
	    System.out.println(str == str1);
	    System.out.println(str.hashCode());
	    
	    Map<String, String> hashMap = new HashMap<String, String>();  
	    hashMap.put("70317", "曲阳");  
	    hashMap.put("71121", "在东");  
	    hashMap.put("70333", "商音");  
	    hashMap.put("80000", "有恒");  
	    for(Map.Entry<String, String> entry: hashMap.entrySet()) {  
	        String key = entry.getKey();  
	        String value = entry.getValue();  
	        System.out.println("key:" + key + ";value:" + value);  
	    }  
	}

	/**
	 * 三要素认证（姓名、身份证号、银行卡）
	 */
	private static void sfAuth3JO(){
		String url = "http://192.168.2.254:8080/service/tpapi/sfAuth3JO.do?realName=李洪翔&idCard=230381199103106018&accountNo=6214830128050282";	//数据服务地址
		CloseableHttpClient httpclient = createSSLClientDefault();

		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("COMPANY_CODE","P2PSURZ3026321123");
		httpGet.addHeader("CONN_KEY","0fedf523f1339e65f45404da4d7113ab");
		CloseableHttpResponse response;
		String result = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity rspEntity = response.getEntity();

			if (rspEntity != null) {
				result = EntityUtils.toString(rspEntity);
			}
			Gson gson = new Gson();
			ThreeElements threeElements = gson.fromJson(result, ThreeElements.class);
			//输出返回信息
			System.out.println("姓名："+threeElements.getName());
			System.out.println("身份证号："+threeElements.getIdCard());
			System.out.println("银行卡号："+threeElements.getAccountNo());
			System.out.println("返回消息："+threeElements.getRetMsg());
			System.out.println("返回代码："+threeElements.getRetCode());
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 四要素认证（姓名、身份证号、银行卡、银行卡预留手机）
	 */
	private static void sfAuth4JO(){
		String url = "http://192.168.2.254:8080/service/tpapi/sfAuth4JO.do?realName=郝茹义&idCard=21032119900630141X&accountNo=6217860100004290733&bankPreMobile=15321882200";	//数据服务地址
		CloseableHttpClient httpclient = createSSLClientDefault();

		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("COMPANY_CODE","P2PSURZ3026321123");
		httpGet.addHeader("CONN_KEY","0fedf523f1339e65f45404da4d7113ab");
		CloseableHttpResponse response;
		String result = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity rspEntity = response.getEntity();

			if (rspEntity != null) {
				result = EntityUtils.toString(rspEntity);
			}
			Gson gson = new Gson();
			FourElements fourElements = gson.fromJson(result, FourElements.class);
			//输出返回信息
			System.out.println("姓名："+fourElements.getName());
			System.out.println("身份证号："+fourElements.getIdCard());
			System.out.println("银行卡号："+fourElements.getAccountNo());
			System.out.println("银行预留手机号："+fourElements.getBankPreMobile());
			System.out.println("返回消息："+fourElements.getRetMsg());
			System.out.println("返回代码："+fourElements.getRetCode());
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 身份证照片接口（姓名、身份证号）
	 */
	private static void idCardPhotoJO(){
		String url = "http://192.168.2.254:8080/service/tpapi/idCardPhotoJO.do?realName=郝茹义&idCard=21032119900630141X";	//数据服务地址
		CloseableHttpClient httpclient = createSSLClientDefault();

		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("COMPANY_CODE","P2PSURZ3026321123");
		httpGet.addHeader("CONN_KEY","0fedf523f1339e65f45404da4d7113ab");
		CloseableHttpResponse response;
		String result = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity rspEntity = response.getEntity();

			if (rspEntity != null) {
				result = EntityUtils.toString(rspEntity);
			}
			Gson gson = new Gson();
			IdPhoto idPhoto = gson.fromJson(result, IdPhoto.class);
			//输出返回信息
			System.out.println("姓名："+idPhoto.getName());
			System.out.println("身份证号："+idPhoto.getIdCard());
			System.out.println("照片流："+idPhoto.getIdPhoto());
			System.out.println("返回消息："+idPhoto.getRetMsg());
			System.out.println("返回代码："+idPhoto.getRetCode());
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 身份证照片接口（姓名、身份证号）
	 */
	private static void gsSearchLJO(){
		String url = "http://192.168.2.254:8080/service/tpapi/gsSearchLJO.do?idCard=35042819690222451X";	//数据服务地址
		CloseableHttpClient httpclient = createSSLClientDefault();

		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("COMPANY_CODE","P2PSURZ3026321123");
		httpGet.addHeader("CONN_KEY","0fedf523f1339e65f45404da4d7113ab");
		CloseableHttpResponse response;
		String result = "";
		try {
			response = httpclient.execute(httpGet);
			HttpEntity rspEntity = response.getEntity();

			if (rspEntity != null) {
				result = EntityUtils.toString(rspEntity);
			}
			Gson gson = new Gson();
			GsSearch gsSearch = gson.fromJson(result, GsSearch.class);
			//输出返回信息
			System.out.println("返回消息："+gsSearch.getRetMsg());
			System.out.println("返回代码："+gsSearch.getRetCode());

			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private  static CloseableHttpClient createSSLClientDefault(){
		try {
			 SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			 //信任所有
			     public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
			         return true;
			     }
			 }).build();
			 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			 return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		 } catch (KeyManagementException e) {
		     e.printStackTrace();
		 } catch (NoSuchAlgorithmException e) {
		     e.printStackTrace();
		 } catch (KeyStoreException e) {
		     e.printStackTrace();
		 }
		 return  HttpClients.createDefault();
	}
}

