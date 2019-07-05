package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.DailySettle;
import com.neusoft.ssm.dao.DailySettleMapper;
import com.neusoft.ssm.service.DailySettleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DailySettleServiceImpl implements DailySettleService {

    @Autowired
    DailySettleMapper dailySettleMapper;

    @Override
    public List<DailySettle> findAll() {
        return dailySettleMapper.findAll();
    }

    @Override
    public List<DailySettle> findAllByUser(Long user_id) {
        return dailySettleMapper.findAllByUser(user_id);
    }

    @Override
    public DailySettle findById(Long id) {
        return dailySettleMapper.findById(id);
    }

    @Override
    public List<DailySettle> findByDate(Timestamp startDate, Timestamp endDate) {
        return dailySettleMapper.findByDate(startDate, endDate);
    }

    @Override
    public List<DailySettle> findByDateAndUser(Long user_id, Timestamp startDate, Timestamp endDate) {
        return dailySettleMapper.findByDateAndUser(user_id, startDate, endDate);
    }

    @Override
    public Timestamp findMaxDate() {
        return dailySettleMapper.findMaxDate();
    }

    @Override
    public List<DailySettle> findList() {
        return dailySettleMapper.findList();
    }

    @Override
    public boolean addSettle(Long user_id, String start_date, String end_date, Double expense, String check_sign) {
        return dailySettleMapper.addSettle(user_id, start_date, end_date, expense, check_sign);
    }

    @Override
    public boolean checkSettle(Long id, String check_sign, String check_date) {
        return dailySettleMapper.checkSettle(id, check_sign, check_date);
    }

    @Override
    public void alterAUTO() {
        dailySettleMapper.alterAUTO();
    }

    @Override
    public int findIdByLoginName(String loginName) {
        return dailySettleMapper.findIdByLoginName(loginName);
    }
}
