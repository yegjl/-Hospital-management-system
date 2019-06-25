package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.ScheduleResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ScheduleResultMapper {

    boolean add(@Param("date_time") Date date_time, @Param("doctor_id") Long doctor_id, @Param("department_id") String department_id, @Param("register_level") String register_level, @Param("noon_level") String noon_level, @Param("limit_num") Integer limit_num, @Param("remain_num") Integer remain_num);

    List<ScheduleResult> findAll();

    List<ScheduleResult> findById(@Param("date_time") Date date_time);

    List<ScheduleResult> findByDept(@Param("date_time") Date date_time);

    List<ScheduleResult> findByDateAndCategory(@Param("date_time") Date date_time, @Param("register_level") String register_level);

    List<ScheduleResult> findByDateCategoryAndDept(@Param("date_time") Date date_time, @Param("register_level") String register_level, @Param("department_id") String department_id);

    List<ScheduleResult> findByDateAndDept(@Param("date_time") Date date_time, @Param("department_id") String department_id);

    ScheduleResult findByIdAndDate(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    boolean registerToNum(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    boolean backRegisterToNum(@Param("doctor_id") Long doctor_id, @Param("date_time") Date date_time);

    void deleteByDate(@Param("date_time") Date date);

    void alterAUTO();

}
