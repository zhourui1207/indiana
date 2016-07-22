package com.jxlianlian.spring.mybatis.dao;

import java.util.List;

import com.jxlianlian.spring.mybatis.model.ShippingAddress;

public interface ShippingAddressMapper {
  int deleteByPrimaryKey(Long shippingAddressId);

  int insert(ShippingAddress record);

  int insertSelective(ShippingAddress record);

  int selectCountByUserId(Long userId);
  
  ShippingAddress selectByPrimaryKey(Long shippingAddressId);
  
  List<ShippingAddress> selectByUserId(Long userId);

  int updateByPrimaryKeySelective(ShippingAddress record);

  int updateByPrimaryKey(ShippingAddress record);
}