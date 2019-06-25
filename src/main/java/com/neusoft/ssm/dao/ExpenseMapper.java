package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Expense;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ExpenseMapper {

    List<Expense> findAll();

    List<Expense> findByRecord(@Param("medical_record_no") String medical_record_no);

    Expense findByRecordAndDate(@Param("medical_record_no") String medical_record_no, @Param("expense_id") String expense_id, @Param("expense_date") Date expense_date);

    Expense findById(@Param("id") Long id);

    List<Expense> search(@Param("medical_record_no") String medical_record_no, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    boolean charge(@Param("id") Long id, @Param("real_expense") Double real_expense, @Param("pay_category") String pay_category, @Param("pay_sign") String pay_sign, @Param("expense_date") Date expense_date);

    boolean refund(@Param("id") Long id, @Param("number") Long number, @Param("expense") Double expense, @Param("real_expense") Double real_expense, @Param("pay_sign") String pay_sign, @Param("expense_date") Date expense_date);

    boolean delete(@Param("medical_record_no") String medical_record_no, @Param("expense_id") String expense_id, @Param("expense_date") Date expense_date);

    boolean registerExpense(@Param("medical_record_no") String medical_record_no, @Param("expense_category") String expense_category, @Param("expense_id") String expense_id, @Param("number") Long number, @Param("expense") Double expense, @Param("real_expense") Double real_expense, @Param("pay_category") String pay_category, @Param("pay_sign") String pay_sign, @Param("day_settle_sign") String day_settle_sign, @Param("expense_date") Date expense_date, @Param("is_consume") String is_consume);

    List<Expense> SettleFind(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    List<Expense> find(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    boolean settle(@Param("id") Long id);

    void alterAUTO();

}
