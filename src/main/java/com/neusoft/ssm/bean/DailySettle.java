package com.neusoft.ssm.bean;

import java.sql.Timestamp;

public class DailySettle {

  private Long id;
  private Long user_id;
  private Timestamp startDate;
  private Timestamp endDate;
  private Double expense;
  private String check_sign;
  private String check_date;

  private String username;
  private String start_date;
  private String end_date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }


  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }


  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }


  public Double getExpense() {
    return expense;
  }

  public void setExpense(Double expense) {
    this.expense = expense;
  }

  public String getCheck_sign() {
    return check_sign;
  }

  public void setCheck_sign(String check_sign) {
    this.check_sign = check_sign;
  }

  public String getCheck_date() {
    return check_date;
  }

  public void setCheck_date(String check_date) {
    this.check_date = check_date;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getStart_date() {
    return start_date;
  }

  public void setStart_date(String start_date) {
    this.start_date = start_date;
  }

  public String getEnd_date() {
    return end_date;
  }

  public void setEnd_date(String end_date) {
    this.end_date = end_date;
  }

}
