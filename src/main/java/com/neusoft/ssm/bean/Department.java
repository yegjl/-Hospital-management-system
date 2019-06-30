package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * department
 * @author
 */
public class Department implements Serializable {
    private Integer id;

    /**
     * 科室编码
     */
    private String deptcode;

    /**
     * 科室名称
     */
    private String deptname;

    /**
     * 科室分类 11：
     */
    private String deptcategoryid;

    /**
     * 科室类别 1：临床 2：医技
     */
    private Integer depttype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptcategoryid() {
        return deptcategoryid;
    }

    public void setDeptcategoryid(String deptcategoryid) {
        this.deptcategoryid = deptcategoryid;
    }

    public Integer getDepttype() {
        return depttype;
    }

    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
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
        Department other = (Department) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeptcode() == null ? other.getDeptcode() == null : this.getDeptcode().equals(other.getDeptcode()))
            && (this.getDeptname() == null ? other.getDeptname() == null : this.getDeptname().equals(other.getDeptname()))
            && (this.getDeptcategoryid() == null ? other.getDeptcategoryid() == null : this.getDeptcategoryid().equals(other.getDeptcategoryid()))
            && (this.getDepttype() == null ? other.getDepttype() == null : this.getDepttype().equals(other.getDepttype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeptcode() == null) ? 0 : getDeptcode().hashCode());
        result = prime * result + ((getDeptname() == null) ? 0 : getDeptname().hashCode());
        result = prime * result + ((getDeptcategoryid() == null) ? 0 : getDeptcategoryid().hashCode());
        result = prime * result + ((getDepttype() == null) ? 0 : getDepttype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deptcode=").append(deptcode);
        sb.append(", deptname=").append(deptname);
        sb.append(", deptcategoryid=").append(deptcategoryid);
        sb.append(", depttype=").append(depttype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}