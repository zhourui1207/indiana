package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6071871471032791294L;

  private Long userId;

  private String userAccount;

  private String wxId;

  private String qqId;

  private Long masterUserId;

  private Byte userType;

  private String userPassword;

  private String email;

  private Byte way;

  private Date insertTime;

  private Date updateTime;

  private BigDecimal balance;

  private Long points;

  private String qq;

  private Long defaultShippingAddressId;

  private String userName;

  private String head;

  private Byte gender;

  private Date birthday;

  private String currentLocation;

  private String homeTown;

  private Long exp;

  private String signature;
  
  private Byte closeDown;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(String userAccount) {
    this.userAccount = userAccount == null ? null : userAccount.trim();
  }

  public String getWxId() {
    return wxId;
  }

  public void setWxId(String wxId) {
    this.wxId = wxId == null ? null : wxId.trim();
  }

  public String getQqId() {
    return qqId;
  }

  public void setQqId(String qqId) {
    this.qqId = qqId == null ? null : qqId.trim();
  }

  public Long getMasterUserId() {
    return masterUserId;
  }

  public void setMasterUserId(Long masterUserId) {
    this.masterUserId = masterUserId;
  }

  public Byte getUserType() {
    return userType;
  }

  public void setUserType(Byte userType) {
    this.userType = userType;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword == null ? null : userPassword.trim();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
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

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public Long getPoints() {
    return points;
  }

  public void setPoints(Long points) {
    this.points = points;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq == null ? null : qq.trim();
  }

  public Long getDefaultShippingAddressId() {
    return defaultShippingAddressId;
  }

  public void setDefaultShippingAddressId(Long defaultShippingAddressId) {
    this.defaultShippingAddressId = defaultShippingAddressId;
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

  public Byte getGender() {
    return gender;
  }

  public void setGender(Byte gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation == null ? null : currentLocation.trim();
  }

  public String getHomeTown() {
    return homeTown;
  }

  public void setHomeTown(String homeTown) {
    this.homeTown = homeTown == null ? null : homeTown.trim();
  }

  public Long getExp() {
    return exp;
  }

  public void setExp(Long exp) {
    this.exp = exp;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature == null ? null : signature.trim();
  }

  public Byte getCloseDown() {
    return closeDown;
  }

  public void setCloseDown(Byte closeDown) {
    this.closeDown = closeDown;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", userAccount=" + userAccount + ", wxId=" + wxId + ", qqId=" + qqId
        + ", masterUserId=" + masterUserId + ", userType=" + userType + ", userPassword=" + userPassword + ", email="
        + email + ", way=" + way + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", balance=" + balance
        + ", points=" + points + ", qq=" + qq + ", defaultShippingAddressId=" + defaultShippingAddressId + ", userName="
        + userName + ", head=" + head + ", gender=" + gender + ", birthday=" + birthday + ", currentLocation="
        + currentLocation + ", homeTown=" + homeTown + ", exp=" + exp + ", signature=" + signature + ", closeDown="
        + closeDown + "]";
  }
}