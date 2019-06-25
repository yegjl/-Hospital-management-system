package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Refund;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface RefundMapper {

    boolean add(@Param("medical_record_no") String medical_record_no, @Param("expense_category") String expense_category, @Param("expense_id") String expense_id, @Param("refund_number") Long refund_number, @Param("refund_expense") Double refund_expense, @Param("pay_category") String pay_category, @Param("day_settle_sign") String day_settle_sign, @Param("refund_date") Date refund_date);

    List<Refund> settleFind(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    List<Refund> find(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    boolean settle(@Param("id") Long id);

    void alterAUTO();
}
