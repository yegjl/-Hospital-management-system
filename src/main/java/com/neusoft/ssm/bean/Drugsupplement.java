package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * drugsupplement
 * @author 
 */
public class Drugsupplement implements Serializable {
    private Integer id;

    private String drugsname;

    private String drugstatus;

    private Integer drugamount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDrugamount() {
        return drugamount;
    }

    public void setDrugamount(Integer drugamount) {
        this.drugamount = drugamount;
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
        Drugsupplement other = (Drugsupplement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrugsname() == null ? other.getDrugsname() == null : this.getDrugsname().equals(other.getDrugsname()))
            && (this.getDrugstatus() == null ? other.getDrugstatus() == null : this.getDrugstatus().equals(other.getDrugstatus()))
            && (this.getDrugamount() == null ? other.getDrugamount() == null : this.getDrugamount().equals(other.getDrugamount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrugsname() == null) ? 0 : getDrugsname().hashCode());
        result = prime * result + ((getDrugstatus() == null) ? 0 : getDrugstatus().hashCode());
        result = prime * result + ((getDrugamount() == null) ? 0 : getDrugamount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugsname=").append(drugsname);
        sb.append(", drugstatus=").append(drugstatus);
        sb.append(", drugamount=").append(drugamount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}