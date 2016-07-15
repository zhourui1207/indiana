package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -3147301683552967050L;

  private Long goodsId;

  private Long goodsTemplateId;

  private Long period;

  private String goodsName;

  private String littlePic;

  private Byte goodsType;

  private String price;

  private Long total;

  private Integer unitPrice;

  private String goodsContent;

  private String memo;

  private String previewPicFirst;

  private String previewPicSecond;

  private String previewPicThird;

  private String previewPicFourth;

  private String previewPicFifth;

  private String detailPicFirst;

  private String detailPicSecond;

  private String detailPicThird;

  private String detailPicFourth;

  private String detailPicFifth;

  private String detailPicSixth;

  private String detailPicSeventh;

  private String detailPicEighth;

  private String detailPicNinth;

  private String detailPicTenth;

  private Long rest;

  private Date insertTime;

  private Date updateTime;

  private Date templateInsertTime;

  private Long hot;

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

  public Byte getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(Byte goodsType) {
    this.goodsType = goodsType;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price == null ? null : price.trim();
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public Integer getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getGoodsContent() {
    return goodsContent;
  }

  public void setGoodsContent(String goodsContent) {
    this.goodsContent = goodsContent == null ? null : goodsContent.trim();
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo == null ? null : memo.trim();
  }

  public String getPreviewPicFirst() {
    return previewPicFirst;
  }

  public void setPreviewPicFirst(String previewPicFirst) {
    this.previewPicFirst = previewPicFirst == null ? null : previewPicFirst.trim();
  }

  public String getPreviewPicSecond() {
    return previewPicSecond;
  }

  public void setPreviewPicSecond(String previewPicSecond) {
    this.previewPicSecond = previewPicSecond == null ? null : previewPicSecond.trim();
  }

  public String getPreviewPicThird() {
    return previewPicThird;
  }

  public void setPreviewPicThird(String previewPicThird) {
    this.previewPicThird = previewPicThird == null ? null : previewPicThird.trim();
  }

  public String getPreviewPicFourth() {
    return previewPicFourth;
  }

  public void setPreviewPicFourth(String previewPicFourth) {
    this.previewPicFourth = previewPicFourth == null ? null : previewPicFourth.trim();
  }

  public String getPreviewPicFifth() {
    return previewPicFifth;
  }

  public void setPreviewPicFifth(String previewPicFifth) {
    this.previewPicFifth = previewPicFifth == null ? null : previewPicFifth.trim();
  }

  public String getDetailPicFirst() {
    return detailPicFirst;
  }

  public void setDetailPicFirst(String detailPicFirst) {
    this.detailPicFirst = detailPicFirst == null ? null : detailPicFirst.trim();
  }

  public String getDetailPicSecond() {
    return detailPicSecond;
  }

  public void setDetailPicSecond(String detailPicSecond) {
    this.detailPicSecond = detailPicSecond == null ? null : detailPicSecond.trim();
  }

  public String getDetailPicThird() {
    return detailPicThird;
  }

  public void setDetailPicThird(String detailPicThird) {
    this.detailPicThird = detailPicThird == null ? null : detailPicThird.trim();
  }

  public String getDetailPicFourth() {
    return detailPicFourth;
  }

  public void setDetailPicFourth(String detailPicFourth) {
    this.detailPicFourth = detailPicFourth == null ? null : detailPicFourth.trim();
  }

  public String getDetailPicFifth() {
    return detailPicFifth;
  }

  public void setDetailPicFifth(String detailPicFifth) {
    this.detailPicFifth = detailPicFifth == null ? null : detailPicFifth.trim();
  }

  public String getDetailPicSixth() {
    return detailPicSixth;
  }

  public void setDetailPicSixth(String detailPicSixth) {
    this.detailPicSixth = detailPicSixth == null ? null : detailPicSixth.trim();
  }

  public String getDetailPicSeventh() {
    return detailPicSeventh;
  }

  public void setDetailPicSeventh(String detailPicSeventh) {
    this.detailPicSeventh = detailPicSeventh == null ? null : detailPicSeventh.trim();
  }

  public String getDetailPicEighth() {
    return detailPicEighth;
  }

  public void setDetailPicEighth(String detailPicEighth) {
    this.detailPicEighth = detailPicEighth == null ? null : detailPicEighth.trim();
  }

  public String getDetailPicNinth() {
    return detailPicNinth;
  }

  public void setDetailPicNinth(String detailPicNinth) {
    this.detailPicNinth = detailPicNinth == null ? null : detailPicNinth.trim();
  }

  public String getDetailPicTenth() {
    return detailPicTenth;
  }

  public void setDetailPicTenth(String detailPicTenth) {
    this.detailPicTenth = detailPicTenth == null ? null : detailPicTenth.trim();
  }

  public Long getRest() {
    return rest;
  }

  public void setRest(Long rest) {
    this.rest = rest;
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

  public Date getTemplateInsertTime() {
    return templateInsertTime;
  }

  public void setTemplateInsertTime(Date templateInsertTime) {
    this.templateInsertTime = templateInsertTime;
  }

  public Long getHot() {
    return hot;
  }

  public void setHot(Long hot) {
    this.hot = hot;
  }

  @Override
  public String toString() {
    return "Goods [goodsId=" + goodsId + ", goodsTemplateId=" + goodsTemplateId + ", period=" + period + ", goodsName="
        + goodsName + ", littlePic=" + littlePic + ", goodsType=" + goodsType + ", price=" + price + ", total=" + total
        + ", unitPrice=" + unitPrice + ", goodsContent=" + goodsContent + ", memo=" + memo + ", previewPicFirst="
        + previewPicFirst + ", previewPicSecond=" + previewPicSecond + ", previewPicThird=" + previewPicThird
        + ", previewPicFourth=" + previewPicFourth + ", previewPicFifth=" + previewPicFifth + ", detailPicFirst="
        + detailPicFirst + ", detailPicSecond=" + detailPicSecond + ", detailPicThird=" + detailPicThird
        + ", detailPicFourth=" + detailPicFourth + ", detailPicFifth=" + detailPicFifth + ", detailPicSixth="
        + detailPicSixth + ", detailPicSeventh=" + detailPicSeventh + ", detailPicEighth=" + detailPicEighth
        + ", detailPicNinth=" + detailPicNinth + ", detailPicTenth=" + detailPicTenth + ", rest=" + rest
        + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", templateInsertTime=" + templateInsertTime
        + ", hot=" + hot + "]";
  }
}