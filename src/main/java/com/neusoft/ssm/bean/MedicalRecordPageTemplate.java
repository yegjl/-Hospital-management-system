package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * medical_record_page_template
 * @author 
 */
public class MedicalRecordPageTemplate implements Serializable {
    private Integer id;

    /**
     * 病历首页id
     */
    private Integer medicalRecordPageId;

    /**
     * 医生id
     */
    private Integer doctorid;

    /**
     * 名称
     */
    private String name;

    /**
     * 类别：全院 科室 个人
     */
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalRecordPageId() {
        return medicalRecordPageId;
    }

    public void setMedicalRecordPageId(Integer medicalRecordPageId) {
        this.medicalRecordPageId = medicalRecordPageId;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        MedicalRecordPageTemplate other = (MedicalRecordPageTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalRecordPageId() == null ? other.getMedicalRecordPageId() == null : this.getMedicalRecordPageId().equals(other.getMedicalRecordPageId()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalRecordPageId() == null) ? 0 : getMedicalRecordPageId().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalRecordPageId=").append(medicalRecordPageId);
        sb.append(", doctorid=").append(doctorid);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}