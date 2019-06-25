package com.neusoft.ssm.bean;

import java.util.Date;

public class Assist {

    private Long id;
    private String medical_record_no;
    private String expense_category;
    private String expense_id;
    private Long number;
    private Double expense;
    private Double real_expense;
    private String pay_category;
    private String pay_sign;
    private String day_settle_sign;
    private Date expense_date;
    private String is_consume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedical_record_no() {
        return medical_record_no;
    }

    public void setMedical_record_no(String medical_record_no) {
        this.medical_record_no = medical_record_no;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }

    public String getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(String expense_id) {
        this.expense_id = expense_id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public Double getReal_expense() {
        return real_expense;
    }

    public void setReal_expense(Double real_expense) {
        this.real_expense = real_expense;
    }

    public String getPay_category() {
        return pay_category;
    }

    public void setPay_category(String pay_category) {
        this.pay_category = pay_category;
    }

    public String getPay_sign() {
        return pay_sign;
    }

    public void setPay_sign(String pay_sign) {
        this.pay_sign = pay_sign;
    }

    public String getDay_settle_sign() {
        return day_settle_sign;
    }

    public void setDay_settle_sign(String day_settle_sign) {
        this.day_settle_sign = day_settle_sign;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
    }

    public String getIs_consume() {
        return is_consume;
    }

    public void setIs_consume(String is_consume) {
        this.is_consume = is_consume;
    }
}
