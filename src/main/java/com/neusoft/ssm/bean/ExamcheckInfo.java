package com.neusoft.ssm.bean;

public class ExamcheckInfo {
    private Integer id;

    private Integer examcheckid;

    private Integer fmeditemid;

    private String status;

    private String goal;

    private String requirementment;

    public ExamcheckInfo(Integer id, Integer examcheckid, Integer fmeditemid, String status, String goal, String requirementment) {
        this.id = id;
        this.examcheckid = examcheckid;
        this.fmeditemid = fmeditemid;
        this.status = status;
        this.goal = goal;
        this.requirementment = requirementment;
    }

    public ExamcheckInfo() {
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

    public Integer getFmeditemid() {
        return fmeditemid;
    }

    public void setFmeditemid(Integer fmeditemid) {
        this.fmeditemid = fmeditemid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal == null ? null : goal.trim();
    }

    public String getRequirement() {
        return requirementment;
    }

    public void setRequirement(String requirement) {
        this.requirementment = requirement == null ? null : requirement.trim();
    }
}