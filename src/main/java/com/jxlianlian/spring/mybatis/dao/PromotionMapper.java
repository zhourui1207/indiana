package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.Promotion;

public interface PromotionMapper {
  int deleteByPrimaryKey(Long promotionId);

  int insert(Promotion record);

  int insertSelective(Promotion record);

  Promotion selectByPrimaryKey(Long promotionId);

  int updateByPrimaryKeySelective(Promotion record);

  int updateByPrimaryKey(Promotion record);
}