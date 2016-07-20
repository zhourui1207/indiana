package com.jxlianlian.spring.rest.token.key;

import java.security.Key;

import com.jxlianlian.common.Const;
import com.jxlianlian.util.KeyUtil;

import io.jsonwebtoken.SignatureAlgorithm;

public class TokenKey {
  public static final SignatureAlgorithm KEY_ALG = SignatureAlgorithm.HS512;
  public static final Key SECRET_KEY = KeyUtil.generateKey(KEY_ALG, Const.SECRET_KEY_STRING);
}
