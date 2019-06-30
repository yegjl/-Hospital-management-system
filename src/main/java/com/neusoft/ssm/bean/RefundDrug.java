package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * refund_drug
 * @author 
 */
public class RefundDrug implements Serializable {
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 收费项目id
     */
    private String expenseId;

    /**
     * 处方id
     */
    private Integer prescribeId;

    /**
     * 退费数量
     */
    private Integer refundNumber;

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

    public Integer getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(Integer refundNumber) {
        this.refundNumber = refundNumber;
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
        RefundDrug other = (RefundDrug) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalRecordNo() == null ? other.getMedicalRecordNo() == null : this.getMedicalRecordNo().equals(other.getMedicalRecordNo()))
            && (this.getExpenseId() == null ? other.getExpenseId() == null : this.getExpenseId().equals(other.getExpenseId()))
            && (this.getPrescribeId() == null ? other.getPrescribeId() == null : this.getPrescribeId().equals(other.getPrescribeId()))
            && (this.getRefundNumber() == null ? other.getRefundNumber() == null : this.getRefundNumber().equals(other.getRefundNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalRecordNo() == null) ? 0 : getMedicalRecordNo().hashCode());
        result = prime * result + ((getExpenseId() == null) ? 0 : getExpenseId().hashCode());
        result = prime * result + ((getPrescribeId() == null) ? 0 : getPrescribeId().hashCode());
        result = prime * result + ((getRefundNumber() == null) ? 0 : getRefundNumber().hashCode());
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
        sb.append(", expenseId=").append(expenseId);
        sb.append(", prescribeId=").append(prescribeId);
        sb.append(", refundNumber=").append(refundNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}