package com.neusoft.ssm.bean;

public class ExamcheckResult {
    private Integer id;

    private Integer examcheckid;

    private Integer doctorid;

    private String suojian;

    private String diagnosis;

    public String getSuojian() {
        return suojian;
    }

    public void setSuojian(String suojian) {
        this.suojian = suojian;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ExamcheckResult(Integer id, Integer examcheckid, Integer doctorid) {
        this.id = id;
        this.examcheckid = examcheckid;
        this.doctorid = doctorid;
    }

    public ExamcheckResult() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamcheckid() {
        return examcheckid;
    }

    public void setExamcheckid(Integer examcheckid) {
        this.examcheckid = examcheckid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }
}