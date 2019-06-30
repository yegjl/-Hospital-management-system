package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.ScheduleResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * 排班表接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface ScheduleResultMapper {

    /**
     * 增加排班记录
     * @Param date_time 日期
     * @Param doctor_id 医生id
     * @Param department_id 科室id
     * @Param register_level 号别
     * @Param noon_level 午别
     * @Param limit_num 排班限额
     * @Param remain_num 剩余号数
     * @return (boolean)
     */
    boolean add(@Param("date_time") Date date_time, @Param("doctor_id") Long doctor_id, @Param("department_id") String department_id, @Param("register_level") String register_level, @Param("noon_level") String noon_level, @Param("limit_num") Integer limit_num, @Param("remain_num") Integer remain_num);

    /**
     * 获取全部排班信息列表
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findAll();

    /**
     * 按日期获取参与排班的医生列表
     * @Param date_time 日期
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findById(@Param("date_time") Date date_time);

    /**
     * 按日期获取参与排班的科室列表
     * @Param date_time 日期
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findByDept(@Param("date_time") Date date_time);

    /**
     * 按日期和号别获取排班信息
     * @Param date_time 日期
     * @Param register_level 号别
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findByDateAndCategory(@Param("date_time") Date date_time, @Param("register_level") String register_level);

    /**
     * 按日期、号别和科室id获取排班信息
     * @Param date_time 日期
     * @Param register_level 号别
     * @Param department_id 科室id
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findByDateCategoryAndDept(@Param("date_time") Date date_time, @Param("register_level") String register_level, @Param("department_id") String department_id);

    /**
     * 按日期和科室id获取排班信息
     * @Param date_time 日期
     * @Param department_id 科室id
     * @return (List<ScheduleResult>)
     */
    List<ScheduleResult> findByDateAndDept(@Param("date_time") Date date_time, @Param("department_id") String department_id);

    /**
     * 按日期和医生id获取排班信息，用于限制医生一天只能参与一次排班
     * @Param date_time 日期
     * @Param department_id 科室id
     * @return (List<ScheduleResult>)
     */
    ScheduleResult findByIdAndDate(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    /**
     * 挂号时医生剩余号数减一
     * @Param doctor_id 医生id
     * @Param date_time 日期
     * @return (boolean)
     */
    boolean registerToNum(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    /**
     * 退号时医生剩余号数加一
     * @Param doctor_id 医生id
     * @Param date_time 日期
     * @return (boolean)
     */
    boolean backRegisterToNum(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    /**
     * 删除指定日期的排班信息
     * @Param date_time 日期
     */
    void deleteByDate(@Param("date_time") Date date);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();

}
