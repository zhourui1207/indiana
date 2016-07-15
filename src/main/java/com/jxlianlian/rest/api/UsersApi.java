package com.jxlianlian.rest.api;

import org.apache.log4j.Logger;

import com.jxlianlian.common.Const;
import com.jxlianlian.rest.message.ErrorInfo;
import com.jxlianlian.rest.message.StatusCode;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.context.SpringContext;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.JsonUtil;

import javax.ws.rs.core.Response;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

@Path("/" + Const.API_VERSION + "/users")
public class UsersApi {
  private Logger logger = Logger.getLogger(UsersApi.class);

  private UserService userService = SpringContext.getBean("UserService");
  
  private User queryUserByUserId(Long userId) {
    User user = null;
    try {
      user = userService.queryUserByUserId(userId);
    } catch (Exception e) {
      logger.error("queryUserByUserId failed! userId=" + userId, e);
    }
    return user;
  }
  
  private User queryUserByUserAccount(String userAccount) {
    User user = null;
    try {
      user = userService.queryUserByUserAccount(userAccount);
    } catch (Exception e) {
      logger.error("queryUserByUserAccount failed! userAccount=" + userAccount, e);
    }
    return user;
  }

  @GET
  @Path("/{userId}")
  public Response getUserByUserId(@PathParam("userId") Long userId) {
    logger.info("getUserByUserId(" + userId + ")");
   
    User user = queryUserByUserId(userId);
    if (user == null) { // 该用户资源不存在
      return Response.status(StatusCode.NOT_FOUND)
          .entity(ErrorInfo.messagge(StatusCode.NOT_FOUND, ErrorInfo.USER_NO_EXISTED)).build();
    }

    return Response.status(StatusCode.OK).entity(JsonUtil.toJSon(user)).build();
  }

  @GET
  @Path("/")
  public Response getUserByParam(@QueryParam("userId") Long userId, @QueryParam("masterUserId") Long masterUserId) {
    
    logger.info("getUserByParam(userId=" + userId + ", masterUserId=" + masterUserId + ")");
    
    User user;
    if (userId != null) {
      user = queryUserByUserId(userId);
    } else if (masterUserId != null) {
      
    }

    return Response.status(200).entity(JsonUtil.toJSon("haha")).build();
  }

  @PUT
  @Path("/users/{isbn}")
  public void addBook(@PathParam("isbn") String id, @QueryParam("name") String name) {
    logger.info("addBook");
  }

  @DELETE
  @Path("/users/{id}")
  public void removeBook(@PathParam("id") String id) {
    logger.info("getAllUsers");
  }

}
