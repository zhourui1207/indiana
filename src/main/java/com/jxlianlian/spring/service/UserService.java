package com.jxlianlian.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.dao.UserMapper;
import com.jxlianlian.spring.mybatis.model.User;

@Service("UserService")
public class UserService {
  private Logger logger = Logger.getLogger(UserService.class);
  @Autowired
  private UserMapper userDao;

  public User queryUserByUserId(Long userId) throws Exception {
    return userDao.selectByUserId(userId);
  }
  
  public User queryUserByUserIdSelf(Long userId) throws Exception {
    return userDao.selectByUserIdSelf(userId);
  }
  
  public User queryUserByUserAccountToLogin(String userAccount) throws Exception {
    return userDao.selectByUserAccountToLogin(userAccount);
  }

  // 通过账号名查找用户，只返回简单的信息
  public User queryUserByUserAccount(String userAccount) throws Exception {
    return userDao.selectByUserAccount(userAccount);
  }
  
  public User queryUserByWxId(String wxId) throws Exception {
    return userDao.selectByWxId(wxId);
  }
  
  public User queryUserByQqId(String qqId) throws Exception {
    return userDao.selectByQqId(qqId);
  }
  
  public User queryUserByUserName(String userName) throws Exception {
    return userDao.selectByUserName(userName);
  }
  
  public List<User> queryUserByMasterUserId(Long masterUserId) throws Exception {
    return userDao.selectByMasterUserId(masterUserId);
  }

  // 新增用户用户账号
  public int addUserByUserAccount(User user) throws Exception {
    // 查询用户是否存在
    User u = userDao.selectByUserAccount(user.getUserAccount());
    if (u == null) {  // 不在存在用户才能新增
      return userDao.insertSelective(user);
    }
    return 0;
  }
  
  public int addUser(User user) throws Exception {
    return userDao.insertSelective(user);
  }
}
