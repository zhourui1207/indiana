package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.ShoppingRecord;

public interface ShoppingRecordMapper {
  int deleteByPrimaryKey(Long shoppingRecordId);

  int insert(ShoppingRecord record);

  int insertSelective(ShoppingRecord record);

  ShoppingRecord selectByPrimaryKey(Long shoppingRecordId);

  int updateByPrimaryKeySelective(ShoppingRecord record);

  int updateByPrimaryKey(ShoppingRecord record);
}