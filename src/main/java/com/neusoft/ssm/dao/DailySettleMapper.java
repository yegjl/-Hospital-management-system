package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.DailySettle;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * 门诊日结接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface DailySettleMapper {

    /**
     * 获取全部日结信息列表
     * @return (List<DailySettle>)
     */
    List<DailySettle> findAll();

    /**
     * 按收费员id获取日结信息列表
     * @Param user_id 收费员id
     * @return (List<DailySettle>)
     */
    List<DailySettle> findAllByUser(@Param("user_id") Long user_id);

    /**
     * 按日结信息id获取一条信息
     * @Param id 日结信息id
     * @return (DailySettle)
     */
    DailySettle findById(@Param("id") Long id);

    /**
     * 按日期获取日结信息列表
     * @Param startDate 开始日期
     * @Param endDate 结束日期
     * @return (List<DailySettle>)
     */
    List<DailySettle> findByDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    /**
     * 按日期和收费员id获取日结信息列表
     * @Param user_id 收费员id
     * @Param startDate 开始日期
     * @Param endDate 结束日期
     * @return (List<DailySettle>)
     */
    List<DailySettle> findByDateAndUser(@Param("user_id") Long user_id, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    /**
     * 获取上一条日结信息的时间
     * @return (Timestamp)
     */
    Timestamp findMaxDate();

    /**
     * 获取每一名收费员最后一次日结信息
     * @return (List<DailySettle>)
     */
    List<DailySettle> findList();

    /**
     * 收费员日结
     * @Param user_id 收费员id
     * @Param start_date 开始日期
     * @Param end_date 结束日期
     * @Param expense 金额
     * @Param check_sign 核对标志
     * @return (boolean)
     */
    boolean addSettle(@Param("user_id") Long user_id, @Param("start_date") String start_date, @Param("end_date") String end_date, @Param("expense") Double expense, @Param("check_sign") String check_sign);

    /**
     * 门诊财务核对日结
     * @Param id 日结信息条目的id
     * @Param check_sign 核对标志
     * @Param check_date 核对日期
     * @return (boolean)
     */
    boolean checkSettle(@Param("id") Long id, @Param("check_sign") String check_sign, @Param("check_date") String check_date);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();
}
