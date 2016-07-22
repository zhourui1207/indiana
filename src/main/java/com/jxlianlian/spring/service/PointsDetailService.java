package com.jxlianlian.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.dao.PointsDetailMapper;
import com.jxlianlian.spring.mybatis.model.PointsDetail;

@Service
public class PointsDetailService {
  
  @Autowired
  private PointsDetailMapper pointsDetailDao;
  
  public List<PointsDetail> queryPointsDetailByPage(Long userId, Integer pageNo, Integer pageSize) throws Exception {
    pageNo = pageNo == null ? 1 : pageNo;
    pageSize = pageSize == null ? Const.PAG_SIZE_DEFAULE_PHONE: pageSize;
    PageHelper.startPage(pageNo, pageSize);
    return pointsDetailDao.selectByUserId(userId);
  }

}
