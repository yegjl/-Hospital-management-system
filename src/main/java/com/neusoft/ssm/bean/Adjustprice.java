package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * adjustprice
 * @author 
 */
public class Adjustprice implements Serializable {
    private Integer id;

    /**
     * 药品id
     */
    private Integer drugid;

    /**
     * 药品名
     */
    private String drugname;

    /**
     * 规格
     */
    private String format;

    /**
     * 产地
     */
    private String manufacturer;

    /**
     * 原价
     */
    private BigDecimal oldprice;

    /**
     * 现价
     */
    private BigDecimal newprice;

    /**
     * 调价单号
     */
    private Integer adjustid;

    /**
     * 执行日期
     */
    private Date date;

    /**
     * 调价文号
     */
    private Integer adjustnumber;

    /**
     * 调价原因
     */
    private String reason;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getOldprice() {
        return oldprice;
    }

    public void setOldprice(BigDecimal oldprice) {
        this.oldprice = oldprice;
    }

    public BigDecimal getNewprice() {
        return newprice;
    }

    public void setNewprice(BigDecimal newprice) {
        this.newprice = newprice;
    }

    public Integer getAdjustid() {
        return adjustid;
    }

    public void setAdjustid(Integer adjustid) {
        this.adjustid = adjustid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAdjustnumber() {
        return adjustnumber;
    }

    public void setAdjustnumber(Integer adjustnumber) {
        this.adjustnumber = adjustnumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        Adjustprice other = (Adjustprice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrugid() == null ? other.getDrugid() == null : this.getDrugid().equals(other.getDrugid()))
            && (this.getDrugname() == null ? other.getDrugname() == null : this.getDrugname().equals(other.getDrugname()))
            && (this.getFormat() == null ? other.getFormat() == null : this.getFormat().equals(other.getFormat()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getOldprice() == null ? other.getOldprice() == null : this.getOldprice().equals(other.getOldprice()))
            && (this.getNewprice() == null ? other.getNewprice() == null : this.getNewprice().equals(other.getNewprice()))
            && (this.getAdjustid() == null ? other.getAdjustid() == null : this.getAdjustid().equals(other.getAdjustid()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getAdjustnumber() == null ? other.getAdjustnumber() == null : this.getAdjustnumber().equals(other.getAdjustnumber()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrugid() == null) ? 0 : getDrugid().hashCode());
        result = prime * result + ((getDrugname() == null) ? 0 : getDrugname().hashCode());
        result = prime * result + ((getFormat() == null) ? 0 : getFormat().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getOldprice() == null) ? 0 : getOldprice().hashCode());
        result = prime * result + ((getNewprice() == null) ? 0 : getNewprice().hashCode());
        result = prime * result + ((getAdjustid() == null) ? 0 : getAdjustid().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getAdjustnumber() == null) ? 0 : getAdjustnumber().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugid=").append(drugid);
        sb.append(", drugname=").append(drugname);
        sb.append(", format=").append(format);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", oldprice=").append(oldprice);
        sb.append(", newprice=").append(newprice);
        sb.append(", adjustid=").append(adjustid);
        sb.append(", date=").append(date);
        sb.append(", adjustnumber=").append(adjustnumber);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}