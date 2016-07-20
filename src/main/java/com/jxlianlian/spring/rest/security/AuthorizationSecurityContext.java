package com.jxlianlian.spring.rest.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class AuthorizationSecurityContext implements SecurityContext {
  
  private long currentUserId = 0L;
  private boolean isHttps = false;
  
  // 禁用默认构造器
  private AuthorizationSecurityContext() {
    
  }
  
  public AuthorizationSecurityContext(long currentUserId, boolean isHttps) {
    this.currentUserId = currentUserId;
  }
  
  @Override
  public Principal getUserPrincipal() {
    return new Principal() {
      @Override
      public String getName() {
        return "" + currentUserId;
      }
    };
  }

  // 传入用户ID，如果该请求是用户本身发送的，那么就返回 true
  @Override
  public boolean isUserInRole(String role) {
    if ((role != null) && (Long.parseLong(role) == currentUserId)) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isSecure() {
    return isHttps ? true : false;
  }

  @Override
  public String getAuthenticationScheme() {
    return "TOKEN";
  }

}
