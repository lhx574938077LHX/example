package com.icefox.security;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.icefox.bean.BASE64Decoder;
import com.icefox.bean.BASE64Encoder;



public class Coder {

    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";
 
    /**
     * MAC算法可选以下多种算法
     * 
     * <pre>
     * HmacMD5 
     * HmacSHA1 
     * HmacSHA256 
     * HmacSHA384 
     * HmacSHA512
     * </pre>
     */
    public static final String KEY_MAC = "HmacMD5";
 
    /**
     * BASE64解密
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }
 
    /**
     * BASE64加密
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
 
    /**
     * MD5加密
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
 
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
 
        return md5.digest();
 
    }
 
    /**
     * SHA加密
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {
 
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);
 
        return sha.digest();
 
    }
 
    /**
     * 初始化HMAC密钥
     * 
     * @return
     * @throws Exception
     */
    public static String initMacKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
 
        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }
 
    /**
     * HMAC加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
 
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
 
        return mac.doFinal(data);
 
    }
    
    /**
     * DES加密
     * @param datasource
     * @param key  密码，长度要是8的倍数
     * @return
     */
    public static byte[] encryptDES(byte[] datasource, String key) { 
    	try{
	    	SecureRandom random = new SecureRandom();
	    	DESKeySpec desKey = new DESKeySpec(key.getBytes());
	    	//创建一个密匙工厂，然后用它把DESKeySpec转换成
	    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	    	SecretKey securekey = keyFactory.generateSecret(desKey);
	    	//Cipher对象实际完成加密操作
	    	Cipher cipher = Cipher.getInstance("DES");
	    	//用密匙初始化Cipher对象
	    	cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
	    	//现在，获取数据并加密
	    	//正式执行加密操作
	    	return cipher.doFinal(datasource);
    	}catch(Throwable e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    /**
     * DES解密
     * @param src
     * @param key 密码，长度要是8的倍数
     * @return
     * @throws Exception
     */
    public static byte[] decryptDES(byte[] src, String key) throws Exception {
    	// DES算法要求有一个可信任的随机数源
    	SecureRandom random = new SecureRandom();
    	// 创建一个DESKeySpec对象
    	DESKeySpec desKey = new DESKeySpec(key.getBytes());
    	// 创建一个密匙工厂
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    	// 将DESKeySpec对象转换成SecretKey对象
    	SecretKey securekey = keyFactory.generateSecret(desKey);
    	// Cipher对象实际完成解密操作
    	Cipher cipher = Cipher.getInstance("DES");
    	// 用密匙初始化Cipher对象
    	cipher.init(Cipher.DECRYPT_MODE, securekey, random);
    	// 真正开始解密操作
    	return cipher.doFinal(src);
	}
    
    public static void main(String args[]) {
    	//待加密内容
    	String str = "测试内容";
    	//密码，长度要是8的倍数
    	String key = "PBEWITHMD5andDES";

    	byte[] result = Coder.encryptDES(str.getBytes(),key);
    	System.out.println("加密后："+new String(result));

    	//直接将如上内容解密
    	try {
	    	byte[] decryResult = Coder.decryptDES(result, key);
	    	System.out.println("解密后："+new String(decryResult));
    	} catch (Exception e1) {
    		e1.printStackTrace();
    	}
    }
}

