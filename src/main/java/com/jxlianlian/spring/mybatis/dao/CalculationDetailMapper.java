package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.CalculationDetail;

public interface CalculationDetailMapper {
  int deleteByPrimaryKey(Integer calculationDetailId);

  int insert(CalculationDetail record);

  int insertSelective(CalculationDetail record);

  CalculationDetail selectByPrimaryKey(Integer calculationDetailId);

  int updateByPrimaryKeySelective(CalculationDetail record);

  int updateByPrimaryKey(CalculationDetail record);
}