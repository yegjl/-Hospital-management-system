package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * disease
 * @author 
 */
public class Disease implements Serializable {
    private Integer id;

    private String diseasecode;

    private String diseasename;

    private String diseaseicd;

    private String disecategoryid;

    private String icdname;

    private String icdid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public String getDiseaseicd() {
        return diseaseicd;
    }

    public void setDiseaseicd(String diseaseicd) {
        this.diseaseicd = diseaseicd;
    }

    public String getDisecategoryid() {
        return disecategoryid;
    }

    public void setDisecategoryid(String disecategoryid) {
        this.disecategoryid = disecategoryid;
    }

    public String getIcdname() {
        return icdname;
    }

    public void setIcdname(String icdname) {
        this.icdname = icdname;
    }

    public String getIcdid() {
        return icdid;
    }

    public void setIcdid(String icdid) {
        this.icdid = icdid;
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
        Disease other = (Disease) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDiseasecode() == null ? other.getDiseasecode() == null : this.getDiseasecode().equals(other.getDiseasecode()))
            && (this.getDiseasename() == null ? other.getDiseasename() == null : this.getDiseasename().equals(other.getDiseasename()))
            && (this.getDiseaseicd() == null ? other.getDiseaseicd() == null : this.getDiseaseicd().equals(other.getDiseaseicd()))
            && (this.getDisecategoryid() == null ? other.getDisecategoryid() == null : this.getDisecategoryid().equals(other.getDisecategoryid()))
            && (this.getIcdname() == null ? other.getIcdname() == null : this.getIcdname().equals(other.getIcdname()))
            && (this.getIcdid() == null ? other.getIcdid() == null : this.getIcdid().equals(other.getIcdid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDiseasecode() == null) ? 0 : getDiseasecode().hashCode());
        result = prime * result + ((getDiseasename() == null) ? 0 : getDiseasename().hashCode());
        result = prime * result + ((getDiseaseicd() == null) ? 0 : getDiseaseicd().hashCode());
        result = prime * result + ((getDisecategoryid() == null) ? 0 : getDisecategoryid().hashCode());
        result = prime * result + ((getIcdname() == null) ? 0 : getIcdname().hashCode());
        result = prime * result + ((getIcdid() == null) ? 0 : getIcdid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", diseasecode=").append(diseasecode);
        sb.append(", diseasename=").append(diseasename);
        sb.append(", diseaseicd=").append(diseaseicd);
        sb.append(", disecategoryid=").append(disecategoryid);
        sb.append(", icdname=").append(icdname);
        sb.append(", icdid=").append(icdid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}