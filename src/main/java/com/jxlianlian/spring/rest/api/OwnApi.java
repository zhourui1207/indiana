package com.jxlianlian.spring.rest.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.rest.filter.Authorization;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.JsonUtil;
import com.jxlianlian.util.ResponseUtil;

/**
 * 自己的一些信息，都通过该接口，从这个接口获取的信息都需要token来验证用户
 * @author zhourui
 *
 */

@Controller
@Path(Const.API_VERSION + "own")
@Produces(MediaType.APPLICATION_JSON)
@Authorization
public class OwnApi {
  private Logger logger = Logger.getLogger(OwnApi.class);
  
  @Autowired
  private UserService userService;
  
  @Context
  private HttpServletRequest request;
  
  // 获取自己的用户信息
  @GET
  @Path("/userInfo")
  public Response userInfo() {
    long currentUserId = (long) request.getAttribute(Const.CURRENT_USER_ID);
    logger.info("userInfo(" + currentUserId + ")");
    
    if (currentUserId == 0) {
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED);
    }
    
    User user = null; 
    try {
      user = userService.queryUserByUserIdSelf(currentUserId);
    } catch (Exception e) {
      logger.error("查询用户失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    
    if (user == null) {
      logger.info("用户不存在，用户ID[" + currentUserId + "]");
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.USER_NO_EXISTED);
    }
    
    return ResponseUtil.ResOk(JsonUtil.toJSon(user));
  }
}
