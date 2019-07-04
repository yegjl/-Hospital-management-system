package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Dispense;
import com.neusoft.ssm.bean.Drugs;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.ExpenseExample;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 收费退费接口类
 * @author Nebula
 * @version 1.30 2019/06/29
 * */

public interface ExpenseMapper {
    long countByExample(ExpenseExample example);

    int deleteByExample(ExpenseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Expense record);

    int insertSelective(Expense record);

    List<Expense> selectByExample(ExpenseExample example);

    Expense selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByExample(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);

    /**
     * 获取全部收费信息列表
     * @return (List<Expense>)
     */
    List<Expense> findAll();

    /**
     * 按病历号获取收费信息列表
     * @Param medical_record_no 病历号
     * @return (List<Expense>)
     */
    List<Expense> findByRecord(@Param("medical_record_no") String medical_record_no);

    /**
     * 按病历号、收费项目id和日期获取收费信息
     * @Param medical_record_no 病历号
     * @Param expense_id 收费项目id
     * @Param expense_date 收费日期
     * @return (Expense)
     */
    Expense findByRecordAndDate(@Param("medical_record_no") String medical_record_no, @Param("expense_id") String expense_id, @Param("expense_date") Date expense_date);

    /**
     * 按收费记录id获取收费信息
     * @Param id 收费记录id
     * @return (Expense)
     */
    Expense findById(@Param("id") Long id);

    /**
     * 按病历号和日期区间获取收费信息
     * @Param medical_record_no 病历号
     * @Param startDate 开始日期
     * @Param endDate 结束日期
     * @return (List<Expense>)
     */
    List<Expense> search(@Param("medical_record_no") String medical_record_no, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * 收费
     * @Param id 收费记录id
     * @Param real_expense 实付金额
     * @Param pay_category 付款方式
     * @Param pay_sign 付款标志
     * @Param expense_date 付款日期
     * @return (boolean)
     */
    boolean charge(@Param("id") Long id, @Param("real_expense") Double real_expense, @Param("pay_category") String pay_category, @Param("pay_sign") String pay_sign, @Param("expense_date") Date expense_date);

    /**
     * 退费
     * @Param id 收费记录id
     * @Param number 退费后剩余数量
     * @Param expense 退费后应付金额
     * @Param real_expense 退费后实付金额
     * @Param pay_sign 付款标志
     * @Param expense_date 付款日期
     * @return (boolean)
     */
    boolean refund(@Param("id") Long id, @Param("number") Long number, @Param("expense") Double expense, @Param("real_expense") Double real_expense, @Param("pay_sign") String pay_sign, @Param("expense_date") Date expense_date);

    /**
     * 退号后删除挂号费收费记录
     * @Param medical_record_no 病历号
     * @Param expense_id 收费项目id
     * @Param expense_date 操作日期
     * @return (boolean)
     */
    boolean delete(@Param("medical_record_no") String medical_record_no, @Param("expense_id") String expense_id, @Param("expense_date") Date expense_date);

    /**
     * 增加挂号费记录
     * @Param medical_record_no 病历号
     * @Param expense_category 收费项目类型
     * @Param expense_id 收费项目id
     * @Param number 熟练
     * @Param expense 应付金额
     * @Param real_expense 实付金额
     * @Param pay_category 付款方式
     * @Param pay_sign 付款标志
     * @Param day_settle_sign 日结标志
     * @Param expense_date 操作日期
     * @Param is_consume 是否消费
     * @return (boolean)
     */
    boolean registerExpense(@Param("medical_record_no") String medical_record_no, @Param("expense_category") String expense_category, @Param("expense_id") String expense_id, @Param("prescribe_id") Long prescribe_id, @Param("number") Long number, @Param("expense") Double expense, @Param("real_expense") Double real_expense, @Param("pay_category") String pay_category, @Param("pay_sign") String pay_sign, @Param("day_settle_sign") String day_settle_sign, @Param("expense_date") Date expense_date, @Param("is_consume") String is_consume);

    /**
     * 按日期区间查找未日结的收费记录列表
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (List<Expense>)
     */
    List<Expense> SettleFind(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    /**
     * 按日期区间查找已日结的收费记录列表
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @return (List<Expense>)
     */
    List<Expense> find(@Param("start_date") Timestamp start_date, @Param("end_date") Timestamp end_date);

    /**
     * 按id将日结标志改为1
     * @Param id 收费记录id
     * @return (boolean)
     */
    boolean settle(@Param("id") Long id);

    /**
     * 按code查询药品信息
     * @Param DrugsCode 药品编码
     * @return (Drugs)
     */
    Drugs findDrugByCode(@Param("ID") String ID);

    /**
     * 查询退药数量
     * @Param medical_record_no 病历号
     * @Param expense_id 收费项目id
     * @Param prescribe_id 处方id
     * @return (Inter)
     */
    Integer findRefundDrugNum(@Param("medical_record_no") String medical_record_no, @Param("expense_id") String expense_id, @Param("prescribe_id") Long prescribe_id);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();


    Expense getExpenceById(Long id);

    Integer getInfoId(String medical_record_no, String itemcode);

    void updateStatus(Integer examInfoId);

    String getPatientName(String medical_record_no);

    int getDispenseNum(String medical_record_no);

    void insertDispense(Dispense dispense);

    int getDoctorID(String medical_record_no);

}
