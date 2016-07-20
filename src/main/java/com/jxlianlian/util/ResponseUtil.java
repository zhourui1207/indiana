package com.jxlianlian.util;

import javax.ws.rs.core.Response;

import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;

public class ResponseUtil {
  
  public static Response ResError(int statusCode, String message) {
    return Response.status(statusCode)
        .entity(ErrorInfo.messagge(statusCode, message)).build();
  }
  
  public static Response ResOk(String json) {
    return Response.status(StatusCode.OK)
        .entity(json).build();
  }
}
