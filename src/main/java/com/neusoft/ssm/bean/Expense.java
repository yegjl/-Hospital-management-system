package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * expense
 * @author 
 */
public class Expense implements Serializable {
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 收费类别
     */
    private String expenseCategory;

    /**
     * 收费项目id
     */
    private String expenseId;

    /**
     * 处方id
     */
    private Integer prescribeId;

    /**
     * 数量
     */
    private Long number;

    /**
     * 应付费用
     */
    private BigDecimal expense;

    /**
     * 实付费用
     */
    private BigDecimal realExpense;

    /**
     * 支付方式 01：现金 02：银行储蓄卡 03：银行信用卡 04：支付宝 05：微信支付  06：医保卡
     */
    private String payCategory;

    /**
     * 付款标志 1：已付款 0：未付款 2：已退费 3：部分退费
     */
    private String paySign;

    /**
     * 日结状态 1：已日结 0：未日结
     */
    private String daySettleSign;

    /**
     * 操作日期
     */
    private Date expenseDate;

    /**
     * 是否已消费 1：是 0：否
     */
    private String isConsume;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getPrescribeId() {
        return prescribeId;
    }

    public void setPrescribeId(Integer prescribeId) {
        this.prescribeId = prescribeId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public BigDecimal getRealExpense() {
        return realExpense;
    }

    public void setRealExpense(BigDecimal realExpense) {
        this.realExpense = realExpense;
    }

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getDaySettleSign() {
        return daySettleSign;
    }

    public void setDaySettleSign(String daySettleSign) {
        this.daySettleSign = daySettleSign;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getIsConsume() {
        return isConsume;
    }

    public void setIsConsume(String isConsume) {
        this.isConsume = isConsume;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Expense other = (Expense) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalRecordNo() == null ? other.getMedicalRecordNo() == null : this.getMedicalRecordNo().equals(other.getMedicalRecordNo()))
            && (this.getExpenseCategory() == null ? other.getExpenseCategory() == null : this.getExpenseCategory().equals(other.getExpenseCategory()))
            && (this.getExpenseId() == null ? other.getExpenseId() == null : this.getExpenseId().equals(other.getExpenseId()))
            && (this.getPrescribeId() == null ? other.getPrescribeId() == null : this.getPrescribeId().equals(other.getPrescribeId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getExpense() == null ? other.getExpense() == null : this.getExpense().equals(other.getExpense()))
            && (this.getRealExpense() == null ? other.getRealExpense() == null : this.getRealExpense().equals(other.getRealExpense()))
            && (this.getPayCategory() == null ? other.getPayCategory() == null : this.getPayCategory().equals(other.getPayCategory()))
            && (this.getPaySign() == null ? other.getPaySign() == null : this.getPaySign().equals(other.getPaySign()))
            && (this.getDaySettleSign() == null ? other.getDaySettleSign() == null : this.getDaySettleSign().equals(other.getDaySettleSign()))
            && (this.getExpenseDate() == null ? other.getExpenseDate() == null : this.getExpenseDate().equals(other.getExpenseDate()))
            && (this.getIsConsume() == null ? other.getIsConsume() == null : this.getIsConsume().equals(other.getIsConsume()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalRecordNo() == null) ? 0 : getMedicalRecordNo().hashCode());
        result = prime * result + ((getExpenseCategory() == null) ? 0 : getExpenseCategory().hashCode());
        result = prime * result + ((getExpenseId() == null) ? 0 : getExpenseId().hashCode());
        result = prime * result + ((getPrescribeId() == null) ? 0 : getPrescribeId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getExpense() == null) ? 0 : getExpense().hashCode());
        result = prime * result + ((getRealExpense() == null) ? 0 : getRealExpense().hashCode());
        result = prime * result + ((getPayCategory() == null) ? 0 : getPayCategory().hashCode());
        result = prime * result + ((getPaySign() == null) ? 0 : getPaySign().hashCode());
        result = prime * result + ((getDaySettleSign() == null) ? 0 : getDaySettleSign().hashCode());
        result = prime * result + ((getExpenseDate() == null) ? 0 : getExpenseDate().hashCode());
        result = prime * result + ((getIsConsume() == null) ? 0 : getIsConsume().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalRecordNo=").append(medicalRecordNo);
        sb.append(", expenseCategory=").append(expenseCategory);
        sb.append(", expenseId=").append(expenseId);
        sb.append(", prescribeId=").append(prescribeId);
        sb.append(", number=").append(number);
        sb.append(", expense=").append(expense);
        sb.append(", realExpense=").append(realExpense);
        sb.append(", payCategory=").append(payCategory);
        sb.append(", paySign=").append(paySign);
        sb.append(", daySettleSign=").append(daySettleSign);
        sb.append(", expenseDate=").append(expenseDate);
        sb.append(", isConsume=").append(isConsume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}