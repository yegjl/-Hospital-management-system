package com.neusoft.ssm.bean;

public class Jianchaoften {
    private Integer id;

    private Integer itemid;

    private String itemname;

    private String mark;

    public Jianchaoften(Integer id, Integer itemid, String itemname, String mark) {
        this.id = id;
        this.itemid = itemid;
        this.itemname = itemname;
        this.mark = mark;
    }

    public Jianchaoften() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}