package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.PublishRecordDetail;

public interface PublishRecordDetailMapper {
  int deleteByPrimaryKey(Long publishRecordDetailId);

  int insert(PublishRecordDetail record);

  int insertSelective(PublishRecordDetail record);

  PublishRecordDetail selectByPrimaryKey(Long publishRecordDetailId);

  int updateByPrimaryKeySelective(PublishRecordDetail record);

  int updateByPrimaryKey(PublishRecordDetail record);
}