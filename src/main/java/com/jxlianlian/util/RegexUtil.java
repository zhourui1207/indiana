package com.jxlianlian.util;

import java.util.regex.Pattern;

/**
 * 正则工具
 * @author zhourui
 *
 */
public class RegexUtil {
  
  private static String phoneNoRegex = "^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
  
  // 8-20位数字、字母、下划线，两种或以上组合
  private static String pwdRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)(?![_]+$)[\\w]{8,20}$";
  
  public static boolean isPhoneNo(String phoneNo) {
    return phoneNo.matches(phoneNoRegex);
  }
  
  // 验证密码是否输入正确
  public static boolean isCorrectPassword(String pwd) {
    return pwd.matches(pwdRegex);
  }
 
}
