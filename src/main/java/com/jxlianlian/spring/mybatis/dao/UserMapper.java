package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.User;

public interface UserMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Long userId);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}