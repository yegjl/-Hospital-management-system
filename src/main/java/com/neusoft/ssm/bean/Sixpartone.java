package com.neusoft.ssm.bean;

import java.util.Date;

public class Sixpartone {
    private String status;

    private String goal;

    private String requirement;

    private Integer number;

    private String itemname;

    private String patient_name;

    private String medical_record_no;

    private String mark;

    private Double price;

    private Date date;

    private String ismed;

    private Integer operatorid;

    public Sixpartone(String status, String goal, String requirement, Integer number, String itemname, String patient_name, String medical_record_no, String mark, Double price, Date date, String ismed, Integer operatorid) {
        this.status = status;
        this.goal = goal;
        this.requirement = requirement;
        this.number = number;
        this.itemname = itemname;
        this.patient_name = patient_name;
        this.medical_record_no = medical_record_no;
        this.mark = mark;
        this.price = price;
        this.date = date;
        this.ismed = ismed;
        this.operatorid = operatorid;
    }

    public Sixpartone() {
        super();
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
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name == null ? null : patient_name.trim();
    }

    public String getMedical_record_no() {
        return medical_record_no;
    }

    public void setMedical_record_no(String medical_record_no) {
        this.medical_record_no = medical_record_no == null ? null : medical_record_no.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        this.ismed = ismed == null ? null : ismed.trim();
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }
}