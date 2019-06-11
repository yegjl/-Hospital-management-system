package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * fmeditem
 * @author 
 */
public class Fmeditem implements Serializable {
    private Integer id;

    private String itemcode;

    private String itemname;

    private String format;

    private Double price;

    private Integer expclassid;

    private Integer deptid;

    private String mnemoniccode;

    private String recordtype;

    private Date creationdate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getExpclassid() {
        return expclassid;
    }

    public void setExpclassid(Integer expclassid) {
        this.expclassid = expclassid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
    }

    public String getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(String recordtype) {
        this.recordtype = recordtype;
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
        Fmeditem other = (Fmeditem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemcode() == null ? other.getItemcode() == null : this.getItemcode().equals(other.getItemcode()))
            && (this.getItemname() == null ? other.getItemname() == null : this.getItemname().equals(other.getItemname()))
            && (this.getFormat() == null ? other.getFormat() == null : this.getFormat().equals(other.getFormat()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getExpclassid() == null ? other.getExpclassid() == null : this.getExpclassid().equals(other.getExpclassid()))
            && (this.getDeptid() == null ? other.getDeptid() == null : this.getDeptid().equals(other.getDeptid()))
            && (this.getMnemoniccode() == null ? other.getMnemoniccode() == null : this.getMnemoniccode().equals(other.getMnemoniccode()))
            && (this.getRecordtype() == null ? other.getRecordtype() == null : this.getRecordtype().equals(other.getRecordtype()))
            && (this.getCreationdate() == null ? other.getCreationdate() == null : this.getCreationdate().equals(other.getCreationdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemcode() == null) ? 0 : getItemcode().hashCode());
        result = prime * result + ((getItemname() == null) ? 0 : getItemname().hashCode());
        result = prime * result + ((getFormat() == null) ? 0 : getFormat().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getExpclassid() == null) ? 0 : getExpclassid().hashCode());
        result = prime * result + ((getDeptid() == null) ? 0 : getDeptid().hashCode());
        result = prime * result + ((getMnemoniccode() == null) ? 0 : getMnemoniccode().hashCode());
        result = prime * result + ((getRecordtype() == null) ? 0 : getRecordtype().hashCode());
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
        sb.append(", itemcode=").append(itemcode);
        sb.append(", itemname=").append(itemname);
        sb.append(", format=").append(format);
        sb.append(", price=").append(price);
        sb.append(", expclassid=").append(expclassid);
        sb.append(", deptid=").append(deptid);
        sb.append(", mnemoniccode=").append(mnemoniccode);
        sb.append(", recordtype=").append(recordtype);
        sb.append(", creationdate=").append(creationdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}