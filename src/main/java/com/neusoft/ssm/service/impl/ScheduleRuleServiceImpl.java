package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.ScheduleRule;
import com.neusoft.ssm.dao.ScheduleRuleMapper;
import com.neusoft.ssm.service.ScheduleRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class ScheduleRuleServiceImpl implements ScheduleRuleService {

    @Autowired
    ScheduleRuleMapper scheduleRuleMapper;

    @Override
    public boolean add(Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num, Date operate_date) {
        return scheduleRuleMapper.add(doctor_id, week_time, register_level, noon_level, limit_num, operate_date);
    }

    @Override
    public boolean update(Long id, Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num, Date operate_date) {
        return scheduleRuleMapper.update(id, doctor_id, week_time, register_level, noon_level, limit_num, operate_date);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        scheduleRuleMapper.deleteById(id);
    }

    @Override
    @Transactional
    public List<ScheduleRule> findAll() {
        return scheduleRuleMapper.findAll();
    }

    @Override
    public List<ScheduleRule> findByAll(String keyword) {
        keyword = "%" + keyword + "%";
        return scheduleRuleMapper.findByAll(keyword);
    }

    @Override
    public ScheduleRule findByIdAndDate(Long doctor_id, String week_time) {
        return scheduleRuleMapper.findByIdAndDate(doctor_id, week_time);
    }

    @Override
    @Transactional
    public void alterAUTO() {
        scheduleRuleMapper.alterAUTO();
    }
}
