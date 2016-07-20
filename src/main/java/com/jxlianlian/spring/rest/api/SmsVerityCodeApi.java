package com.jxlianlian.spring.rest.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jxlianlian.common.CacheData;
import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.ResponseUtil;

@Controller
@Path(Const.API_VERSION + "smsVerityCode")
@Produces(MediaType.APPLICATION_JSON)
public class SmsVerityCodeApi {
  private Logger logger = Logger.getLogger(SmsVerityCodeApi.class);
  
  @Autowired
  private UserService userService;

  @POST
  @Path("/")
  public Response checkSmsVerityCode(@FormParam(Const.P_USER_ACCOUNT) String userAccount,
      @FormParam(Const.P_SMS_VERITY_CODE) Integer smsVerityCode) {

    logger.info("checkSmsVerityCode(userAccount=" + userAccount + ", smsVerityCode=" + smsVerityCode + ")");

    if (userAccount == null || smsVerityCode == null || userAccount.length() == 0 || smsVerityCode < 1000
        || smsVerityCode > 9999) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }
    
    // 去缓存里查找
    User user = CacheData.checkSmsVerityCode(userAccount, smsVerityCode);
    
    if (user == null) {  // 如果验证失败
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }
    
    //验证成功新增用户
    int addCount = 0;
    try {
      addCount = userService.addUserByUserAccount(user);
    } catch (Exception e) {
      logger.error("创建用户失败，数据库异常，用户信息" + user.toString(), e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    
    if (addCount != 1) {  //用户已存在
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.USER_EXISTED);
    }

    return ResponseUtil.ResOk(null);
  }
}
