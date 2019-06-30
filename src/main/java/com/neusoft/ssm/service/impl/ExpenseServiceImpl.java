package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Drugs;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.dao.ExpenseMapper;
import com.neusoft.ssm.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseMapper expenseMapper;

    @Override
    public List<Expense> findAll() {
        return expenseMapper.findAll();
    }

    @Override
    public List<Expense> findByRecord(String medical_record_no) {
        return expenseMapper.findByRecord(medical_record_no);
    }

    @Override
    public Expense findById(Long id) {
        return expenseMapper.findById(id);
    }

    @Override
    public Expense findByRecordAndDate(String medical_record_no, String expense_id, Date expense_date) {
        return expenseMapper.findByRecordAndDate(medical_record_no, expense_id, expense_date);
    }

    @Override
    public List<Expense> search(String medical_record_no, Date startDate, Date endDate) {
        return expenseMapper.search(medical_record_no, startDate, endDate);
    }

    @Override
    public boolean charge(Long id, Double real_expense, String pay_category, String pay_sign, Date expense_date) {
        return expenseMapper.charge(id, real_expense, pay_category, pay_sign, expense_date);
    }

    @Override
    public boolean refund(Long id, Long number, Double expense, Double real_expense, String pay_sign, Date expense_date) {
        return expenseMapper.refund(id, number, expense, real_expense, pay_sign, expense_date);
    }

    @Override
    public boolean delete(String medical_record_no, String expense_id, Date expense_date) {
        return expenseMapper.delete(medical_record_no, expense_id, expense_date);
    }

    @Override
    public boolean registerExpense(String medical_record_no, String expense_category, String expense_id, Long prescribe_id, Long number, Double expense, Double real_expense, String pay_category, String pay_sign, String day_settle_sign, Date expense_date, String is_consume) {
        return expenseMapper.registerExpense(medical_record_no, expense_category, expense_id, prescribe_id, number, expense, real_expense, pay_category, pay_sign, day_settle_sign, expense_date, is_consume);
    }

    @Override
    public List<Expense> SettleFind(Timestamp start_date, Timestamp end_date) {
        return expenseMapper.SettleFind(start_date, end_date);
    }

    @Override
    public List<Expense> find(Timestamp start_date, Timestamp end_date) {
        return expenseMapper.find(start_date, end_date);
    }

    @Override
    public boolean settle(Long id) {
        return expenseMapper.settle(id);
    }

    @Override
    public Drugs findDrugByCode(String ID) {
        return expenseMapper.findDrugByCode(ID);
    }

    @Override
    public Integer findRefundDrugNum(String medical_record_no, String expense_id, Long prescribe_id) {
        return expenseMapper.findRefundDrugNum(medical_record_no, expense_id, prescribe_id);
    }

    @Override
    public void alterAUTO() {
        expenseMapper.alterAUTO();
    }
}
