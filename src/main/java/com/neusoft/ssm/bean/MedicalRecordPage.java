package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * medical_record_page
 * @author 
 */
public class MedicalRecordPage implements Serializable {
    private Integer id;

    /**
     * 病历号
     */
    private String medicalRecordNo;

    private Integer doctorid;

    /**
     * 主诉
     */
    private String chiefComplaint;

    /**
     * 现病史
     */
    private String hpi;

    /**
     * 既往史
     */
    private String ph;

    /**
     * 过敏史
     */
    private String historyOfAllergy;

    /**
     * 体格检查
     */
    private String healthCheckup;

    /**
     * 初步诊断
     */
    private Integer primaryDiagnosis;

    /**
     * 0:西医 1：中医
     */
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getHpi() {
        return hpi;
    }

    public void setHpi(String hpi) {
        this.hpi = hpi;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getHistoryOfAllergy() {
        return historyOfAllergy;
    }

    public void setHistoryOfAllergy(String historyOfAllergy) {
        this.historyOfAllergy = historyOfAllergy;
    }

    public String getHealthCheckup() {
        return healthCheckup;
    }

    public void setHealthCheckup(String healthCheckup) {
        this.healthCheckup = healthCheckup;
    }

    public Integer getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(Integer primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
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
        MedicalRecordPage other = (MedicalRecordPage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalRecordNo() == null ? other.getMedicalRecordNo() == null : this.getMedicalRecordNo().equals(other.getMedicalRecordNo()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()))
            && (this.getChiefComplaint() == null ? other.getChiefComplaint() == null : this.getChiefComplaint().equals(other.getChiefComplaint()))
            && (this.getHpi() == null ? other.getHpi() == null : this.getHpi().equals(other.getHpi()))
            && (this.getPh() == null ? other.getPh() == null : this.getPh().equals(other.getPh()))
            && (this.getHistoryOfAllergy() == null ? other.getHistoryOfAllergy() == null : this.getHistoryOfAllergy().equals(other.getHistoryOfAllergy()))
            && (this.getHealthCheckup() == null ? other.getHealthCheckup() == null : this.getHealthCheckup().equals(other.getHealthCheckup()))
            && (this.getPrimaryDiagnosis() == null ? other.getPrimaryDiagnosis() == null : this.getPrimaryDiagnosis().equals(other.getPrimaryDiagnosis()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalRecordNo() == null) ? 0 : getMedicalRecordNo().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        result = prime * result + ((getChiefComplaint() == null) ? 0 : getChiefComplaint().hashCode());
        result = prime * result + ((getHpi() == null) ? 0 : getHpi().hashCode());
        result = prime * result + ((getPh() == null) ? 0 : getPh().hashCode());
        result = prime * result + ((getHistoryOfAllergy() == null) ? 0 : getHistoryOfAllergy().hashCode());
        result = prime * result + ((getHealthCheckup() == null) ? 0 : getHealthCheckup().hashCode());
        result = prime * result + ((getPrimaryDiagnosis() == null) ? 0 : getPrimaryDiagnosis().hashCode());
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
        sb.append(", medicalRecordNo=").append(medicalRecordNo);
        sb.append(", doctorid=").append(doctorid);
        sb.append(", chiefComplaint=").append(chiefComplaint);
        sb.append(", hpi=").append(hpi);
        sb.append(", ph=").append(ph);
        sb.append(", historyOfAllergy=").append(historyOfAllergy);
        sb.append(", healthCheckup=").append(healthCheckup);
        sb.append(", primaryDiagnosis=").append(primaryDiagnosis);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}