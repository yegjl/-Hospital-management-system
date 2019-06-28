package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * druglogview
 * @author 
 */
public class Druglogview implements Serializable {
    private Integer id;

    private String drugscode;

    private String drugsname;

    private String drugstatus;

    private String drugsformat;

    private String constantname;

    private String drugsunit;

    private Integer drugamount;

    private BigDecimal drugsprice;

    private String manufacturer;

    private String typename;

    private String mnemoniccode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugscode() {
        return drugscode;
    }

    public void setDrugscode(String drugscode) {
        this.drugscode = drugscode;
    }

    public String getDrugsname() {
        return drugsname;
    }

    public void setDrugsname(String drugsname) {
        this.drugsname = drugsname;
    }

    public String getDrugstatus() {
        return drugstatus;
    }

    public void setDrugstatus(String drugstatus) {
        this.drugstatus = drugstatus;
    }

    public String getDrugsformat() {
        return drugsformat;
    }

    public void setDrugsformat(String drugsformat) {
        this.drugsformat = drugsformat;
    }

    public String getConstantname() {
        return constantname;
    }

    public void setConstantname(String constantname) {
        this.constantname = constantname;
    }

    public String getDrugsunit() {
        return drugsunit;
    }

    public void setDrugsunit(String drugsunit) {
        this.drugsunit = drugsunit;
    }

    public Integer getDrugamount() {
        return drugamount;
    }

    public void setDrugamount(Integer drugamount) {
        this.drugamount = drugamount;
    }

    public BigDecimal getDrugsprice() {
        return drugsprice;
    }

    public void setDrugsprice(BigDecimal drugsprice) {
        this.drugsprice = drugsprice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
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
        Druglogview other = (Druglogview) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrugscode() == null ? other.getDrugscode() == null : this.getDrugscode().equals(other.getDrugscode()))
            && (this.getDrugsname() == null ? other.getDrugsname() == null : this.getDrugsname().equals(other.getDrugsname()))
            && (this.getDrugstatus() == null ? other.getDrugstatus() == null : this.getDrugstatus().equals(other.getDrugstatus()))
            && (this.getDrugsformat() == null ? other.getDrugsformat() == null : this.getDrugsformat().equals(other.getDrugsformat()))
            && (this.getConstantname() == null ? other.getConstantname() == null : this.getConstantname().equals(other.getConstantname()))
            && (this.getDrugsunit() == null ? other.getDrugsunit() == null : this.getDrugsunit().equals(other.getDrugsunit()))
            && (this.getDrugamount() == null ? other.getDrugamount() == null : this.getDrugamount().equals(other.getDrugamount()))
            && (this.getDrugsprice() == null ? other.getDrugsprice() == null : this.getDrugsprice().equals(other.getDrugsprice()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()))
            && (this.getMnemoniccode() == null ? other.getMnemoniccode() == null : this.getMnemoniccode().equals(other.getMnemoniccode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrugscode() == null) ? 0 : getDrugscode().hashCode());
        result = prime * result + ((getDrugsname() == null) ? 0 : getDrugsname().hashCode());
        result = prime * result + ((getDrugstatus() == null) ? 0 : getDrugstatus().hashCode());
        result = prime * result + ((getDrugsformat() == null) ? 0 : getDrugsformat().hashCode());
        result = prime * result + ((getConstantname() == null) ? 0 : getConstantname().hashCode());
        result = prime * result + ((getDrugsunit() == null) ? 0 : getDrugsunit().hashCode());
        result = prime * result + ((getDrugamount() == null) ? 0 : getDrugamount().hashCode());
        result = prime * result + ((getDrugsprice() == null) ? 0 : getDrugsprice().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        result = prime * result + ((getMnemoniccode() == null) ? 0 : getMnemoniccode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugscode=").append(drugscode);
        sb.append(", drugsname=").append(drugsname);
        sb.append(", drugstatus=").append(drugstatus);
        sb.append(", drugsformat=").append(drugsformat);
        sb.append(", constantname=").append(constantname);
        sb.append(", drugsunit=").append(drugsunit);
        sb.append(", drugamount=").append(drugamount);
        sb.append(", drugsprice=").append(drugsprice);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", typename=").append(typename);
        sb.append(", mnemoniccode=").append(mnemoniccode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}