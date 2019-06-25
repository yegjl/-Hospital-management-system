package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;

import java.util.List;

public interface StatisticService {

    //执行科室，科室id为Long主键
    Double findExpense(String expense_category, String start_date, String end_date, Long department_id);

    //开单科室，科室id为String编码
    List<Statistic> ToFindExpense(String start_date, String end_date, String department_id);

    //全科门诊
    Double findGHFExpense(String expense_category, String start_date, String end_date);

    Long findNum(String department_id, String start_date, String end_date);

    List<Department> findDeptType(String DeptType);

    List<ExpenseAccount> findTitle();

    List<Expense> findtest(String start_date, String end_date);
}
