package com.jxlianlian.util;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
  /**
   * 由Request获取IP,应由工具类提供. 本工具类仅供测试应用, 获取浏览器端IP依据应用环境不同, 以下代码无法一一覆盖.
   * 
   * @param request
   * @return
   */
  public static String getIpAddr(HttpServletRequest request) {
    try {
      String ip = request.getHeader("x-forwarded-for");

      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("http_client_ip");
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
      }
      // .....
      // 如果是多级代理，那么取第一个ip为客户ip
      if (ip != null && ip.indexOf(",") != -1) {
        ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
      }
      return ip;
    } catch (Throwable e) {
      return "unknow";
    }
  }
}
