package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * dispense
 * @author 
 */
public class Dispense implements Serializable {
    private Integer id;

    /**
     * 病历id
     */
    private String medicalrecordid;

    /**
     * 医生名字
     */
    private Integer doctorid;

    /**
     * 患者名字
     */
    private String patientname;

    /**
     * 0表示未发，1表示已经发药，2已退
     */
    private Integer dispensestatus;

    /**
     * 发药日期
     */
    private Date dispensedate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalrecordid() {
        return medicalrecordid;
    }

    public void setMedicalrecordid(String medicalrecordid) {
        this.medicalrecordid = medicalrecordid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getDispensestatus() {
        return dispensestatus;
    }

    public void setDispensestatus(Integer dispensestatus) {
        this.dispensestatus = dispensestatus;
    }

    public Date getDispensedate() {
        return dispensedate;
    }

    public void setDispensedate(Date dispensedate) {
        this.dispensedate = dispensedate;
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
        Dispense other = (Dispense) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalrecordid() == null ? other.getMedicalrecordid() == null : this.getMedicalrecordid().equals(other.getMedicalrecordid()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()))
            && (this.getPatientname() == null ? other.getPatientname() == null : this.getPatientname().equals(other.getPatientname()))
            && (this.getDispensestatus() == null ? other.getDispensestatus() == null : this.getDispensestatus().equals(other.getDispensestatus()))
            && (this.getDispensedate() == null ? other.getDispensedate() == null : this.getDispensedate().equals(other.getDispensedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalrecordid() == null) ? 0 : getMedicalrecordid().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        result = prime * result + ((getPatientname() == null) ? 0 : getPatientname().hashCode());
        result = prime * result + ((getDispensestatus() == null) ? 0 : getDispensestatus().hashCode());
        result = prime * result + ((getDispensedate() == null) ? 0 : getDispensedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicalrecordid=").append(medicalrecordid);
        sb.append(", doctorid=").append(doctorid);
        sb.append(", patientname=").append(patientname);
        sb.append(", dispensestatus=").append(dispensestatus);
        sb.append(", dispensedate=").append(dispensedate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}