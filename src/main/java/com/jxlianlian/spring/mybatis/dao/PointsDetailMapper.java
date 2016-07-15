package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.PointsDetail;

public interface PointsDetailMapper {
  int deleteByPrimaryKey(Long pointsDetailId);

  int insert(PointsDetail record);

  int insertSelective(PointsDetail record);

  PointsDetail selectByPrimaryKey(Long pointsDetailId);

  int updateByPrimaryKeySelective(PointsDetail record);

  int updateByPrimaryKey(PointsDetail record);
}