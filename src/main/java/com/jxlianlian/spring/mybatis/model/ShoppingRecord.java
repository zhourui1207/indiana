package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class ShoppingRecord implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 5213564041958423333L;

  private Long shoppingRecordId;

  private Long userId;

  private String userName;

  private String head;

  private String location;

  private String ipAddress;

  private Long buyCount;

  private Date insertTime;

  private Long goodsId;

  private Long goodsTemplateId;

  private Long period;

  private String goodsName;

  private String littlePic;

  public Long getShoppingRecordId() {
    return shoppingRecordId;
  }

  public void setShoppingRecordId(Long shoppingRecordId) {
    this.shoppingRecordId = shoppingRecordId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head == null ? null : head.trim();
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location == null ? null : location.trim();
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress == null ? null : ipAddress.trim();
  }

  public Long getBuyCount() {
    return buyCount;
  }

  public void setBuyCount(Long buyCount) {
    this.buyCount = buyCount;
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Long getGoodsTemplateId() {
    return goodsTemplateId;
  }

  public void setGoodsTemplateId(Long goodsTemplateId) {
    this.goodsTemplateId = goodsTemplateId;
  }

  public Long getPeriod() {
    return period;
  }

  public void setPeriod(Long period) {
    this.period = period;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName == null ? null : goodsName.trim();
  }

  public String getLittlePic() {
    return littlePic;
  }

  public void setLittlePic(String littlePic) {
    this.littlePic = littlePic == null ? null : littlePic.trim();
  }

  @Override
  public String toString() {
    return "ShoppingRecord [shoppingRecordId=" + shoppingRecordId + ", userId=" + userId + ", userName=" + userName
        + ", head=" + head + ", location=" + location + ", ipAddress=" + ipAddress + ", buyCount=" + buyCount
        + ", insertTime=" + insertTime + ", goodsId=" + goodsId + ", goodsTemplateId=" + goodsTemplateId + ", period="
        + period + ", goodsName=" + goodsName + ", littlePic=" + littlePic + "]";
  }
}