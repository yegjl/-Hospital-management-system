package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;

import java.util.List;

public interface StatisticService {

    //执行科室，科室id为Long主键
    List<Statistic> findExpense(String start_date, String end_date, Long department_id);

    //开单科室，科室id为String编码
    List<Statistic> ToFindExpense(String start_date, String end_date, String department_id);

    //门诊医生，医生id为Long主键
    List<Statistic> findDocExpense(String start_date, String end_date, Long doctor_id);

    //全科门诊
    Double findGHFExpense(String expense_category, String start_date, String end_date);

    //开单科室人次
    Long findNum(String department_id, String start_date, String end_date);

    //执行科室人次
    Long getNum(String start_date, String end_date, Long department_id);

    //门诊医生人次
    Long getDocNum(String start_date, String end_date, Long doctor_id);

    //获取科室类型
    List<Department> findDeptType(String DeptType);

    //获取表头
    List<ExpenseAccount> findTitle();

}
