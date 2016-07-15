package com.jxlianlian.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxlianlian.spring.mybatis.dao.UserMapper;
import com.jxlianlian.spring.mybatis.model.User;

@Service("UserService")
public class UserService {
  private Logger logger = Logger.getLogger(UserService.class);
  @Autowired
  private UserMapper userDao;

  public User queryUserById(Long id) throws Exception {
    return userDao.selectByPrimaryKey(id);
  }

  public List<User> queryUserlist() throws Exception {
    return null;
  }

  public int addUser(User user) throws Exception {
    // mLogger.error("回滚吧！！");
    return userDao.insert(user);
  }
}
