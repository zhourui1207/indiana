package com.jxlianlian.spring.mybatis.dao;

import com.jxlianlian.spring.mybatis.model.ShippingAddress;

public interface ShippingAddressMapper {
  int deleteByPrimaryKey(Long shippingAddressId);

  int insert(ShippingAddress record);

  int insertSelective(ShippingAddress record);

  ShippingAddress selectByPrimaryKey(Long shippingAddressId);

  int updateByPrimaryKeySelective(ShippingAddress record);

  int updateByPrimaryKey(ShippingAddress record);
}