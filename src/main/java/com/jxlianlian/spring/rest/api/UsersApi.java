package com.jxlianlian.spring.rest.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jxlianlian.common.CacheData;
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
import com.jxlianlian.util.IpUtil;
import com.jxlianlian.util.JsonUtil;
import com.jxlianlian.util.RegexUtil;
import com.jxlianlian.util.ResponseUtil;
import com.jxlianlian.util.SigAuthUtil;
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

  // 注册用户
  @POST
  @Path("/")
  // @MustHttps
  public Response registUser(@FormParam(Const.P_USER_ACCOUNT) String userAccount,
      @FormParam(Const.P_USER_PASSWORD) String userPassword, @FormParam(Const.P_JCAPTCHA) String jcaptcha) {

    logger
        .info("registUser(userAccount=" + userAccount + ", userPassword=" + userPassword + ", jcaptcha=" + jcaptcha + ")");

    if (userAccount == null || userPassword == null || userAccount.length() == 0 || userPassword.length() == 0) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }

    boolean isPass = false;

    if (CacheData.useAliVerityCode()) { // 是否使用阿里滑动验证码
      try {
        isPass = SigAuthUtil.doAuthenticateRequest(request);
      } catch (Exception e) {
        // 如果出现Exception ,建议结果为通过.
        CacheData.closeDownAliVerityCode();  // 异常有可能是每天的免费数量超过上限，禁用阿里验证接口，使用普通验证
        isPass = true;
      }
      if (!isPass) {
        return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.VERITY_CODE_INCORRECT);
      }

    } else {
      // 使用jcaptcha图形验证码
      if (jcaptcha == null || jcaptcha.length() == 0) {
        return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
      }

      isPass = SimpleImageCaptchaServlet.validateResponse(request, jcaptcha);
      if (!isPass) {
        return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.VERITY_CODE_INCORRECT);
      }
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

    return ResponseUtil.ResCreateOk(null);
  }

  // 查询某一个用户简单信息
  @GET
  @Path("/{userId}")
  public Response getUserSimpleInfoByUserId(@PathParam("userId") Long userId) {
    logger.info("getUserSimpleInfoByUserId(userId=" + userId + ")");

    User user = null;
    try {
      user = userService.queryUserByUserId(userId);
    } catch (Exception e) {
      logger.error("查询用户时，查询数据库异常，用户ID[" + userId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    
    if (user == null) {  // 该用户资源不存在
      return Response.status(StatusCode.NOT_FOUND)
          .entity(ErrorInfo.messagge(StatusCode.NOT_FOUND, ErrorInfo.USER_NO_EXISTED)).build();
    }

    return ResponseUtil.ResGetOk(JsonUtil.toJSon(user));
  }

  // 查询用户列表，次功能暂不开放，管理员可能用到该功能
  // @GET
  // @Path("/")
  public Response getUserByParam(@QueryParam("userId") Long userId, @QueryParam("masterUserId") Long masterUserId,
      @QueryParam("pageIndex") Integer pageIndex, @QueryParam("pageSize") Integer pageSize) {
    return null;
  }

  // 更新用户 管理员可以用此接口禁用用户
  // @PUT
  // @Path("/{userId}")
  public Response updateUser(@PathParam("userId") String id, @QueryParam("closeDown") boolean closeDown) {
    return null;
  }

  // 删除用户 管理员才能做这个
  // @DELETE
  // @Path("/{userId}")
  public Response removeUser(@PathParam("userId") String userId) {
      return null;
  }

}
