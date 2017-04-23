package com_javaMAC;
 
import java.lang.reflect.UndeclaredThrowableException; 
import java.math.BigInteger;
import java.nio.ByteBuffer; 
import java.security.GeneralSecurityException; 
 
import javax.crypto.Mac; 
import javax.crypto.spec.SecretKeySpec; 
 
public class TOTP { 
 
 private static final String CRYPTO = "HmacSHA1"; 
 
 private TOTP() { 
 } 
 
 /**
  * This method uses the JCE to provide the crypto algorithm. HMAC computes a 
  * Hashed Message Authentication Code with the crypto hash algorithm as a 
  * parameter. 
  *  
  * @param crypto 
  *            : the crypto algorithm (HmacSHA1, HmacSHA256, HmacSHA512) 
  * @param keyBytes 
  *            : the bytes to use for the HMAC key 
  * @param text 
  *            : the message or text to be authenticated 
  */ 
 
 private static byte[] hmacSha(String crypto, byte[] keyBytes, byte[] text) { 
  try { 
   Mac hmac; 
   hmac = Mac.getInstance(crypto); 
   SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW"); 
   hmac.init(macKey); 
   return hmac.doFinal(text); 
  } catch (GeneralSecurityException gse) { 
   throw new UndeclaredThrowableException(gse); 
  } 
 } 
 
 public static int generateTOTP() {
     String keyString = "3132333435363738393031323334353637383930"; 
        byte[] key = hexStr2Bytes(keyString);
 
  byte[] msg = ByteBuffer.allocate(8).putLong(getCurrentInterval()).array(); 
  byte[] hash = hmacSha(CRYPTO, key, msg); 
 
  // put selected bytes into result int 
  int offset = hash[hash.length - 1] & 0xf; 
 
  int binary = ((hash[offset] & 0x7f) << 24) | ((hash[offset + 1] & 0xff) << 16) | ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff); 
 
  int otp = binary % 1000000;
 
  return otp; 
 } 
 
 private static long getCurrentInterval() { 
        long currentTimeSeconds = System.currentTimeMillis() / 1000L; 
        return currentTimeSeconds / 30L; 
    }
 
 private static byte[] hexStr2Bytes(String hex){
              byte[] bArray = new BigInteger("10" + hex,16).toByteArray();
              byte[] ret = new byte[bArray.length - 1];
              for (int i = 0; i < ret.length; i++)
                          ret[i] = bArray[i+1];
              
              return ret;
  }
}
