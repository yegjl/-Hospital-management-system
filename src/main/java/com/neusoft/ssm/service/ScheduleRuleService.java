package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.ScheduleRule;

import java.sql.Date;
import java.util.List;

public interface ScheduleRuleService {

    boolean add(Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num, Date operate_date);

    boolean update(Long id, Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num, Date operate_date);

    void deleteById(Long id);

    List<ScheduleRule> findAll();

    List<ScheduleRule> findByAll(String keyword);

    ScheduleRule findByIdAndDate(Long doctor_id, String week_time);

    void alterAUTO();

}
