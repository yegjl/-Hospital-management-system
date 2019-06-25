package com.neusoft.ssm.service;

import java.util.Date;

public interface AssistService {

    boolean add(Long id, String medical_record_no, String expense_category, String expense_id, Long number, Double expense, Double real_expense, String pay_category, String pay_sign, String day_settle_sign, Date expense_date, String is_consume);

    boolean delete();

    Double ToFindExpense(String expense_category, String department_id);
}
