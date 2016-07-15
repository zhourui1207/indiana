package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class PointsDetail implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -4643385351522040603L;

  private Long pointsDetailId;

  private Long userId;

  private Byte pointsType;

  private Byte way;

  private Date insertTime;

  private Long points;

  public Long getPointsDetailId() {
    return pointsDetailId;
  }

  public void setPointsDetailId(Long pointsDetailId) {
    this.pointsDetailId = pointsDetailId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Byte getPointsType() {
    return pointsType;
  }

  public void setPointsType(Byte pointsType) {
    this.pointsType = pointsType;
  }

  public Byte getWay() {
    return way;
  }

  public void setWay(Byte way) {
    this.way = way;
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public Long getPoints() {
    return points;
  }

  public void setPoints(Long points) {
    this.points = points;
  }

  @Override
  public String toString() {
    return "PointsDetail [pointsDetailId=" + pointsDetailId + ", userId=" + userId + ", pointsType=" + pointsType
        + ", way=" + way + ", insertTime=" + insertTime + ", points=" + points + "]";
  }
}