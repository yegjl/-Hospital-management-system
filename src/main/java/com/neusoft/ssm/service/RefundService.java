package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Refund;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface RefundService {

    boolean add(String medical_record_no, String expense_category, String expense_id, Long prescribe_id, Long refund_number, Double refund_expense, String pay_category, String day_settle_sign, Date refund_date);

    List<Refund> settleFind(Timestamp start_date, Timestamp end_date);

    List<Refund> find(Timestamp start_date, Timestamp end_date);

    boolean settle(Long id);

    void alterAUTO();
}
