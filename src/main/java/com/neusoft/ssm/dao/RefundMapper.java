package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Refund;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 退费记录接口类
 * @author Nebula
 * @version 1.20 2019/06/27
 * */

public interface RefundMapper {

    /**
     * 增加一条退费记录
     * @Param medical_record_no 病历号
     * @Param expense_category 收费项目类型
     * @Param expense_id 收费项目id
     * @Param refund_number 退费数量
     * @Param pay_category 付款类型
     * @Param day_settle_sign 日结标志
     * @Param refund_date 退费日期
     * @return (boolean)
     */
    boolean add(@Param("medical_record_no") String medical_record_no, @Param("expense_category") String expense_category, @Param("expense_id") String expense_id, @Param("prescribe_id") Long prescribe_id, @Param("refund_number") Long refund_number, @Param("refund_expense") Double refund_expense, @Param("pay_category") String pay_category, @Param("day_settle_sign") String day_settle_sign, @Param("refund_date") Date refund_date);

    /**
     * 按日期区间获取未日结的退费记录
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (List<Refund>)
     */
    List<Refund> settleFind(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    /**
     * 按日期区间获取已日结的退费记录
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (List<Refund>)
     */
    List<Refund> find(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    /**
     * 按id将日结标志改为1
     * @Param id 收费记录id
     * @return (boolean)
     */
    boolean settle(@Param("id") Long id);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();
}
