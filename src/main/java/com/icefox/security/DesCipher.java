package com.icefox.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;

public class DesCipher
{
	private static String CIPHER_DES_KEY="htxy2015";
	
  //加密
  public static String encryptData(String paramString)
  {
    return encryptData(paramString, DesCipher.CIPHER_DES_KEY);
  }
  
  public static String encryptData(String paramString1, String paramString2)
  {
    Cipher localCipher = null;
    try
    {
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString2.getBytes());
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      localCipher.init(1, localSecretKey);
    }
    catch (Exception ex)
    {
     ex.printStackTrace();
    }
    byte[] arrayOfByte = null;
    try
    {
      arrayOfByte = localCipher.doFinal(paramString1.getBytes());
    }
    catch (Exception ex)
    {
    	ex.printStackTrace();
    }
    if (arrayOfByte != null) {
      return new String(Base64.encodeBase64(arrayOfByte));
    }
    return null;
  }
  
  //解密
  public static String decryptData(String paramString)
  {
    return decryptData(paramString, DesCipher.CIPHER_DES_KEY);
  }
  
  public static String decryptData(String paramString1, String paramString2)
  {
    byte[] arrayOfByte1 = null;
    if (paramString1 != null) {
      arrayOfByte1 = Base64.decodeBase64(paramString1);
    }
    Cipher localCipher = null;
    try
    {
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString2.getBytes());
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      localCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      localCipher.init(2, localSecretKey);
    }
    catch (Exception ex)
    {
     ex.printStackTrace();
    }
    byte[] arrayOfByte2 = null;
    try
    {
      arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
      if (arrayOfByte2 != null) {
        return new String(arrayOfByte2);
      }
    }
    catch (Exception ex)
    {
    	ex.printStackTrace();
    }
    return null;
  }
}
