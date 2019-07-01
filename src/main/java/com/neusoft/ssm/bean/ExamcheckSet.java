package com.neusoft.ssm.bean;

import java.util.Date;

public class ExamcheckSet {
    private Integer id;

    private Integer doctorid;

    private Integer deptid;

    private String setcode;

    private String setname;

    private Date time;

    private String requirement;

    private String limits;

    private String impression;

    private String diagnosis;

    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public ExamcheckSet(Integer id, Integer doctorid, Integer deptid, String setcode, String setname, Date time, String requirement, String limits, String impression, String diagnosis) {
        this.id = id;
        this.doctorid = doctorid;
        this.deptid = deptid;
        this.setcode = setcode;
        this.setname = setname;
        this.time = time;
        this.requirement = requirement;
        this.limits = limits;
        this.impression = impression;
        this.diagnosis = diagnosis;
    }

    public ExamcheckSet() {
        super();
    }

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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getSetcode() {
        return setcode;
    }

    public void setSetcode(String setcode) {
        this.setcode = setcode == null ? null : setcode.trim();
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname == null ? null : setname.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits == null ? null : limits.trim();
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression == null ? null : impression.trim();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }
}