package com.jxlianlian.spring.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jxlianlian.common.CacheData;
import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.User;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 短信管理类
 * 
 * @author zhourui
 *
 */

@Service
public class SmsManager {
  private Logger logger = Logger.getLogger(SmsManager.class);

  private TaobaoClient client = new DefaultTaobaoClient(Const.SMS_URL, Const.SMS_APP_KEY, Const.SMS_SECRET);

  public boolean sendSmsVerityCodeAndSaveUserInfo(User user) {
    // 生成一个4位数的验证码
    Random random = new Random();
    int code = random.nextInt(9000) + 1000;
    String phoneNo = user.getUserAccount();
    logger.info("发送短信验证码，接收号码[" + phoneNo + "]，验证码[" + code + "]");

    // todo: 调用短信平台接口
    if ((!Const.IS_TEST) && (!sendSmsVerityCode(phoneNo, code))) { // 如果调用失败返回错误
      return false;
    }

    // 调用成功，保存起来
    user.setVerityCode(code);
    user.setSendVerityCodeTime(System.currentTimeMillis());
    CacheData.addSmsVerityCode(user);

    return true;
  }

  private boolean sendSmsVerityCode(String phoneNo, Integer code) {
    return sendSms(phoneNo, Const.SMS_TEMPLATE_CODE_VERIFY, "{\"code\":\"" + code + "\",\"product\":\""
        + Const.SMS_PRODUCT + "\",\"time\":\"" + Const.SMS_VERIFY_TIME + "\"}");
  }

  public boolean sendSmsNotify(String phoneNo) {
    return sendSms(phoneNo, Const.SMS_TEMPLATE_CODE_NOTIFY, "");
  }

  private boolean sendSms(String phoneNo, String smsTemplate, String smsParam) {
    AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
    req.setExtend(phoneNo);
    req.setSmsType(Const.SMS_TYPE);
    req.setSmsFreeSignName(Const.SMS_SIGN_NAME);
    req.setRecNum(phoneNo);
    req.setSmsTemplateCode(smsTemplate);
    req.setSmsParamString(smsParam);

    AlibabaAliqinFcSmsNumSendResponse rsp;
    try {
      rsp = client.execute(req);
    } catch (ApiException e) {
      logger.error("短信平台接口调用失败！接收号码[" + phoneNo + "]", e);
      return false;
    }
    logger.info(rsp.getBody());
    
    if (!rsp.getErrorCode().equalsIgnoreCase("0")) {
      logger.error("短信发送失败，接收号码[" + phoneNo + "]，错误码[" + rsp.getErrorCode() + "]");
      return false;
    }
    return true;
  }
}
