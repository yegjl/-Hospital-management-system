package com.neusoft.ssm.bean;

import java.io.Serializable;

/**
 * common_diagnosis
 * @author 
 */
public class CommonDiagnosis implements Serializable {
    private Integer id;

    /**
     * 医生
     */
    private Integer doctorid;

    /**
     * 诊断
     */
    private Integer diagnosisid;

    /**
     * 中医西医标志
     */
    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getDiagnosisid() {
        return diagnosisid;
    }

    public void setDiagnosisid(Integer diagnosisid) {
        this.diagnosisid = diagnosisid;
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
        CommonDiagnosis other = (CommonDiagnosis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()))
            && (this.getDiagnosisid() == null ? other.getDiagnosisid() == null : this.getDiagnosisid().equals(other.getDiagnosisid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        result = prime * result + ((getDiagnosisid() == null) ? 0 : getDiagnosisid().hashCode());
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
        sb.append(", doctorid=").append(doctorid);
        sb.append(", diagnosisid=").append(diagnosisid);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}