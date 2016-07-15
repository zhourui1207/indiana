package com.jxlianlian.common;

import java.security.Key;

import com.jxlianlian.util.KeyUtil;

public final class Const {
  //JWT秘钥
  public static final String SECRET_KEY_STRING = "jxlianlian.zhourui";
  
  //短信模块，调用阿里大鱼接口
  public static final String SMS_URL = "http://gw.api.taobao.com/router/rest";
  public static final String SMS_APP_KEY = "23407772";
  public static final String SMS_SECRET = "0fcc51e262c2710b82004f49876705d1";
  public static final String SMS_TYPE = "normal";
  public static final String SMS_SIGN_NAME = "惊喜连连";
  public static final int SMS_VERIFY_TIME = 10;
  public static final String SMS_TEMPLATE_CODE_VERIFY = "SMS_12400448";
  public static final String SMS_TEMPLATE_CODE_NOTIFY = "SMS_12335355";
  
  public static final String API_VERSION = "1";
  public static final int PAG_SIZE_DEFAULE_WEB = 50;
  public static final int PAG_SIZE_DEFAULE_PHONE = 10;
}
