package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * dispensecategory
 * @author 
 */
public class Dispensecategory implements Serializable {
    private Integer id;

    /**
     * 病历号
     */
    private String medicalrecordno;

    /**
     * 药品id
     */
    private Integer medicineid;

    /**
     * 药品名称
     */
    private String medicinename;

    /**
     * 药品规格
     */
    private String format;

    /**
     * 药品数量
     */
    private Integer amount;

    /**
     * 药品单位
     */
    private String unit;

    /**
     * 药品单价
     */
    private BigDecimal price;

    /**
     * 厂家
     */
    private String manufacturer;

    /**
     * 发药状态（0.未发 1.已发 2.已退）
     */
    private Integer dispensestatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalrecordno() {
        return medicalrecordno;
    }

    public void setMedicalrecordno(String medicalrecordno) {
        this.medicalrecordno = medicalrecordno;
    }

    public Integer getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(Integer medicineid) {
        this.medicineid = medicineid;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getDispensestatus() {
        return dispensestatus;
    }

    public void setDispensestatus(Integer dispensestatus) {
        this.dispensestatus = dispensestatus;
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
        Dispensecategory other = (Dispensecategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalrecordno() == null ? other.getMedicalrecordno() == null : this.getMedicalrecordno().equals(other.getMedicalrecordno()))
            && (this.getMedicineid() == null ? other.getMedicineid() == null : this.getMedicineid().equals(other.getMedicineid()))
            && (this.getMedicinename() == null ? other.getMedicinename() == null : this.getMedicinename().equals(other.getMedicinename()))
            && (this.getFormat() == null ? other.getFormat() == null : this.getFormat().equals(other.getFormat()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getDispensestatus() == null ? other.getDispensestatus() == null : this.getDispensestatus().equals(other.getDispensestatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalrecordno() == null) ? 0 : getMedicalrecordno().hashCode());
        result = prime * result + ((getMedicineid() == null) ? 0 : getMedicineid().hashCode());
        result = prime * result + ((getMedicinename() == null) ? 0 : getMedicinename().hashCode());
        result = prime * result + ((getFormat() == null) ? 0 : getFormat().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getDispensestatus() == null) ? 0 : getDispensestatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalrecordno=").append(medicalrecordno);
        sb.append(", medicineid=").append(medicineid);
        sb.append(", medicinename=").append(medicinename);
        sb.append(", format=").append(format);
        sb.append(", amount=").append(amount);
        sb.append(", unit=").append(unit);
        sb.append(", price=").append(price);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", dispensestatus=").append(dispensestatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}