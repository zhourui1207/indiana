package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class ShareRecord implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 3262213570131019188L;

  private Long shareRecordId;

  private Long userId;

  private String userName;

  private String head;

  private Long goodsId;

  private Long goodsTemplateId;

  private Long period;

  private String goodsName;

  private String title;

  private String content;

  private String picFirst;

  private String picSecond;

  private String picThird;

  private String picFourth;

  private String picFifth;

  private String picSixth;

  private String picSeventh;

  private String picEighth;

  private String picNinth;

  private String picTenth;

  private Date insertTime;

  public Long getShareRecordId() {
    return shareRecordId;
  }

  public void setShareRecordId(Long shareRecordId) {
    this.shareRecordId = shareRecordId;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public String getPicFirst() {
    return picFirst;
  }

  public void setPicFirst(String picFirst) {
    this.picFirst = picFirst == null ? null : picFirst.trim();
  }

  public String getPicSecond() {
    return picSecond;
  }

  public void setPicSecond(String picSecond) {
    this.picSecond = picSecond == null ? null : picSecond.trim();
  }

  public String getPicThird() {
    return picThird;
  }

  public void setPicThird(String picThird) {
    this.picThird = picThird == null ? null : picThird.trim();
  }

  public String getPicFourth() {
    return picFourth;
  }

  public void setPicFourth(String picFourth) {
    this.picFourth = picFourth == null ? null : picFourth.trim();
  }

  public String getPicFifth() {
    return picFifth;
  }

  public void setPicFifth(String picFifth) {
    this.picFifth = picFifth == null ? null : picFifth.trim();
  }

  public String getPicSixth() {
    return picSixth;
  }

  public void setPicSixth(String picSixth) {
    this.picSixth = picSixth == null ? null : picSixth.trim();
  }

  public String getPicSeventh() {
    return picSeventh;
  }

  public void setPicSeventh(String picSeventh) {
    this.picSeventh = picSeventh == null ? null : picSeventh.trim();
  }

  public String getPicEighth() {
    return picEighth;
  }

  public void setPicEighth(String picEighth) {
    this.picEighth = picEighth == null ? null : picEighth.trim();
  }

  public String getPicNinth() {
    return picNinth;
  }

  public void setPicNinth(String picNinth) {
    this.picNinth = picNinth == null ? null : picNinth.trim();
  }

  public String getPicTenth() {
    return picTenth;
  }

  public void setPicTenth(String picTenth) {
    this.picTenth = picTenth == null ? null : picTenth.trim();
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  @Override
  public String toString() {
    return "ShareRecord [shareRecordId=" + shareRecordId + ", userId=" + userId + ", userName=" + userName + ", head="
        + head + ", goodsId=" + goodsId + ", goodsTemplateId=" + goodsTemplateId + ", period=" + period + ", goodsName="
        + goodsName + ", title=" + title + ", content=" + content + ", picFirst=" + picFirst + ", picSecond="
        + picSecond + ", picThird=" + picThird + ", picFourth=" + picFourth + ", picFifth=" + picFifth + ", picSixth="
        + picSixth + ", picSeventh=" + picSeventh + ", picEighth=" + picEighth + ", picNinth=" + picNinth
        + ", picTenth=" + picTenth + ", insertTime=" + insertTime + "]";
  }
}