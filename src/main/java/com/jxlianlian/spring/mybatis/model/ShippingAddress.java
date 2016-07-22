package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;

public class ShippingAddress implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -6251300873519810791L;

  private Long shippingAddressId;

  private Long userId;

  private String consignee;

  private String phone;

  private String area;

  private String address;

  private String postcode;

  public void initShippingAddress(Long userId, String consignee, String phone, String area,
      String address, String postcode) {
      this.userId = userId;
      this.consignee = consignee;
      this.phone = phone;
      this.area = area;
      this.address = address;
      this.postcode = postcode;
  }

  public Long getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(Long shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getConsignee() {
    return consignee;
  }

  public void setConsignee(String consignee) {
    this.consignee = consignee == null ? null : consignee.trim();
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area == null ? null : area.trim();
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address == null ? null : address.trim();
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode == null ? null : postcode.trim();
  }

  @Override
  public String toString() {
    return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", userId=" + userId + ", consignee=" + consignee
        + ", phone=" + phone + ", area=" + area + ", address=" + address + ", postcode=" + postcode + "]";
  }
}