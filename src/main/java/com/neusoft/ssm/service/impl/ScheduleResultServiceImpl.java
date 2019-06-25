package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.ScheduleResult;
import com.neusoft.ssm.dao.ScheduleResultMapper;
import com.neusoft.ssm.service.ScheduleResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleResultServiceImpl implements ScheduleResultService {

    @Autowired
    ScheduleResultMapper scheduleResultMapper;

    @Override
    public boolean add(Date date_time, Long doctor_id, String department_id, String register_level, String noon_level, Integer limit_num ,Integer remain_num) {
        return scheduleResultMapper.add(date_time, doctor_id, department_id, register_level, noon_level, limit_num, remain_num);
    }

    @Override
    public List<ScheduleResult> findAll() {
        return scheduleResultMapper.findAll();
    }

    @Override
    public List<ScheduleResult> findById(Date date_time) {
        return scheduleResultMapper.findById(date_time);
    }

    @Override
    public List<ScheduleResult> findByDept(Date date_time) {
        return scheduleResultMapper.findByDept(date_time);
    }

    @Override
    public List<ScheduleResult> findByDateAndCategory(Date date_time, String register_level) {
        return scheduleResultMapper.findByDateAndCategory(date_time, register_level);
    }

    @Override
    public List<ScheduleResult> findByDateCategoryAndDept(Date date_time, String register_level, String department_id) {
        return scheduleResultMapper.findByDateCategoryAndDept(date_time, register_level, department_id);
    }

    @Override
    public List<ScheduleResult> findByDateAndDept(Date date_time, String department_id) {
        return scheduleResultMapper.findByDateAndDept(date_time, department_id);
    }

    @Override
    public ScheduleResult findByIdAndDate(Long doctor_id, Date date_time) {
        return scheduleResultMapper.findByIdAndDate(doctor_id, date_time);
    }

    @Override
    public boolean registerToNum(Long doctor_id, Date date_time) {
        return scheduleResultMapper.registerToNum(doctor_id, date_time);
    }

    @Override
    public boolean backRegisterToNum(Long doctor_id, Date date_time) {
        return scheduleResultMapper.backRegisterToNum(doctor_id, date_time);
    }

    @Override
    public void deleteByDate(Date date) {
        scheduleResultMapper.deleteByDate(date);
    }

    @Override
    @Transactional
    public void alterAUTO() {
        scheduleResultMapper.alterAUTO();
    }
}
