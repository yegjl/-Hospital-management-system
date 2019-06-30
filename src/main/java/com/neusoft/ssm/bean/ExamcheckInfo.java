package com.neusoft.ssm.bean;

import java.util.Date;

public class ExamcheckInfo {
    private Integer id;

    private Integer examcheckid;

    private Integer fmeditemid;

    private String status;

    private String goal;

    private String requirementment;

    private Integer number;

    private Date date;

    private String ismed;

    private Integer operatorid;

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getRequirementment() {
        return requirementment;
    }

    public void setRequirementment(String requirementment) {
        this.requirementment = requirementment;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIsmed() {
        return ismed;
    }

    public void setIsmed(String ismed) {
        this.ismed = ismed;
    }

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