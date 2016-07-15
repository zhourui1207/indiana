package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class PublishRecordDetail implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -7226264913291581877L;

  private Long publishRecordDetailId;

  private Integer goodsStatus;

  private Long userId;

  private Long goodsId;

  private String goodsName;

  private String littlePic;

  private Long total;

  private String buyCount;

  private String luckyNumber;

  private Date publishTime;

  private String consignee;

  private String phone;

  private String shippingAddress;

  private Date confirmShippingAddressTime;

  private String logisticsName;

  private String logisticsCompany;

  private String waybillNumber;

  private Long shipper;

  private Date deliverGoodsTime;

  private Date confirmReceiveTime;

  public Long getPublishRecordDetailId() {
    return publishRecordDetailId;
  }

  public void setPublishRecordDetailId(Long publishRecordDetailId) {
    this.publishRecordDetailId = publishRecordDetailId;
  }

  public Integer getGoodsStatus() {
    return goodsStatus;
  }

  public void setGoodsStatus(Integer goodsStatus) {
    this.goodsStatus = goodsStatus;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
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

  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
  }

  public Date getConfirmShippingAddressTime() {
    return confirmShippingAddressTime;
  }

  public void setConfirmShippingAddressTime(Date confirmShippingAddressTime) {
    this.confirmShippingAddressTime = confirmShippingAddressTime;
  }

  public String getLogisticsName() {
    return logisticsName;
  }

  public void setLogisticsName(String logisticsName) {
    this.logisticsName = logisticsName == null ? null : logisticsName.trim();
  }

  public String getLogisticsCompany() {
    return logisticsCompany;
  }

  public void setLogisticsCompany(String logisticsCompany) {
    this.logisticsCompany = logisticsCompany == null ? null : logisticsCompany.trim();
  }

  public String getWaybillNumber() {
    return waybillNumber;
  }

  public void setWaybillNumber(String waybillNumber) {
    this.waybillNumber = waybillNumber == null ? null : waybillNumber.trim();
  }

  public Long getShipper() {
    return shipper;
  }

  public void setShipper(Long shipper) {
    this.shipper = shipper;
  }

  public Date getDeliverGoodsTime() {
    return deliverGoodsTime;
  }

  public void setDeliverGoodsTime(Date deliverGoodsTime) {
    this.deliverGoodsTime = deliverGoodsTime;
  }

  public Date getConfirmReceiveTime() {
    return confirmReceiveTime;
  }

  public void setConfirmReceiveTime(Date confirmReceiveTime) {
    this.confirmReceiveTime = confirmReceiveTime;
  }

  @Override
  public String toString() {
    return "PublishRecordDetail [publishRecordDetailId=" + publishRecordDetailId + ", goodsStatus=" + goodsStatus
        + ", userId=" + userId + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", littlePic=" + littlePic
        + ", total=" + total + ", buyCount=" + buyCount + ", luckyNumber=" + luckyNumber + ", publishTime="
        + publishTime + ", consignee=" + consignee + ", phone=" + phone + ", shippingAddress=" + shippingAddress
        + ", confirmShippingAddressTime=" + confirmShippingAddressTime + ", logisticsName=" + logisticsName
        + ", logisticsCompany=" + logisticsCompany + ", waybillNumber=" + waybillNumber + ", shipper=" + shipper
        + ", deliverGoodsTime=" + deliverGoodsTime + ", confirmReceiveTime=" + confirmReceiveTime + "]";
  }
}