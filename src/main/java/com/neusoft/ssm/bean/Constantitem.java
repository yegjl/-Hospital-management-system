package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * constantitem
 * @author 
 */
public class Constantitem implements Serializable {
    private String id;

    private String constanttypeid;

    private String constantcode;

    private String constantname;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstanttypeid() {
        return constanttypeid;
    }

    public void setConstanttypeid(String constanttypeid) {
        this.constanttypeid = constanttypeid;
    }

    public String getConstantcode() {
        return constantcode;
    }

    public void setConstantcode(String constantcode) {
        this.constantcode = constantcode;
    }

    public String getConstantname() {
        return constantname;
    }

    public void setConstantname(String constantname) {
        this.constantname = constantname;
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
        Constantitem other = (Constantitem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getConstanttypeid() == null ? other.getConstanttypeid() == null : this.getConstanttypeid().equals(other.getConstanttypeid()))
            && (this.getConstantcode() == null ? other.getConstantcode() == null : this.getConstantcode().equals(other.getConstantcode()))
            && (this.getConstantname() == null ? other.getConstantname() == null : this.getConstantname().equals(other.getConstantname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConstanttypeid() == null) ? 0 : getConstanttypeid().hashCode());
        result = prime * result + ((getConstantcode() == null) ? 0 : getConstantcode().hashCode());
        result = prime * result + ((getConstantname() == null) ? 0 : getConstantname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", constanttypeid=").append(constanttypeid);
        sb.append(", constantcode=").append(constantcode);
        sb.append(", constantname=").append(constantname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}