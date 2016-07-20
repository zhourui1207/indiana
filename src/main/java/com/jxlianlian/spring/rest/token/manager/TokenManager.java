package com.jxlianlian.spring.rest.token.manager;

import java.util.Date;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.rest.token.key.TokenKey;
import com.jxlianlian.spring.rest.token.model.Token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

public class TokenManager {
  // 创建Token
  public static String createToken(long userId, int userType, boolean isPhone) {
    JwtBuilder jwtBuilder = Jwts.builder();
    jwtBuilder.setIssuer(Const.JWT_ISS);
    jwtBuilder.setSubject("" + userId);
    long exp = isPhone ? Const.JWT_PHONE_EXP : Const.JWT_WEB_EXP;
    jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + exp));
    jwtBuilder.claim(Const.P_USER_TYPE, userType);
    jwtBuilder.claim(Const.P_IS_PHONE, isPhone);
    return jwtBuilder.signWith(TokenKey.KEY_ALG, TokenKey.SECRET_KEY).compact();
  }

  // 解析Token
  public static Token parseToken(String jwt) {
    Jws<Claims> jc = Jwts.parser().setSigningKey(TokenKey.SECRET_KEY).parseClaimsJws(jwt);
    Claims claims = jc.getBody();
    String issuer = claims.getIssuer();
    long expTime = claims.getExpiration().getTime();
    if (issuer.equals(Const.JWT_ISS) && expTime > System.currentTimeMillis()) {
      return new Token(Long.parseLong(claims.getSubject()), expTime, (int) claims.get(Const.P_USER_TYPE),
          (boolean) claims.get(Const.P_IS_PHONE));
    }
    return null;
  }

}
