package com.neusoft.ssm.bean;

import java.util.Date;

public class Refund {

  private Long id;
  private String medical_record_no;
  private String expense_category;
  private String expense_id;
  private Long refund_number;
  private Double refund_expense;
  private String pay_category;
  private String day_settle_sign;
  private Date refund_date;

  private String name;
  private String expense_name;
  private String date;

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

  public Long getRefund_number() {
    return refund_number;
  }

  public void setRefund_number(Long refund_number) {
    this.refund_number = refund_number;
  }

  public Double getRefund_expense() {
    return refund_expense;
  }

  public void setRefund_expense(Double refund_expense) {
    this.refund_expense = refund_expense;
  }

  public String getDay_settle_sign() {
    return day_settle_sign;
  }

  public void setDay_settle_sign(String day_settle_sign) {
    this.day_settle_sign = day_settle_sign;
  }

  public Date getRefund_date() {
    return refund_date;
  }

  public void setRefund_date(Date refund_date) {
    this.refund_date = refund_date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExpense_name() {
    return expense_name;
  }

  public void setExpense_name(String expense_name) {
    this.expense_name = expense_name;
  }

  public String getPay_category() {
    return pay_category;
  }

  public void setPay_category(String pay_category) {
    this.pay_category = pay_category;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
