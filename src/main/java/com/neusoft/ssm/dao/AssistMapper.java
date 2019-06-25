package com.neusoft.ssm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AssistMapper {

    boolean add(@Param("id") Long id, @Param("medical_record_no") String medical_record_no, @Param("expense_category") String expense_category, @Param("expense_id") String expense_id, @Param("number") Long number, @Param("expense") Double expense, @Param("real_expense") Double real_expense, @Param("pay_category") String pay_category, @Param("pay_sign") String pay_sign, @Param("day_settle_sign") String day_settle_sign, @Param("expense_date") Date expense_date, @Param("is_consume") String is_consume);

    boolean delete();

    Double ToFindExpense(@Param("expense_category") String expense_category, @Param("department_id") String department_id);
}
