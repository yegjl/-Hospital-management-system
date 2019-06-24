package com.neusoft.ssm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * prescribemodel
 * @author 
 */
public class Prescribemodel implements Serializable {
    private Integer id;

    /**
     * 处方id（可自己命名例如拼音）
     */
    private String prescribemodelid;

    private String prescribemodelname;

    /**
     * 业务分类:成药处方，草药处方
     */
    private String prescribeusage;

    /**
     * 单据分类：普诊。。。
     */
    private String prescribetype;

    /**
     * 服务对象：默认为“门诊”
     */
    private String server;

    /**
     * 使用范围:全院，科室，个人
     */
    private String usage;

    /**
     * 创建人
     */
    private String createman;

    /**
     * 创建科室
     */
    private String createdept;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescribemodelid() {
        return prescribemodelid;
    }

    public void setPrescribemodelid(String prescribemodelid) {
        this.prescribemodelid = prescribemodelid;
    }

    public String getPrescribemodelname() {
        return prescribemodelname;
    }

    public void setPrescribemodelname(String prescribemodelname) {
        this.prescribemodelname = prescribemodelname;
    }

    public String getPrescribeusage() {
        return prescribeusage;
    }

    public void setPrescribeusage(String prescribeusage) {
        this.prescribeusage = prescribeusage;
    }

    public String getPrescribetype() {
        return prescribetype;
    }

    public void setPrescribetype(String prescribetype) {
        this.prescribetype = prescribetype;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    public String getCreatedept() {
        return createdept;
    }

    public void setCreatedept(String createdept) {
        this.createdept = createdept;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Prescribemodel other = (Prescribemodel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrescribemodelid() == null ? other.getPrescribemodelid() == null : this.getPrescribemodelid().equals(other.getPrescribemodelid()))
            && (this.getPrescribemodelname() == null ? other.getPrescribemodelname() == null : this.getPrescribemodelname().equals(other.getPrescribemodelname()))
            && (this.getPrescribeusage() == null ? other.getPrescribeusage() == null : this.getPrescribeusage().equals(other.getPrescribeusage()))
            && (this.getPrescribetype() == null ? other.getPrescribetype() == null : this.getPrescribetype().equals(other.getPrescribetype()))
            && (this.getServer() == null ? other.getServer() == null : this.getServer().equals(other.getServer()))
            && (this.getUsage() == null ? other.getUsage() == null : this.getUsage().equals(other.getUsage()))
            && (this.getCreateman() == null ? other.getCreateman() == null : this.getCreateman().equals(other.getCreateman()))
            && (this.getCreatedept() == null ? other.getCreatedept() == null : this.getCreatedept().equals(other.getCreatedept()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrescribemodelid() == null) ? 0 : getPrescribemodelid().hashCode());
        result = prime * result + ((getPrescribemodelname() == null) ? 0 : getPrescribemodelname().hashCode());
        result = prime * result + ((getPrescribeusage() == null) ? 0 : getPrescribeusage().hashCode());
        result = prime * result + ((getPrescribetype() == null) ? 0 : getPrescribetype().hashCode());
        result = prime * result + ((getServer() == null) ? 0 : getServer().hashCode());
        result = prime * result + ((getUsage() == null) ? 0 : getUsage().hashCode());
        result = prime * result + ((getCreateman() == null) ? 0 : getCreateman().hashCode());
        result = prime * result + ((getCreatedept() == null) ? 0 : getCreatedept().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prescribemodelid=").append(prescribemodelid);
        sb.append(", prescribemodelname=").append(prescribemodelname);
        sb.append(", prescribeusage=").append(prescribeusage);
        sb.append(", prescribetype=").append(prescribetype);
        sb.append(", server=").append(server);
        sb.append(", usage=").append(usage);
        sb.append(", createman=").append(createman);
        sb.append(", createdept=").append(createdept);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}