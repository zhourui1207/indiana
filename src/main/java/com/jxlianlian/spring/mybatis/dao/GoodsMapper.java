package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.Goods;

public interface GoodsMapper {
  int deleteByPrimaryKey(Long goodsId);

  int insert(Goods record);

  int insertSelective(Goods record);

  Goods selectByPrimaryKey(Long goodsId);

  int updateByPrimaryKeySelective(Goods record);

  int updateByPrimaryKey(Goods record);
}