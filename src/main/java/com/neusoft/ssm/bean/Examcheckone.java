package com.neusoft.ssm.bean;

public class Examcheckone {
    private String mark;

    private Integer doctorid;

    private Integer medicalrecordid;

    private String status;

    private String itemcode;

    private String itemname;

    private Integer examcheckid;

    private String goal;

    private String requirementment;

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRequirement() {
        return requirementment;
    }

    public void setRequirement(String requirement) {
        this.requirementment = requirement;
    }

    public Integer getExamcheckid() {
        return examcheckid;
    }

    public void setExamcheckid(Integer examcheckid) {
        this.examcheckid = examcheckid;
    }

    public Examcheckone(String mark, Integer doctorid, Integer medicalrecordid, String status, String itemcode, String itemname) {
        this.mark = mark;
        this.doctorid = doctorid;
        this.medicalrecordid = medicalrecordid;
        this.status = status;
        this.itemcode = itemcode;
        this.itemname = itemname;
    }

    public Examcheckone() {
        super();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getMedicalrecordid() {
        return medicalrecordid;
    }

    public void setMedicalrecordid(Integer medicalrecordid) {
        this.medicalrecordid = medicalrecordid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }
}