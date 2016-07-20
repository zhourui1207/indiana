package com.jxlianlian.spring.rest.token.model;

public class Token {
  private long userId;
  private long expTime;
  private int userType;
  private boolean isPhone;
  
  public Token(long userId, long expTime, int userType, boolean isPhone) {
    this.userId = userId;
    this.expTime = expTime;
    this.userType = userType;
    this.isPhone = isPhone;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getExpTime() {
    return expTime;
  }

  public void setExpTime(long expTime) {
    this.expTime = expTime;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public boolean isPhone() {
    return isPhone;
  }

  public void setPhone(boolean isPhone) {
    this.isPhone = isPhone;
  }

  @Override
  public String toString() {
    return "Token [userId=" + userId + ", expTime=" + expTime + ", userType=" + userType + ", isPhone=" + isPhone + "]";
  }
}
