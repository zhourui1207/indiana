package com.jxlianlian.spring.rest.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;

@Component // 注入spring
@Provider // 被jax-rs搜索到
@Priority(Priorities.AUTHORIZATION) // 认证级别
@MustHttps
public class HttpsFilter implements ContainerRequestFilter {
  private Logger logger = Logger.getLogger(HttpsFilter.class);
  
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    logger.info("filter");
    if (!requestContext.getUriInfo().getRequestUri().toString().startsWith("https:")) {  // 使用的不是https协议
      requestContext.abortWith(Response.status(StatusCode.FORBIDDEN)
          .entity(ErrorInfo.messagge(StatusCode.FORBIDDEN, ErrorInfo.NO_AUTHORIZED)).build()); // 未认证
    }
  }

}
