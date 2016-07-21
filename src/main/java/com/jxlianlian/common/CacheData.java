package com.jxlianlian.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.jxlianlian.spring.mybatis.model.User;

public class CacheData {
  private static Logger logger = Logger.getLogger(CacheData.class);
  private static Map<String, User> users = new HashMap<>();
  private static Object usersMutex = new Object();
  
  // 调用阿里图片验证接口
  // 调用开关
  private static boolean useAliVerityCode = true;
  // 记录服务端验证调用次数
  private static int useAliVerityCodeCount = 0;
  
  public static void addSmsVerityCode(User user) {
    synchronized (usersMutex) {
      users.put(user.getUserAccount(), user);
    }
  }
  
  public static User checkSmsVerityCode(String userAccount, Integer verityCode) {
    synchronized (usersMutex) {
      User user = users.get(userAccount);
      if (user != null && user.getVerityCode().equals(verityCode)) {
        return users.remove(userAccount);
      }
    }
    return null;
  }
  
  public static void clearSmsVerityCode() {
    synchronized (usersMutex) {
      Iterator<Entry<String, User>> usersIterator = users.entrySet().iterator();
      long currentTime = System.currentTimeMillis();
      while (usersIterator.hasNext()) { 
        Entry<String, User> userEntry = usersIterator.next();  
        if (currentTime - userEntry.getValue().getSendVerityCodeTime() >= (Const.SMS_VERIFY_TIME * 60000)) {  // 超时了
          User user = users.remove(userEntry.getKey());
          logger.info("清除短信验证码过期数据，号码[" + user.getUserAccount() + "]，验证码[" + user.getVerityCode() + "]");
        }
      } 
    }
  }
  
  // 是否使用阿里验证码接口
  public static boolean useAliVerityCode() {
    if (useAliVerityCode) {
      ++useAliVerityCodeCount;
    }
    return useAliVerityCode;
  }
  
  // 禁用阿里验证码接口
  public static void closeDownAliVerityCode() {
    useAliVerityCode = false;
  }
  
  // 重置阿里验证码接口
  public static void resetAliVerityCode() {
    useAliVerityCode = true;
    logger.info("重置阿里图片验证接口，昨日服务端验证次数=" + useAliVerityCodeCount);
    useAliVerityCodeCount = 0;
  }
}
