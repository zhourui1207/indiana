package com.jxlianlian.spring.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jxlianlian.common.CacheData;
import com.jxlianlian.common.Const;

@Component
public class RestAliVerityCodeTask {
  private Logger logger = Logger.getLogger(RestAliVerityCodeTask.class);
  
  @Scheduled(cron=Const.TASK_NEW_DAY_BEGIN)
  public void timer() {   
    logger.info("定时重置阿里图形验证接口流量");
    CacheData.resetAliVerityCode();
  }
}
