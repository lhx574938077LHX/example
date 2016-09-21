package com.icefox.security;

import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public abstract class PBECoder extends Coder{

    /**
     * 支持以下任意一种算法
     * 
     * <pre>
     * PBEWithMD5AndDES 
     * PBEWithMD5AndTripleDES 
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     * </pre>
     */
    public static final String ALGORITHM = "PBEWITHMD5andDES";
  
    /**
     * 盐初始化
     * 
     * @return
     * @throws Exception
     */
    public static byte[] initSalt() throws Exception {
        byte[] salt = new byte[8];
        Random random = new Random();
        random.nextBytes(salt);
        return salt;
    }
  
    /**
     * 转换密钥<br>
     * 
     * @param password
     * @return
     * @throws Exception
     */
    private static Key toKey(String password) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
  
        return secretKey;
    }
  
    /**
     * 加密
     * 
     * @param data 数据
     * @param password 密码
     * @param salt  盐
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password,byte[] salt)
            throws Exception {
  
        Key key = toKey(password);
  
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
  
        return cipher.doFinal(data);
  
    }
  
    /**
     * 解密
     * 
     * @param data  数据
     * @param password 密码
     * @param salt  盐
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password,byte[] salt)
            throws Exception {
  
        Key key = toKey(password);
  
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
  
        return cipher.doFinal(data);
  
    }
    
    public static void main(String[] args) {
    	String str = "测试内容";
    	String key = "1";
    	try {    	
        	byte[] salt = PBECoder.initSalt();
        	byte[] result = PBECoder.encrypt(str.getBytes(),key,salt);
        	System.out.println("加密后："+new String(result));

        	//直接将如上内容解密
	    	byte[] decryResult = PBECoder.decrypt(result, key,salt);
	    	System.out.println("解密后："+new String(decryResult));
    	} catch (Exception e1) {
    		e1.printStackTrace();
    	}
	}
    
}

