package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * prescribemodellog
 * @author 
 */
public class Prescribemodellog implements Serializable {
    private Integer id;

    /**
     * 对应的模板id
     */
    private Integer prescribemodelid;

    /**
     * 药名称
     */
    private String medicalname;

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
     * 单位：g/ml
     */
    private String unit;

    /**
     * 频次
     */
    private String times;

    /**
     * 医嘱
     */
    private String entrust;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescribemodelid() {
        return prescribemodelid;
    }

    public void setPrescribemodelid(Integer prescribemodelid) {
        this.prescribemodelid = prescribemodelid;
    }

    public String getMedicalname() {
        return medicalname;
    }

    public void setMedicalname(String medicalname) {
        this.medicalname = medicalname;
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

    public String getEntrust() {
        return entrust;
    }

    public void setEntrust(String entrust) {
        this.entrust = entrust;
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
        Prescribemodellog other = (Prescribemodellog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrescribemodelid() == null ? other.getPrescribemodelid() == null : this.getPrescribemodelid().equals(other.getPrescribemodelid()))
            && (this.getMedicalname() == null ? other.getMedicalname() == null : this.getMedicalname().equals(other.getMedicalname()))
            && (this.getFormat() == null ? other.getFormat() == null : this.getFormat().equals(other.getFormat()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getUsage() == null ? other.getUsage() == null : this.getUsage().equals(other.getUsage()))
            && (this.getDosage() == null ? other.getDosage() == null : this.getDosage().equals(other.getDosage()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getEntrust() == null ? other.getEntrust() == null : this.getEntrust().equals(other.getEntrust()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrescribemodelid() == null) ? 0 : getPrescribemodelid().hashCode());
        result = prime * result + ((getMedicalname() == null) ? 0 : getMedicalname().hashCode());
        result = prime * result + ((getFormat() == null) ? 0 : getFormat().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getUsage() == null) ? 0 : getUsage().hashCode());
        result = prime * result + ((getDosage() == null) ? 0 : getDosage().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getEntrust() == null) ? 0 : getEntrust().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prescribemodelid=").append(prescribemodelid);
        sb.append(", medicalname=").append(medicalname);
        sb.append(", format=").append(format);
        sb.append(", price=").append(price);
        sb.append(", usage=").append(usage);
        sb.append(", dosage=").append(dosage);
        sb.append(", unit=").append(unit);
        sb.append(", times=").append(times);
        sb.append(", entrust=").append(entrust);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}