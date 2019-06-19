package com.neusoft.ssm.bean;

public class ExamcheckSetInfo {
    private Integer id;

    private Integer setid;

    private Integer fmeditemid;

    private String entrust;

    public ExamcheckSetInfo(Integer id, Integer setid, Integer fmeditemid, String entrust) {
        this.id = id;
        this.setid = setid;
        this.fmeditemid = fmeditemid;
        this.entrust = entrust;
    }

    public ExamcheckSetInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetid() {
        return setid;
    }

    public void setSetid(Integer setid) {
        this.setid = setid;
    }

    public Integer getFmeditemid() {
        return fmeditemid;
    }

    public void setFmeditemid(Integer fmeditemid) {
        this.fmeditemid = fmeditemid;
    }

    public String getEntrust() {
        return entrust;
    }

    public void setEntrust(String entrust) {
        this.entrust = entrust == null ? null : entrust.trim();
    }
}