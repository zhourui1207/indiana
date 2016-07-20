package com.jxlianlian.spring.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jxlianlian.common.CacheData;
import com.jxlianlian.common.Const;

@Component
public class ClearSmsVerityCodeTask {
  private Logger logger = Logger.getLogger(ClearSmsVerityCodeTask.class);
  
  @Scheduled(cron=Const.TASK_CLENR_SMS_VERITY_CODE)
  public void timer() {   
    logger.info("定时清除短信验证码过期数据");
    CacheData.clearSmsVerityCode();
  }
  
}
