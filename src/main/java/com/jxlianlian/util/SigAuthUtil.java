package com.jxlianlian.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cf.model.v20151127.AuthenticateRequest;
import com.aliyuncs.cf.model.v20151127.AuthenticateResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.X509TrustAll;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jxlianlian.common.Const;

public class SigAuthUtil {
  private static Logger logger = Logger.getLogger(SigAuthUtil.class);

  static int NOPASS = 900;
  static int SERVERERROR = 200;
  static int PASS = 100;
  static int MASK = 100;

  /**
   * 风险拦截之校验签名串
   * 
   * @param token
   *          由前端获取的参数
   * @param sessionId
   *          由前端获取的参数
   * @param sig
   *          由前端获取的参数
   * @param remoteIp
   *          浏览器端IP
   * @param sceneId
   *          场景(register,login等),保留参数
   * @return 是否校验成功
   * @throws Exception
   */
  public static boolean doAuthenticateRequest(HttpServletRequest request) throws Exception {
    // 如果是风险拦截之校验签名串
    String token = request.getParameter(Const.ALIYUN_TOKEN); // 从前端获取后传入
    String sessionId = request.getParameter(Const.ALIYUN_SESSIONID); // 从前端获取后传入
    String sig = request.getParameter(Const.ALIYUN_SIG); // 从前端获取后传入
    String sceneId = request.getParameter(Const.ALIYUN_SCENE); // 从前端获取后传入
    String remoteIp = IpUtil.getIpAddr(request);
    
    logger.info("doAuthenticateRequest(token=" + token + ", sessionId=" + sessionId + ", sig=" + sig + ", remoteIp="
        + remoteIp + ", sceneId=" + sceneId + ")");

    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", Const.ALIYUN_ACCESS_KEY_ID,
        Const.ALIYUN_ACCESS_KEY_SECRET);
    IAcsClient client = new DefaultAcsClient(profile);
    AuthenticateRequest authenticateRequest = new AuthenticateRequest();
    authenticateRequest.setAppKey(Const.ALIYUN_APP_KEY);
    authenticateRequest.setSerno(getSerno(Const.ALIYUN_APP_KEY, Const.ALIYUN_APP_ACCESS_KEY, token, sig));
    authenticateRequest.setRemoteIp(remoteIp);
    authenticateRequest.setSessionId(sessionId);
    authenticateRequest.setToken(token);
    authenticateRequest.setSig(sig);
    authenticateRequest.setSceneId(sceneId);

    X509TrustAll.ignoreSSLCertificate();
    try {
      AuthenticateResponse httpResponse = client.getAcsResponse(authenticateRequest);
      int authRetCode = httpResponse.getSigAuthenticateResult().getCode();
      logger.info("调用用阿里滑动验证接口，code=" + authRetCode + ", msg=" + httpResponse.getSigAuthenticateResult().getMsg());
      boolean isPass = codeCheck(authRetCode);

      return isPass;
    } catch (ClientException e) {
      logger.error("调用阿里滑动验证接口，抛出客户端异常！", e);
      return false;
    } catch (Exception e) {
      // 建议做为成功处理,记录日志
      logger.error("调用阿里滑动验证接口，抛出未知异常！", e);
      throw new Exception(e.getMessage());
    }
  }

  /**
   * NC 验签code check
   * 
   * @param retcode
   * @return 返回NC服务提供方是否通过的建议值:true表示建议通过, false表示不建议通过.
   */
  private static boolean codeCheck(int retcode) {
    boolean ret = false;
    if (!(retcode / MASK == NOPASS / MASK)) {
      ret = true;
    }
    return ret;
  }

  /**
   * 生成serno的类
   * 
   * @param appKey
   * @param accessKey
   * @param token
   * @param sig
   * @return
   */
  private static String getSerno(String appKey, String accessKey, String token, String sig) {
    String serialNo = getMD5Hex(appKey + accessKey + token + sig);
    return serialNo;
  }

  /**
   * @param str
   * @return
   */
  private static String getMD5Hex(String str) {
    MessageDigest md = null;
    StringBuffer sb = new StringBuffer();
    byte[] tmpByte = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      logger.info("NoSuchAlgorithmException" + e);
    }
    md.update(str.getBytes());
    tmpByte = md.digest();
    for (int i = 0; i < tmpByte.length; ++i) {
      if ((tmpByte[i] & 0xFF) < 16) {
        sb.append("0");
      }
      sb.append(Long.toString(tmpByte[i] & 0xFF, 16));
    }
    return sb.toString();
  }
}
