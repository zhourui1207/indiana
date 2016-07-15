package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.PublishRecord;

public interface PublishRecordMapper {
  int deleteByPrimaryKey(Long publishRecordId);

  int insert(PublishRecord record);

  int insertSelective(PublishRecord record);

  PublishRecord selectByPrimaryKey(Long publishRecordId);

  int updateByPrimaryKeySelective(PublishRecord record);

  int updateByPrimaryKey(PublishRecord record);
}