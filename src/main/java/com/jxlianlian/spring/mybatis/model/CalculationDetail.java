package com.jxlianlian.spring.mybatis.model;

import java.io.Serializable;

public class CalculationDetail implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 3084718235547349891L;

  private Integer calculationDetailId;

  private String timeSum;

  private String total;

  private String ticketPeriod;

  private String ticketNumber;

  private String variable;

  public Integer getCalculationDetailId() {
    return calculationDetailId;
  }

  public void setCalculationDetailId(Integer calculationDetailId) {
    this.calculationDetailId = calculationDetailId;
  }

  public String getTimeSum() {
    return timeSum;
  }

  public void setTimeSum(String timeSum) {
    this.timeSum = timeSum == null ? null : timeSum.trim();
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total == null ? null : total.trim();
  }

  public String getTicketPeriod() {
    return ticketPeriod;
  }

  public void setTicketPeriod(String ticketPeriod) {
    this.ticketPeriod = ticketPeriod == null ? null : ticketPeriod.trim();
  }

  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber == null ? null : ticketNumber.trim();
  }

  public String getVariable() {
    return variable;
  }

  public void setVariable(String variable) {
    this.variable = variable == null ? null : variable.trim();
  }

  @Override
  public String toString() {
    return "CalculationDetail [calculationDetailId=" + calculationDetailId + ", timeSum=" + timeSum + ", total=" + total
        + ", ticketPeriod=" + ticketPeriod + ", ticketNumber=" + ticketNumber + ", variable=" + variable + "]";
  }
}