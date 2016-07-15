package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class PublishRecord implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 3387378030440791075L;

  private Long publishRecordId;

  private Long goodsId;

  private Long goodsTemplateId;

  private Long period;

  private String goodsName;

  private String littlePic;

  private Date insertTime;

  private Date expectPublishTime;

  private Long userId;

  private String userName;

  private String location;

  private String head;

  private Long total;

  private String buyCount;

  private String luckyNumber;

  private Date publishTime;

  private Date luckyTime;

  private Integer calculationDetailId;

  private Long publishRecordDetailId;

  public Long getPublishRecordId() {
    return publishRecordId;
  }

  public void setPublishRecordId(Long publishRecordId) {
    this.publishRecordId = publishRecordId;
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

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public Date getExpectPublishTime() {
    return expectPublishTime;
  }

  public void setExpectPublishTime(Date expectPublishTime) {
    this.expectPublishTime = expectPublishTime;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location == null ? null : location.trim();
  }

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head == null ? null : head.trim();
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public String getBuyCount() {
    return buyCount;
  }

  public void setBuyCount(String buyCount) {
    this.buyCount = buyCount == null ? null : buyCount.trim();
  }

  public String getLuckyNumber() {
    return luckyNumber;
  }

  public void setLuckyNumber(String luckyNumber) {
    this.luckyNumber = luckyNumber == null ? null : luckyNumber.trim();
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  public Date getLuckyTime() {
    return luckyTime;
  }

  public void setLuckyTime(Date luckyTime) {
    this.luckyTime = luckyTime;
  }

  public Integer getCalculationDetailId() {
    return calculationDetailId;
  }

  public void setCalculationDetailId(Integer calculationDetailId) {
    this.calculationDetailId = calculationDetailId;
  }

  public Long getPublishRecordDetailId() {
    return publishRecordDetailId;
  }

  public void setPublishRecordDetailId(Long publishRecordDetailId) {
    this.publishRecordDetailId = publishRecordDetailId;
  }

  @Override
  public String toString() {
    return "PublishRecord [publishRecordId=" + publishRecordId + ", goodsId=" + goodsId + ", goodsTemplateId="
        + goodsTemplateId + ", period=" + period + ", goodsName=" + goodsName + ", littlePic=" + littlePic
        + ", insertTime=" + insertTime + ", expectPublishTime=" + expectPublishTime + ", userId=" + userId
        + ", userName=" + userName + ", location=" + location + ", head=" + head + ", total=" + total + ", buyCount="
        + buyCount + ", luckyNumber=" + luckyNumber + ", publishTime=" + publishTime + ", luckyTime=" + luckyTime
        + ", calculationDetailId=" + calculationDetailId + ", publishRecordDetailId=" + publishRecordDetailId + "]";
  }
}