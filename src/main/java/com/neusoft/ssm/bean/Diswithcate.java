package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * diswithcate
 * @author 
 */
public class Diswithcate implements Serializable {
    private Integer id;

    private String diseaseicd;

    private String diseasename;

    private String diseasecode;

    private String dicaname;

    private String icdid;

    private String disecategoryid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseicd() {
        return diseaseicd;
    }

    public void setDiseaseicd(String diseaseicd) {
        this.diseaseicd = diseaseicd;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode;
    }

    public String getDicaname() {
        return dicaname;
    }

    public void setDicaname(String dicaname) {
        this.dicaname = dicaname;
    }

    public String getIcdid() {
        return icdid;
    }

    public void setIcdid(String icdid) {
        this.icdid = icdid;
    }

    public String getDisecategoryid() {
        return disecategoryid;
    }

    public void setDisecategoryid(String disecategoryid) {
        this.disecategoryid = disecategoryid;
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
        Diswithcate other = (Diswithcate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDiseaseicd() == null ? other.getDiseaseicd() == null : this.getDiseaseicd().equals(other.getDiseaseicd()))
            && (this.getDiseasename() == null ? other.getDiseasename() == null : this.getDiseasename().equals(other.getDiseasename()))
            && (this.getDiseasecode() == null ? other.getDiseasecode() == null : this.getDiseasecode().equals(other.getDiseasecode()))
            && (this.getDicaname() == null ? other.getDicaname() == null : this.getDicaname().equals(other.getDicaname()))
            && (this.getIcdid() == null ? other.getIcdid() == null : this.getIcdid().equals(other.getIcdid()))
            && (this.getDisecategoryid() == null ? other.getDisecategoryid() == null : this.getDisecategoryid().equals(other.getDisecategoryid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDiseaseicd() == null) ? 0 : getDiseaseicd().hashCode());
        result = prime * result + ((getDiseasename() == null) ? 0 : getDiseasename().hashCode());
        result = prime * result + ((getDiseasecode() == null) ? 0 : getDiseasecode().hashCode());
        result = prime * result + ((getDicaname() == null) ? 0 : getDicaname().hashCode());
        result = prime * result + ((getIcdid() == null) ? 0 : getIcdid().hashCode());
        result = prime * result + ((getDisecategoryid() == null) ? 0 : getDisecategoryid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", diseaseicd=").append(diseaseicd);
        sb.append(", diseasename=").append(diseasename);
        sb.append(", diseasecode=").append(diseasecode);
        sb.append(", dicaname=").append(dicaname);
        sb.append(", icdid=").append(icdid);
        sb.append(", disecategoryid=").append(disecategoryid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}