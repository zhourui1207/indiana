package com.jxlianlian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxlianlian.spring.mybatis.dao.ShippingAddressMapper;
import com.jxlianlian.spring.mybatis.model.ShippingAddress;

@Service
public class ShippingAddressService {

  @Autowired
  private ShippingAddressMapper shippingAddressDao;
  
  public int queryShippingAddressCountByUserId(Long userId) throws Exception {
    return shippingAddressDao.selectCountByUserId(userId);
  }
  
  public ShippingAddress queryShippingAddressById(Long id) throws Exception {
    return shippingAddressDao.selectByPrimaryKey(id);
  }
  
  public List<ShippingAddress> queryShippingAddressByUserId(Long userId) throws Exception {
    return shippingAddressDao.selectByUserId(userId);
  }
  
  public int addShippingAddress(ShippingAddress record) throws Exception {
    return shippingAddressDao.insertSelective(record);
  }
  
  public int modifyShippingAddress(ShippingAddress record) throws Exception {
    return shippingAddressDao.updateByPrimaryKeySelective(record);
  }
  
  public int deleteShippingAddress(Long id) throws Exception {
    return shippingAddressDao.deleteByPrimaryKey(id);
  }
  
 }
