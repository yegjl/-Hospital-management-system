package com.neusoft.ssm.bean;

public class ScheduleResult {

    private long id;
    private java.util.Date date_time;
    private Long doctor_id;
    private String register_level;
    private String noon_level;
    private Integer limit_num;
    private Integer remain_num;
    private String doctor_name;
    private String department_name;
    private String department_id;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getRegister_level() {
        return register_level;
    }

    public void setRegister_level(String register_level) {
        this.register_level = register_level;
    }


    public String getNoon_level() {
        return noon_level;
    }

    public void setNoon_level(String noon_level) {
        this.noon_level = noon_level;
    }


    public Integer getLimit_num() {
        return limit_num;
    }

    public void setLimit_num(Integer limit_num) {
        this.limit_num = limit_num;
    }

    public Integer getRemain_num() {
        return remain_num;
    }

    public void setRemain_num(Integer remain_num) {
        this.remain_num = remain_num;
    }

    public java.util.Date getDateTime() {
        return date_time;
    }

    public void setDateTime(java.util.Date date_time) {
        this.date_time = date_time;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
