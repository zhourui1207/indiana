package com.jxlianlian.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.dao.MoneyDetailMapper;
import com.jxlianlian.spring.mybatis.model.MoneyDetail;

@Service
public class MoneyDetailService {
  
  private Logger logger = Logger.getLogger(MoneyDetailService.class);
  
  @Autowired
  private MoneyDetailMapper moneyDetailDao;
  
  public List<MoneyDetail> queryMoneyDetailByPage(Long userId, Integer pageNo, Integer pageSize) throws Exception {
    pageNo = pageNo == null ? 1 : pageNo;
    pageSize = pageSize == null ? Const.PAG_SIZE_DEFAULE_PHONE: pageSize;
    PageHelper.startPage(pageNo, pageSize);
    return moneyDetailDao.selectByUserId(userId);
  }
}
