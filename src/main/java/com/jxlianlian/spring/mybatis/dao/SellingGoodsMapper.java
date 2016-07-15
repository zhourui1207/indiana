package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.SellingGoods;

public interface SellingGoodsMapper {
  int deleteByPrimaryKey(Long sellingGoodsId);

  int insert(SellingGoods record);

  int insertSelective(SellingGoods record);

  SellingGoods selectByPrimaryKey(Long sellingGoodsId);

  int updateByPrimaryKeySelective(SellingGoods record);

  int updateByPrimaryKey(SellingGoods record);
}