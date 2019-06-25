package com.neusoft.ssm.bean;

public class Statistic {

    private String name; //科室名或医生名
    private Long num; //看诊人次
    private Double XYF; //西药费 XYF
    private Double ZCHYF; //中成药 ZCHYF
    private Double ZCYF; //中草药 ZCYF
    private Double GHF; //挂号费 GHF
    private Double ZLF; //诊疗费 ZLF
    private Double JCF; //检查费 JCF
    private Double JYF; //检验费 JYF
    private Double CLF; //材料费 CLF
    private Double CZF; //处置费 CZF
    private Double MZF; //麻醉费 MZF
    private Double MZYF; //麻醉药费 MZYF
    private Double MZSSF; //手术费 SSF
    private Double QT; //其他费用 QT

    private String account_code;
    private Double total_expense;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Double getXYF() {
        return XYF;
    }

    public void setXYF(Double XYF) {
        this.XYF = XYF;
    }

    public Double getZCHYF() {
        return ZCHYF;
    }

    public void setZCHYF(Double ZCHYF) {
        this.ZCHYF = ZCHYF;
    }

    public Double getZCYF() {
        return ZCYF;
    }

    public void setZCYF(Double ZCYF) {
        this.ZCYF = ZCYF;
    }

    public Double getGHF() {
        return GHF;
    }

    public void setGHF(Double GHF) {
        this.GHF = GHF;
    }

    public Double getZLF() {
        return ZLF;
    }

    public void setZLF(Double ZLF) {
        this.ZLF = ZLF;
    }

    public Double getJCF() {
        return JCF;
    }

    public void setJCF(Double JCF) {
        this.JCF = JCF;
    }

    public Double getJYF() {
        return JYF;
    }

    public void setJYF(Double JYF) {
        this.JYF = JYF;
    }

    public Double getCLF() {
        return CLF;
    }

    public void setCLF(Double CLF) {
        this.CLF = CLF;
    }

    public Double getCZF() {
        return CZF;
    }

    public void setCZF(Double CZF) {
        this.CZF = CZF;
    }

    public Double getMZF() {
        return MZF;
    }

    public void setMZF(Double MZF) {
        this.MZF = MZF;
    }

    public Double getMZYF() {
        return MZYF;
    }

    public void setMZYF(Double MZYF) {
        this.MZYF = MZYF;
    }

    public Double getMZSSF() {
        return MZSSF;
    }

    public void setMZSSF(Double MZSSF) {
        this.MZSSF = MZSSF;
    }

    public Double getQT() {
        return QT;
    }

    public void setQT(Double QT) {
        this.QT = QT;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public Double getTotal_expense() {
        return total_expense;
    }

    public void setTotal_expense(Double total_expense) {
        this.total_expense = total_expense;
    }
}
