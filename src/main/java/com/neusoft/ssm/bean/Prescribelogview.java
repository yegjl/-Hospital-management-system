package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * prescribelogview
 * @author 
 */
public class Prescribelogview implements Serializable {
    private Integer pid;

    private Integer prescribeid;

    /**
     * 药品的id
     */
    private Integer medicalid;

    /**
     * 规格
     */
    private String format;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 用法：静脉注射(下拉框可选)
     */
    private String usage;

    /**
     * 用量：0.25
     */
    private String dosage;

    /**
     * 单位（g、ml)
     */
    private String unit;

    /**
     * 频次
     */
    private String times;

    /**
     * 天数
     */
    private String days;

    /**
     * 次数
     */
    private String number;

    /**
     * 数量
     */
    private String amount;

    /**
     * 用药嘱托
     */
    private String entrust;

    /**
     * 存储状态：0表示非暂存，1表示暂存，2表示开立，3表示作废
     */
    private Integer istemp;

    private Integer drugid;

    private String drugsname;

    /**
     * 病历号
     */
    private String medicalrecordid;

    /**
     * 开处方医生id
     */
    private Integer doctorid;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPrescribeid() {
        return prescribeid;
    }

    public void setPrescribeid(Integer prescribeid) {
        this.prescribeid = prescribeid;
    }

    public Integer getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(Integer medicalid) {
        this.medicalid = medicalid;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEntrust() {
        return entrust;
    }

    public void setEntrust(String entrust) {
        this.entrust = entrust;
    }

    public Integer getIstemp() {
        return istemp;
    }

    public void setIstemp(Integer istemp) {
        this.istemp = istemp;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public String getDrugsname() {
        return drugsname;
    }

    public void setDrugsname(String drugsname) {
        this.drugsname = drugsname;
    }

    public String getMedicalrecordid() {
        return medicalrecordid;
    }

    public void setMedicalrecordid(String medicalrecordid) {
        this.medicalrecordid = medicalrecordid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
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
        Prescribelogview other = (Prescribelogview) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPrescribeid() == null ? other.getPrescribeid() == null : this.getPrescribeid().equals(other.getPrescribeid()))
            && (this.getMedicalid() == null ? other.getMedicalid() == null : this.getMedicalid().equals(other.getMedicalid()))
            && (this.getFormat() == null ? other.getFormat() == null : this.getFormat().equals(other.getFormat()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getUsage() == null ? other.getUsage() == null : this.getUsage().equals(other.getUsage()))
            && (this.getDosage() == null ? other.getDosage() == null : this.getDosage().equals(other.getDosage()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getEntrust() == null ? other.getEntrust() == null : this.getEntrust().equals(other.getEntrust()))
            && (this.getIstemp() == null ? other.getIstemp() == null : this.getIstemp().equals(other.getIstemp()))
            && (this.getDrugid() == null ? other.getDrugid() == null : this.getDrugid().equals(other.getDrugid()))
            && (this.getDrugsname() == null ? other.getDrugsname() == null : this.getDrugsname().equals(other.getDrugsname()))
            && (this.getMedicalrecordid() == null ? other.getMedicalrecordid() == null : this.getMedicalrecordid().equals(other.getMedicalrecordid()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPrescribeid() == null) ? 0 : getPrescribeid().hashCode());
        result = prime * result + ((getMedicalid() == null) ? 0 : getMedicalid().hashCode());
        result = prime * result + ((getFormat() == null) ? 0 : getFormat().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getUsage() == null) ? 0 : getUsage().hashCode());
        result = prime * result + ((getDosage() == null) ? 0 : getDosage().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getEntrust() == null) ? 0 : getEntrust().hashCode());
        result = prime * result + ((getIstemp() == null) ? 0 : getIstemp().hashCode());
        result = prime * result + ((getDrugid() == null) ? 0 : getDrugid().hashCode());
        result = prime * result + ((getDrugsname() == null) ? 0 : getDrugsname().hashCode());
        result = prime * result + ((getMedicalrecordid() == null) ? 0 : getMedicalrecordid().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", prescribeid=").append(prescribeid);
        sb.append(", medicalid=").append(medicalid);
        sb.append(", format=").append(format);
        sb.append(", price=").append(price);
        sb.append(", usage=").append(usage);
        sb.append(", dosage=").append(dosage);
        sb.append(", unit=").append(unit);
        sb.append(", times=").append(times);
        sb.append(", days=").append(days);
        sb.append(", number=").append(number);
        sb.append(", amount=").append(amount);
        sb.append(", entrust=").append(entrust);
        sb.append(", istemp=").append(istemp);
        sb.append(", drugid=").append(drugid);
        sb.append(", drugsname=").append(drugsname);
        sb.append(", medicalrecordid=").append(medicalrecordid);
        sb.append(", doctorid=").append(doctorid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}