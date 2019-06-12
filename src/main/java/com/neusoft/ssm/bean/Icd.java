package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * icd
 * @author 
 */
public class Icd implements Serializable {
    private Integer id;

    private String icdsecondname;

    private String icdfirstname;

    private String area;

    private String icdid;

    private String f6;

    private String f7;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcdsecondname() {
        return icdsecondname;
    }

    public void setIcdsecondname(String icdsecondname) {
        this.icdsecondname = icdsecondname;
    }

    public String getIcdfirstname() {
        return icdfirstname;
    }

    public void setIcdfirstname(String icdfirstname) {
        this.icdfirstname = icdfirstname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIcdid() {
        return icdid;
    }

    public void setIcdid(String icdid) {
        this.icdid = icdid;
    }

    public String getF6() {
        return f6;
    }

    public void setF6(String f6) {
        this.f6 = f6;
    }

    public String getF7() {
        return f7;
    }

    public void setF7(String f7) {
        this.f7 = f7;
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
        Icd other = (Icd) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIcdsecondname() == null ? other.getIcdsecondname() == null : this.getIcdsecondname().equals(other.getIcdsecondname()))
            && (this.getIcdfirstname() == null ? other.getIcdfirstname() == null : this.getIcdfirstname().equals(other.getIcdfirstname()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getIcdid() == null ? other.getIcdid() == null : this.getIcdid().equals(other.getIcdid()))
            && (this.getF6() == null ? other.getF6() == null : this.getF6().equals(other.getF6()))
            && (this.getF7() == null ? other.getF7() == null : this.getF7().equals(other.getF7()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIcdsecondname() == null) ? 0 : getIcdsecondname().hashCode());
        result = prime * result + ((getIcdfirstname() == null) ? 0 : getIcdfirstname().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getIcdid() == null) ? 0 : getIcdid().hashCode());
        result = prime * result + ((getF6() == null) ? 0 : getF6().hashCode());
        result = prime * result + ((getF7() == null) ? 0 : getF7().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", icdsecondname=").append(icdsecondname);
        sb.append(", icdfirstname=").append(icdfirstname);
        sb.append(", area=").append(area);
        sb.append(", icdid=").append(icdid);
        sb.append(", f6=").append(f6);
        sb.append(", f7=").append(f7);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}