package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;

public class SellingGoods implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 7663462938284951638L;

  private Long sellingGoodsId;

  private Long goodsTemplateId;

  private Long period;

  private Long goodsId;

  private Integer isSelling;

  public Long getSellingGoodsId() {
    return sellingGoodsId;
  }

  public void setSellingGoodsId(Long sellingGoodsId) {
    this.sellingGoodsId = sellingGoodsId;
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

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Integer getIsSelling() {
    return isSelling;
  }

  public void setIsSelling(Integer isSelling) {
    this.isSelling = isSelling;
  }
  
  @Override
  public String toString() {
    return "SellingGoods [sellingGoodsId=" + sellingGoodsId + ", goodsTemplateId=" + goodsTemplateId + ", period="
        + period + ", goodsId=" + goodsId + ", isSelling=" + isSelling + "]";
  }
}