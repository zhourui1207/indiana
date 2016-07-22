package com.jxlianlian.spring.rest.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Principal;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.rest.token.manager.TokenManager;
import com.jxlianlian.spring.rest.token.model.Token;

@Component // 注入spring
@Provider // 被jax-rs搜索到
@Priority(Priorities.AUTHENTICATION) // 认证级别，优先级最高，多个拦截器的话，先执行这个
@Authorization
public class AuthorizationFilter implements ContainerRequestFilter {

  private Logger logger = Logger.getLogger(AuthorizationFilter.class);

  @Context
  private HttpServletRequest httpServletRequest;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    logger.info("uthorizationFilter " + requestContext.getUriInfo().getPath() + " cok=" + requestContext.getCookies());
    // 从header中得到token
    String auth = requestContext.getHeaderString(Const.TOKEN_HEADER);
    
    if (auth == null) { // header找不到就到cookie中查找
      Cookie cookie = requestContext.getCookies().get(Const.TOKEN_HEADER);
      if (cookie != null) {
        auth = cookie.getValue();
      }
    }
    if (auth != null) { // 找到token
      // 验证token
      Token token = TokenManager.parseToken(auth);
      if (token != null) { // token解析成功
        logger.info(token.toString());
        // 如果token验证成功，将token对应的用户id存在request中
        httpServletRequest.setAttribute(Const.CURRENT_USER_ID, token.getUserId());
        return;
      }
    }
    requestContext.abortWith(Response.status(StatusCode.UNAUTHORIZED)
        .entity(ErrorInfo.messagge(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED)).build()); // 未认证
  }

}
