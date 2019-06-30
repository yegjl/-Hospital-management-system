package com.neusoft.ssm.bean;

public class Sixpartoften {
    private Integer id;

    private Integer drugid;

    private String drugsname;

    private String drugsprice;

    public Sixpartoften(Integer id, Integer drugid, String drugsname, String drugsprice) {
        this.id = id;
        this.drugid = drugid;
        this.drugsname = drugsname;
        this.drugsprice = drugsprice;
    }

    public Sixpartoften() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public String getDrugsname() {
        return drugsname;
    }

    public void setDrugsname(String drugsname) {
        this.drugsname = drugsname == null ? null : drugsname.trim();
    }

    public String getDrugsprice() {
        return drugsprice;
    }

    public void setDrugsprice(String drugsprice) {
        this.drugsprice = drugsprice == null ? null : drugsprice.trim();
    }
}