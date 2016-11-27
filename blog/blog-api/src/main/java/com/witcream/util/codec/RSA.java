package com.witcream.util.codec;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSA
{
  private static final String ALGORITHM = "RSA";
  private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
  private static final String DEFAULT_CHARSET = "UTF-8";
  
  public static String encryptRSA(String content, String privateKey)
  {
    try
    {
      PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
      KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
      PrivateKey priKey = keyf.generatePrivate(priPKCS8);
      Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
      signature.initSign(priKey);
      signature.update(content.getBytes(DEFAULT_CHARSET));
      byte[] signed = signature.sign();
      return Base64.encodeToString(signed, false);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
