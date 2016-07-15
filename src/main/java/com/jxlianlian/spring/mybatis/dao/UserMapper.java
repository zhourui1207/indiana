package com.jxlianlian.spring.mybatis.dao;

import java.util.List;

import com.jxlianlian.spring.mybatis.model.User;

public interface UserMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(User record);

  int insertSelective(User record);

  User selectByUserId(Long userId);
  
  User selectByUserIdSelf(Long userId);
  
  User selectByUserAccount(String userAccount);
  
  User selectByWxId(String wxId);
  
  User selectByQqId(String qqId);
  
  User selectByUserName(String UserName);
  
  List<User> selectByMasterUserId(Long masterUserId);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}