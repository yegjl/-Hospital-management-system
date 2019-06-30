package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * drugs
 * @author
 */
public class Drugs implements Serializable {
    private Integer id;

    private String drugscode;

    private String drugsname;

    private String drugsformat;

    private String drugsunit;

    private String manufacturer;

    private String drugsdosageid;

    private String drugstypeid;

    private BigDecimal drugsprice;

    private String mnemoniccode;

    private Date creationdate;

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

    public String getDrugsformat() {
        return drugsformat;
    }

    public void setDrugsformat(String drugsformat) {
        this.drugsformat = drugsformat;
    }

    public String getDrugsunit() {
        return drugsunit;
    }

    public void setDrugsunit(String drugsunit) {
        this.drugsunit = drugsunit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDrugsdosageid() {
        return drugsdosageid;
    }

    public void setDrugsdosageid(String drugsdosageid) {
        this.drugsdosageid = drugsdosageid;
    }

    public String getDrugstypeid() {
        return drugstypeid;
    }

    public void setDrugstypeid(String drugstypeid) {
        this.drugstypeid = drugstypeid;
    }

    public BigDecimal getDrugsprice() {
        return drugsprice;
    }

    public void setDrugsprice(BigDecimal drugsprice) {
        this.drugsprice = drugsprice;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
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
        Drugs other = (Drugs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrugscode() == null ? other.getDrugscode() == null : this.getDrugscode().equals(other.getDrugscode()))
            && (this.getDrugsname() == null ? other.getDrugsname() == null : this.getDrugsname().equals(other.getDrugsname()))
            && (this.getDrugsformat() == null ? other.getDrugsformat() == null : this.getDrugsformat().equals(other.getDrugsformat()))
            && (this.getDrugsunit() == null ? other.getDrugsunit() == null : this.getDrugsunit().equals(other.getDrugsunit()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getDrugsdosageid() == null ? other.getDrugsdosageid() == null : this.getDrugsdosageid().equals(other.getDrugsdosageid()))
            && (this.getDrugstypeid() == null ? other.getDrugstypeid() == null : this.getDrugstypeid().equals(other.getDrugstypeid()))
            && (this.getDrugsprice() == null ? other.getDrugsprice() == null : this.getDrugsprice().equals(other.getDrugsprice()))
            && (this.getMnemoniccode() == null ? other.getMnemoniccode() == null : this.getMnemoniccode().equals(other.getMnemoniccode()))
            && (this.getCreationdate() == null ? other.getCreationdate() == null : this.getCreationdate().equals(other.getCreationdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrugscode() == null) ? 0 : getDrugscode().hashCode());
        result = prime * result + ((getDrugsname() == null) ? 0 : getDrugsname().hashCode());
        result = prime * result + ((getDrugsformat() == null) ? 0 : getDrugsformat().hashCode());
        result = prime * result + ((getDrugsunit() == null) ? 0 : getDrugsunit().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getDrugsdosageid() == null) ? 0 : getDrugsdosageid().hashCode());
        result = prime * result + ((getDrugstypeid() == null) ? 0 : getDrugstypeid().hashCode());
        result = prime * result + ((getDrugsprice() == null) ? 0 : getDrugsprice().hashCode());
        result = prime * result + ((getMnemoniccode() == null) ? 0 : getMnemoniccode().hashCode());
        result = prime * result + ((getCreationdate() == null) ? 0 : getCreationdate().hashCode());
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
        sb.append(", drugsformat=").append(drugsformat);
        sb.append(", drugsunit=").append(drugsunit);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", drugsdosageid=").append(drugsdosageid);
        sb.append(", drugstypeid=").append(drugstypeid);
        sb.append(", drugsprice=").append(drugsprice);
        sb.append(", mnemoniccode=").append(mnemoniccode);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}