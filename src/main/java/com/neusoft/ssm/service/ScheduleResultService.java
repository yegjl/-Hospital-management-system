package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.ScheduleResult;

import java.util.Date;
import java.util.List;

public interface ScheduleResultService {

    boolean add(Date date_time, Long doctor_id, String department_id, String register_level, String noon_level, Integer limit_num, Integer remain_num);

    List<ScheduleResult> findAll();

    List<ScheduleResult> findById(Date date_time);

    List<ScheduleResult> findByDept(Date date_time);

    List<ScheduleResult> findByDateAndCategory(Date date_time, String register_level);

    List<ScheduleResult> findByDateCategoryAndDept(Date date_time, String register_level, String department_id);

    List<ScheduleResult> findByDateAndDept(Date date_time, String department_id);

    ScheduleResult findByIdAndDate(Long doctor_id, Date date_time);

    boolean registerToNum(Long doctor_id, Date date_time);

    boolean backRegisterToNum(Long doctor_id, Date date_time);

    void deleteByDate(Date date);

    void alterAUTO();
}
