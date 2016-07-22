package com.jxlianlian.spring.mybatis.dao;

import java.util.List;

import com.jxlianlian.spring.mybatis.model.PointsDetail;

public interface PointsDetailMapper {
  int deleteByPrimaryKey(Long pointsDetailId);

  int insert(PointsDetail record);

  int insertSelective(PointsDetail record);

  PointsDetail selectByPrimaryKey(Long pointsDetailId);
  
  List<PointsDetail> selectByUserId(Long userId);

  int updateByPrimaryKeySelective(PointsDetail record);

  int updateByPrimaryKey(PointsDetail record);
}