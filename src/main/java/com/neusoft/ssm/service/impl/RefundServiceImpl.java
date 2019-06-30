package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Refund;
import com.neusoft.ssm.dao.RefundMapper;
import com.neusoft.ssm.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    RefundMapper refundMapper;

    @Override
    public boolean add(String medical_record_no, String expense_category, String expense_id, Long prescribe_id, Long refund_number, Double refund_expense, String pay_category, String day_settle_sign, Date refund_date) {
        return refundMapper.add(medical_record_no, expense_category, expense_id, prescribe_id, refund_number, refund_expense, pay_category, day_settle_sign, refund_date);
    }

    @Override
    public List<Refund> settleFind(Timestamp start_date, Timestamp end_date) {
        return refundMapper.settleFind(start_date, end_date);
    }

    @Override
    public List<Refund> find(Timestamp start_date, Timestamp end_date) {
        return refundMapper.find(start_date, end_date);
    }

    @Override
    public boolean settle(Long id) {
        return refundMapper.settle(id);
    }

    @Override
    public void alterAUTO() {
        refundMapper.alterAUTO();
    }
}
