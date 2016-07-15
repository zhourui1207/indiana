package com.jxlianlian.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class KeyUtil {
  
  //生成HS512秘钥，保存在file
  public static Key generateKey(String secret) {
    String md5 = DigestUtils.md5Hex(secret);
    return new SecretKeySpec(md5.getBytes(), SignatureAlgorithm.HS512.getJcaName());
  }

  public static void main(String[] args) {
    Key key = generateKey("jxlianlian_zhourui");
    String encoded = "";
    try {
      encoded = new String(key.getEncoded(),"UTF-8");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out
        .println("format=" + key.getFormat() + ", encoded=" + encoded + ", Algorithm=" + key.getAlgorithm());
    String compactJws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();
    System.out.println(compactJws);
    
    try {
      Jws<Claims> jc = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
      System.out.println("jc=" + jc);
    } catch (SignatureException e) {
      System.out.println("failed");
    }
  }
}
