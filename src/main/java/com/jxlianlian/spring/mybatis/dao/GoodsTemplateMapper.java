package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.GoodsTemplate;

public interface GoodsTemplateMapper {
  int deleteByPrimaryKey(Long goodsTemplateId);

  int insert(GoodsTemplate record);

  int insertSelective(GoodsTemplate record);

  GoodsTemplate selectByPrimaryKey(Long goodsTemplateId);

  int updateByPrimaryKeySelective(GoodsTemplate record);

  int updateByPrimaryKey(GoodsTemplate record);
}