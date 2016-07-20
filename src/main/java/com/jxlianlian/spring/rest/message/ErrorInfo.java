package com.jxlianlian.spring.rest.message;

public class ErrorInfo {
  public static String NO_AUTHORIZED = "没有权限";
  public static String USER_NO_EXISTED = "用户不存在";
  public static String USER_EXISTED = "用户已存在";
  public static String MUST_USE_HTTPS = "高安全API必须使用HTTPS协议";
  public static String USERNAME_OR_PASSWORD_INCORRECT = "用户名或密码不正确";
  public static String PHONE_INCORRECT = "请使用正确的手机号";
  public static String PWD_INCORRECT = "密码不符合规范";
  public static String USER_CLOSE_DOWN = "用户已被禁用";
  public static String SUBMIT_INCORRECT = "提交的内容不正确";
  public static String QUERY_CONDITION_INCORRECT = "查询条件不正确";
  public static String ACCESS_DB_FAILED = "访问数据库失败";
  public static String EXECUTE_SQL_FAILED = "执行SQL失败";
  public static String DATA_INCORRECT = "数据错误";
  public static String TOKEN_TIMEOUT = "用户令牌超时，请重新登录";
  public static String SERVER_ERROR = "服务器内部错误";
  public static String UNKNOWN = "未知错误";

  public static String messagge(int errorCode, String errorMsg) {
    return "{\"error_code\":" + errorCode + ",\"error_msg\":\"" + errorMsg + "\"}";
  }
}
