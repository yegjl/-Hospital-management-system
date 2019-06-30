package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门诊工作量统计接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface StatisticMapper {

    /**
     * 根据科室id统计执行科室在某个日期区间内各中类型收费项目的合计金额
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param department_id 科室id
     * @return (List<Statistic>)
     */
    List<Statistic> findExpense(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("department_id") Long department_id);

    /**
     * 根据科室编码统计开单科室在某个日期区间内各中类型收费项目的合计金额列表
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param department_id 科室编码
     * @return (List<Statistic>)
     */
    List<Statistic> ToFindExpense(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("department_id") String department_id);

    /**
     * 根据医生id统计门诊医生在某个日期区间内各中类型收费项目的合计金额列表
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param doctor_id 医生id
     * @return (List<Statistic>)
     */
    List<Statistic> findDocExpense(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("doctor_id") Long doctor_id);

    /**
     * 统计门诊挂号费的合计金额
     * @Param expense_category 收费项目类型
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (Double)
     */
    Double findGHFExpense(@Param("expense_category") String expense_category, @Param("start_date") String start_date, @Param("end_date") String end_date);

    /**
     * 根据科室编码统计开单科室在某个日期区间内就诊人次
     * @Param department_id 科室编码
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (Long)
     */
    Long findNum(@Param("department_id") String department_id, @Param("start_date") String start_date, @Param("end_date") String end_date);

    /**
     * 根据科室id统计执行科室在某个日期区间内就诊人次
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param department_id 科室id
     * @return (Long)
     */
    Long getNum(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("department_id") Long department_id);

    /**
     * 根据医生id统计门诊医生在某个日期区间内就诊人次
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param doctor_id 医生id
     * @return (Long)
     */
    Long getDocNum(@Param("start_date") String start_date, @Param("end_date") String end_date, @Param("doctor_id") Long doctor_id);

    /**
     * 根据科室类型获取科室列表
     * @Param DeptType 科室类型
     * @return (List<Department>)
     */
    List<Department> findDeptType(@Param("DeptType") String DeptType);

    /**
     * 获取数据表格的表头
     * @return (List<ExpenseAccount>)
     */
    List<ExpenseAccount> findTitle();

}
