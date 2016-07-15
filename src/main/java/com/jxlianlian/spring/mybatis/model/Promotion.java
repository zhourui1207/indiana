package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Promotion implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 2184750537065499017L;

  private Long promotionId;

  private String promotionName;

  private String promotionSrc;

  private Integer width;

  private Integer height;

  private Byte promotionType;

  private Date startTime;

  private Date endTime;

  private String promotionUrl;

  public Long getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(Long promotionId) {
    this.promotionId = promotionId;
  }

  public String getPromotionName() {
    return promotionName;
  }

  public void setPromotionName(String promotionName) {
    this.promotionName = promotionName == null ? null : promotionName.trim();
  }

  public String getPromotionSrc() {
    return promotionSrc;
  }

  public void setPromotionSrc(String promotionSrc) {
    this.promotionSrc = promotionSrc == null ? null : promotionSrc.trim();
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Byte getPromotionType() {
    return promotionType;
  }

  public void setPromotionType(Byte promotionType) {
    this.promotionType = promotionType;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getPromotionUrl() {
    return promotionUrl;
  }

  public void setPromotionUrl(String promotionUrl) {
    this.promotionUrl = promotionUrl == null ? null : promotionUrl.trim();
  }

  @Override
  public String toString() {
    return "Promotion [promotionId=" + promotionId + ", promotionName=" + promotionName + ", promotionSrc="
        + promotionSrc + ", width=" + width + ", height=" + height + ", promotionType=" + promotionType + ", startTime="
        + startTime + ", endTime=" + endTime + ", promotionUrl=" + promotionUrl + "]";
  }
}