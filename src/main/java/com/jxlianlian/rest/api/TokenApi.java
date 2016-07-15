package com.jxlianlian.rest.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.jxlianlian.common.Const;

@Path("/" + Const.API_VERSION + "/token")
public class TokenApi {
  private static Logger logger = Logger.getLogger(TokenApi.class);
  
  //登录
  @POST
  @Path("/")
  public Response postToken() {
    return null;
  }
  
  //注销
  @DELETE
  @Path("/")
  public Response deleteToken() {
    return null;
  }
  
}
