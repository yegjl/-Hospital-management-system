package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticMapper {

    Double findExpense(@Param("expense_category") String expense_category, @Param("start_date") String start_date, @Param("end_date") String end_date, @Param("department_id") Long department_id);

    List<Statistic> ToFindExpense(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("department_id") String department_id);

    Double findGHFExpense(@Param("expense_category") String expense_category, @Param("start_date") String start_date, @Param("end_date") String end_date);

    Long findNum(@Param("department_id") String department_id, @Param("start_date") String start_date, @Param("end_date") String end_date);

    List<Department> findDeptType(@Param("DeptType") String DeptType);

    List<ExpenseAccount> findTitle();

    List<Expense> findtest(@Param("start_date") String start_date, @Param("end_date") String end_date);
}
