package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.ShareRecord;

public interface ShareRecordMapper {
  int deleteByPrimaryKey(Long shareRecordId);

  int insert(ShareRecord record);

  int insertSelective(ShareRecord record);

  ShareRecord selectByPrimaryKey(Long shareRecordId);

  int updateByPrimaryKeySelective(ShareRecord record);

  int updateByPrimaryKey(ShareRecord record);
}