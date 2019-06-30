package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;
import com.neusoft.ssm.dao.StatisticMapper;
import com.neusoft.ssm.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    StatisticMapper statisticMapper;


    @Override
    public List<Statistic> findExpense(String start_date, String end_date, Long department_id) {
        return statisticMapper.findExpense(start_date, end_date, department_id);
    }

    @Override
    public List<Statistic> ToFindExpense(String start_date, String end_date, String department_id) {
        return statisticMapper.ToFindExpense(start_date, end_date, department_id);
    }

    @Override
    public List<Statistic> findDocExpense(String start_date, String end_date, Long doctor_id) {
        return statisticMapper.findDocExpense(start_date, end_date, doctor_id);
    }

    @Override
    public Double findGHFExpense(String expense_category, String start_date, String end_date) {
        return statisticMapper.findGHFExpense(expense_category, start_date, end_date);
    }

    @Override
    public Long findNum(String department_id, String start_date, String end_date) {
        return statisticMapper.findNum(department_id, start_date, end_date);
    }

    @Override
    public Long getNum(String start_date, String end_date, Long department_id) {
        return statisticMapper.getNum(start_date, end_date, department_id);
    }

    @Override
    public Long getDocNum(String start_date, String end_date, Long doctor_id) {
        return statisticMapper.getDocNum(start_date, end_date, doctor_id);
    }

    @Override
    public List<Department> findDeptType(String DeptType) {
        return statisticMapper.findDeptType(DeptType);
    }

    @Override
    public List<ExpenseAccount> findTitle() {
        return statisticMapper.findTitle();
    }

}
