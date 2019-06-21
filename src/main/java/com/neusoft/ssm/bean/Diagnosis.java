package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * diagnosis
 * @author 
 */
public class Diagnosis implements Serializable {
    private Integer id;

    /**
     * 疾病id
     */
    private Integer diseaseid;
    private String diseasename;
    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 主诊疑似标志 0：主诊 1：疑似
     */
    private String flag;

    /**
     * 发病日期(date of accident)
     */
    private Date dA;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseid() {
        return diseaseid;
    }

    public void setDiseaseid(Integer diseaseid) {
        this.diseaseid = diseaseid;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getdA() {
        return dA;
    }

    public void setdA(Date dA) {
        this.dA = dA;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", diseaseid=" + diseaseid +
                ", diseasename='" + diseasename + '\'' +
                ", medicalRecordNo='" + medicalRecordNo + '\'' +
                ", flag='" + flag + '\'' +
                ", dA=" + dA +
                '}';
    }

//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Diagnosis other = (Diagnosis) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getDiseaseid() == null ? other.getDiseaseid() == null : this.getDiseaseid().equals(other.getDiseaseid()))
//            && (this.getMedicalRecordNo() == null ? other.getMedicalRecordNo() == null : this.getMedicalRecordNo().equals(other.getMedicalRecordNo()))
//            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
//            && (this.getdA() == null ? other.getdA() == null : this.getdA().equals(other.getdA()));
//    }

//    @Override

//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getDiseaseid() == null) ? 0 : getDiseaseid().hashCode());
//        result = prime * result + ((getMedicalRecordNo() == null) ? 0 : getMedicalRecordNo().hashCode());
//        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
//        result = prime * result + ((getdA() == null) ? 0 : getdA().hashCode());
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id.equals(diagnosis.id) &&
                diseaseid.equals(diagnosis.diseaseid) &&
                medicalRecordNo.equals(diagnosis.medicalRecordNo) &&
                flag.equals(diagnosis.flag) &&
                dA.equals(diagnosis.dA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diseaseid, medicalRecordNo, flag, dA);
    }
}