package com.neusoft.ssm.bean;

public class Examcheck {
    private Integer id;

    private Integer medicalrecordid;

    private Integer doctorid;

    private String mark;

    public Examcheck(Integer id, Integer medicalrecordid, Integer doctorid, String mark) {
        this.id = id;
        this.medicalrecordid = medicalrecordid;
        this.doctorid = doctorid;
        this.mark = mark;
    }

    public Examcheck() {
        super();
    }

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}