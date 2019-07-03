package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Drugs;
import com.neusoft.ssm.bean.Expense;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();

    List<Expense> findByRecord(String medical_record_no);

    Expense findById(Long id);

    Expense findByRecordAndDate(String medical_record_no, String expense_id, Date expense_date);

    List<Expense> search(String medical_record_no, Date startDate, Date endDate);

    boolean charge(Long id, Double real_expense, String pay_category, String pay_sign, Date expense_date);

    boolean refund(Long id, Long number, Double expense, Double real_expense, String pay_sign, Date expense_date);

    boolean delete(String medical_record_no, String expense_id, Date expense_date);

    boolean registerExpense(String medical_record_no, String expense_category, String expense_id, Long prescribe_id, Long number, Double expense, Double real_expense, String pay_category, String pay_sign, String day_settle_sign, Date expense_date, String is_consume);

    List<Expense> SettleFind(Timestamp start_date, Timestamp end_date);

    List<Expense> find(Timestamp start_date, Timestamp end_date);

    boolean settle(Long id);

    Drugs findDrugByCode(String ID);

    Integer findRefundDrugNum(String medical_record_no, String expense_id, Long prescribe_id);

    void alterAUTO();

    Expense getExpenceById(Long id);

    Integer getInfoId(String medical_record_no, String itemcode);

    void updateStatus(Integer examInfoId);
}
