package com.jxlianlian.spring.rest.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.rest.filter.MustHttps;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.rest.token.manager.TokenManager;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.ResponseUtil;

@Controller
@Path("/" + Const.API_VERSION + "/token")
@Produces(MediaType.APPLICATION_JSON)
public class TokenApi {
  private Logger logger = Logger.getLogger(TokenApi.class);

  @Autowired
  private UserService userService;

  // 登录
  @POST
  @Path("/")
  //@MustHttps  // 调试时关闭
  public Response postToken(@FormParam(Const.USER_ACCOUNT) String userAccount,
      @FormParam(Const.USER_PASSWORD) String userPassword,
      @FormParam(Const.IS_PHONE) @DefaultValue("false") boolean isPhone) {

    logger
        .info("postToken(userAccount=" + userAccount + ", userPassword=" + userPassword + ", isPhone=" + isPhone + ")");

    // 判断是否是null或空字符串
    if (userAccount == null || userPassword == null || userAccount.length() == 0 || userPassword.length() == 0) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }
    
    User user = null;
    try {
      user = userService.queryUserByUserAccountToLogin(userAccount);
    } catch (Exception e) {
      logger.error("查询用户失败，用户ID[" + userAccount + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    if (user == null || !DigestUtils.md5Hex(userPassword).equals(user.getUserPassword())) { // 用户不存在或者密码错误
      logger.info("用户为空或密码不匹配，用户ID[" + userAccount + "]");
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.USERNAME_OR_PASSWORD_INCORRECT);
    }
    if (user.getCloseDown() == 1) {  // 用户被禁用
      logger.info("用户已被禁用，用户ID[" + userAccount + "]");
      return ResponseUtil.ResError(StatusCode.FORBIDDEN, ErrorInfo.USER_CLOSE_DOWN);
    }
    // 验证用户通过
    long userId = user.getUserId();
    int userType = user.getUserType();
    String tokenStr = TokenManager.createToken(userId, userType, isPhone);
    return ResponseUtil.ResOk("{" + Const.TOKEN_HEADER + ":" + tokenStr + "}");
  }

  // 注销
  // todo:暂时不提供该方法，因为本地并没有存放token的信息
  //@DELETE
  //@Path("/")
  public Response deleteToken() {
    return null;
  }

}
