package com.jxlianlian.spring.rest.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.rest.filter.Authorization;
import com.jxlianlian.spring.rest.filter.MustHttps;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.rest.security.AuthorizationSecurityContext;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.context.SpringContext;
import com.jxlianlian.spring.manager.SmsManager;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.JsonUtil;
import com.jxlianlian.util.RegexUtil;
import com.jxlianlian.util.ResponseUtil;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import java.util.List;
import java.util.Random;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

@Controller
@Path(Const.API_VERSION + "users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersApi {
  private Logger logger = Logger.getLogger(UsersApi.class);

  @Autowired
  private UserService userService;

  @Autowired
  private SmsManager smsManager;

  @Context
  private HttpServletRequest request;

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

  // 注册用户
  @POST
  @Path("/")
  // @MustHttps
  public Response addUser(@FormParam(Const.P_USER_ACCOUNT) String userAccount,
      @FormParam(Const.P_USER_PASSWORD) String userPassword, @FormParam(Const.P_JCAPTCHA) String jcaptcha) {

    logger
        .info("addUser(userAccount=" + userAccount + ", userPassword=" + userPassword + ", jcaptcha=" + jcaptcha + ")");

    if (jcaptcha == null || jcaptcha.length() == 0 || userAccount == null || userPassword == null
        || userAccount.length() == 0 || userPassword.length() == 0) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }
    
    // 验证图形验证码
    boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, jcaptcha);
    if (!captchaPassed) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.VERITY_CODE_INCORRECT);
    }

    if (!RegexUtil.isPhoneNo(userAccount)) { // 不是手机号码
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.PHONE_INCORRECT);
    }

    if (!RegexUtil.isCorrectPassword(userPassword)) { // 不是正确的密码
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.PWD_INCORRECT);
    }

    User user = null;
    try {
      user = userService.queryUserByUserAccount(userAccount);
    } catch (Exception e) {
      logger.error("用户注册时，查询数据库异常，用户账号[" + userAccount + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }

    if (user != null) { // 用户已存在
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.USER_EXISTED);
    }

    user = new User();
    user.initByUserAccount(userAccount, userPassword, Const.WAY_PHONE);
    // todo:调用短信验证接口，将号码跟用户数据放在一个MAP里，定时清除，当用户发送验证码时，验证通过后再进行真正的新增用户
    if (!smsManager.sendSmsVerityCodeAndSaveUserInfo(user)) { // 条用短信平台接口失败
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.SERVER_ERROR);
    }

    return ResponseUtil.ResOk(null);
  }

  @GET
  @Path("/{userId}")
  public Response getUserByUserId(@PathParam("userId") Long userId) {
    logger.info("getUserByUserId(userId=" + userId + ", context=" + request.getAttribute(Const.CURRENT_USER_ID) + ")");

    User user = queryUserByUserId(userId);
    if (user == null) { // 该用户资源不存在
      return Response.status(StatusCode.NOT_FOUND)
          .entity(ErrorInfo.messagge(StatusCode.NOT_FOUND, ErrorInfo.USER_NO_EXISTED)).build();
    }

    return Response.status(StatusCode.OK).entity(JsonUtil.toJSon(user)).build();
  }

  @GET
  @Path("/")
  public Response getUserByParam(@QueryParam("userId") Long userId, @QueryParam("masterUserId") Long masterUserId,
      @QueryParam("currentUserId") Long currentUserId) {

    logger.info("getUserByParam(userId=" + userId + ", masterUserId=" + masterUserId + ", currentUserId="
        + currentUserId + ", context=" + request.getAttribute(Const.CURRENT_USER_ID) + ")");

    User user;
    if (userId != null) {
      user = queryUserByUserId(userId);
    } else if (masterUserId != null) {

    }

    return Response.status(200).entity(JsonUtil.toJSon("haha")).build();
  }

  // 更新用户
  @PUT
  @Path("/users/{isbn}")
  public void addBook(@PathParam("isbn") String id, @QueryParam("name") String name) {
    logger.info("addBook");
  }

  // 删除用户
  // @DELETE
  // @Path("/users/{id}")
  public void removeUser(@PathParam("id") String userId) {

  }

}
