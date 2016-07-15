package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MoneyDetail implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -1743683438613954344L;

  private Long moneyDetailId;

  private Long userId;

  private Byte moneyType;

  private Byte way;

  private Date insertTime;

  private BigDecimal money;

  public Long getMoneyDetailId() {
    return moneyDetailId;
  }

  public void setMoneyDetailId(Long moneyDetailId) {
    this.moneyDetailId = moneyDetailId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Byte getMoneyType() {
    return moneyType;
  }

  public void setMoneyType(Byte moneyType) {
    this.moneyType = moneyType;
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

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "MoneyDetail [moneyDetailId=" + moneyDetailId + ", userId=" + userId + ", moneyType=" + moneyType + ", way="
        + way + ", insertTime=" + insertTime + ", money=" + money + "]";
  }
}