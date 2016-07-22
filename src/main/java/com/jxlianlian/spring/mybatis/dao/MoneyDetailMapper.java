package com.jxlianlian.spring.mybatis.dao;

import java.util.List;

import com.jxlianlian.spring.mybatis.model.MoneyDetail;

public interface MoneyDetailMapper {
  int deleteByPrimaryKey(Long moneyDetailId);

  int insert(MoneyDetail record);

  int insertSelective(MoneyDetail record);

  MoneyDetail selectByPrimaryKey(Long moneyDetailId);
  
  List<MoneyDetail> selectByUserId(Long userId);

  int updateByPrimaryKeySelective(MoneyDetail record);

  int updateByPrimaryKey(MoneyDetail record);
}