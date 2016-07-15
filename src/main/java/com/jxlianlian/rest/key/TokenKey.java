package com.jxlianlian.rest.key;

import java.security.Key;

import com.jxlianlian.common.Const;
import com.jxlianlian.util.KeyUtil;

public class TokenKey {
  public static final Key SECRET_KEY = KeyUtil.generateKey(Const.SECRET_KEY_STRING);
}
