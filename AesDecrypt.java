package com.learning.aes;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

public class AesDecrypt {

  public static String decrypt(String data, String key, String iv) {
    try {
      byte[] encrypted1 = new Base64().decode(data);

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

      cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

      byte[] original = cipher.doFinal(encrypted1);
      return new String(original, StandardCharsets.UTF_8);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args)  {

    String key = "ALFAGIFT1V09O17L1019E2991V09MAPI";
    String iv = "2022E2991V09O17L";

    String decrypt = decrypt("qzHpTEdZonmGB6WwiNzFkQ==", key, iv);
    System.out.println("decryption:"  + decrypt);
  }


}
