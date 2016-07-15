package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.MoneyDetail;

public interface MoneyDetailMapper {
  int deleteByPrimaryKey(Long moneyDetailId);

  int insert(MoneyDetail record);

  int insertSelective(MoneyDetail record);

  MoneyDetail selectByPrimaryKey(Long moneyDetailId);

  int updateByPrimaryKeySelective(MoneyDetail record);

  int updateByPrimaryKey(MoneyDetail record);
}