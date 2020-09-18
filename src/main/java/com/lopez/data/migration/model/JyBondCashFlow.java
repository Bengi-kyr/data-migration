package com.lopez.data.migration.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.math.BigDecimal;

public class JyBondCashFlow {
    private String bondCode;

    private Integer bondMarket;

    private Integer payInterestType;

    private String paymentDate;

    private BigDecimal paymentPer;

    private BigDecimal paymentAmount;

    private BigDecimal interestPer;

    private BigDecimal payInterestAmount;

    private String valueBeginDate;

    private String valueEndDate;

    @TableField("TotalSize")
    private BigDecimal totalSize;

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public Integer getBondMarket() {
        return bondMarket;
    }

    public void setBondMarket(Integer bondMarket) {
        this.bondMarket = bondMarket;
    }

    public Integer getPayInterestType() {
        return payInterestType;
    }

    public void setPayInterestType(Integer payInterestType) {
        this.payInterestType = payInterestType;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentPer() {
        return paymentPer;
    }

    public void setPaymentPer(BigDecimal paymentPer) {
        this.paymentPer = paymentPer;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getInterestPer() {
        return interestPer;
    }

    public void setInterestPer(BigDecimal interestPer) {
        this.interestPer = interestPer;
    }

    public BigDecimal getPayInterestAmount() {
        return payInterestAmount;
    }

    public void setPayInterestAmount(BigDecimal payInterestAmount) {
        this.payInterestAmount = payInterestAmount;
    }

    public String getValueBeginDate() {
        return valueBeginDate;
    }

    public void setValueBeginDate(String valueBeginDate) {
        this.valueBeginDate = valueBeginDate;
    }

    public String getValueEndDate() {
        return valueEndDate;
    }

    public void setValueEndDate(String valueEndDate) {
        this.valueEndDate = valueEndDate;
    }

    public BigDecimal getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(BigDecimal totalSize) {
        this.totalSize = totalSize;
    }
}
