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
    public Double findExpense(String expense_category, String start_date, String end_date, Long department_id) {
        return statisticMapper.findExpense(expense_category, start_date, end_date, department_id);
    }

    @Override
    public List<Statistic> ToFindExpense(String start_date, String end_date, String department_id) {
        return statisticMapper.ToFindExpense(start_date, end_date, department_id);
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
    public List<Department> findDeptType(String DeptType) {
        return statisticMapper.findDeptType(DeptType);
    }

    @Override
    public List<ExpenseAccount> findTitle() {
        return statisticMapper.findTitle();
    }

    @Override
    public List<Expense> findtest(String start_date, String end_date) {
        return statisticMapper.findtest(start_date, end_date);
    }
}
