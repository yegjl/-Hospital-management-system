package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * oftendrug
 * @author 
 */
public class Oftendrug implements Serializable {
    private Integer id;

    /**
     * 药品id
     */
    private Integer medicalid;

    /**
     * 药品名称
     */
    private String medicalname;

    /**
     * 对应医生id
     */
    private Integer doctorid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(Integer medicalid) {
        this.medicalid = medicalid;
    }

    public String getMedicalname() {
        return medicalname;
    }

    public void setMedicalname(String medicalname) {
        this.medicalname = medicalname;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
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
        Oftendrug other = (Oftendrug) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalid() == null ? other.getMedicalid() == null : this.getMedicalid().equals(other.getMedicalid()))
            && (this.getMedicalname() == null ? other.getMedicalname() == null : this.getMedicalname().equals(other.getMedicalname()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalid() == null) ? 0 : getMedicalid().hashCode());
        result = prime * result + ((getMedicalname() == null) ? 0 : getMedicalname().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalid=").append(medicalid);
        sb.append(", medicalname=").append(medicalname);
        sb.append(", doctorid=").append(doctorid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}