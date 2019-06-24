package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * prescribe
 * @author 
 */
public class Prescribe implements Serializable {
    private Integer id;

    /**
     * 病历id
     */
    private Integer medicalrecordid;

    /**
     * 开处方医生id
     */
    private Integer doctorid;

    /**
     * 取药标志：0：未取药、1：已取药
     */
    private Integer getmedicalflag;

    /**
     * 门诊处方的类型：普通门诊处方、专家门诊处方、专科门诊处方
     */
    private String type;

    /**
     * 开药类别：成药，草药
     */
    private String medicaltype;

    /**
     * 诊毕：0：未诊毕(未开立)，1：诊毕(开立), 2：作废
     */
    private Integer isdone;

    /**
     * 本处方的总金额
     */
    private BigDecimal money;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicalrecordid() {
        return medicalrecordid;
    }

    public void setMedicalrecordid(Integer medicalrecordid) {
        this.medicalrecordid = medicalrecordid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getGetmedicalflag() {
        return getmedicalflag;
    }

    public void setGetmedicalflag(Integer getmedicalflag) {
        this.getmedicalflag = getmedicalflag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedicaltype() {
        return medicaltype;
    }

    public void setMedicaltype(String medicaltype) {
        this.medicaltype = medicaltype;
    }

    public Integer getIsdone() {
        return isdone;
    }

    public void setIsdone(Integer isdone) {
        this.isdone = isdone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
        Prescribe other = (Prescribe) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicalrecordid() == null ? other.getMedicalrecordid() == null : this.getMedicalrecordid().equals(other.getMedicalrecordid()))
            && (this.getDoctorid() == null ? other.getDoctorid() == null : this.getDoctorid().equals(other.getDoctorid()))
            && (this.getGetmedicalflag() == null ? other.getGetmedicalflag() == null : this.getGetmedicalflag().equals(other.getGetmedicalflag()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMedicaltype() == null ? other.getMedicaltype() == null : this.getMedicaltype().equals(other.getMedicaltype()))
            && (this.getIsdone() == null ? other.getIsdone() == null : this.getIsdone().equals(other.getIsdone()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicalrecordid() == null) ? 0 : getMedicalrecordid().hashCode());
        result = prime * result + ((getDoctorid() == null) ? 0 : getDoctorid().hashCode());
        result = prime * result + ((getGetmedicalflag() == null) ? 0 : getGetmedicalflag().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMedicaltype() == null) ? 0 : getMedicaltype().hashCode());
        result = prime * result + ((getIsdone() == null) ? 0 : getIsdone().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
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
        sb.append(", getmedicalflag=").append(getmedicalflag);
        sb.append(", type=").append(type);
        sb.append(", medicaltype=").append(medicaltype);
        sb.append(", isdone=").append(isdone);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}