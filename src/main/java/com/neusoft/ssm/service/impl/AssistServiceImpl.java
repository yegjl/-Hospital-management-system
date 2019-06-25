package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.dao.AssistMapper;
import com.neusoft.ssm.service.AssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssistServiceImpl implements AssistService {

    @Autowired
    AssistMapper assistMapper;


    @Override
    public boolean add(Long id, String medical_record_no, String expense_category, String expense_id, Long number, Double expense, Double real_expense, String pay_category, String pay_sign, String day_settle_sign, Date expense_date, String is_consume) {
        return assistMapper.add(id, medical_record_no, expense_category, expense_id, number, expense, real_expense, pay_category, pay_sign, day_settle_sign, expense_date, is_consume);
    }

    @Override
    public boolean delete() {
        return assistMapper.delete();
    }

    @Override
    public Double ToFindExpense(String expense_category, String department_id) {
        return assistMapper.ToFindExpense(expense_category, department_id);
    }
}
