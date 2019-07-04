package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Statisticsview;
import com.neusoft.ssm.dao.PrescribeDao;
import com.neusoft.ssm.dao.StatisticsviewDao;
import com.neusoft.ssm.service.StatisticsviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StatisticsviewServiceImpl implements StatisticsviewService {
    @Autowired
    StatisticsviewDao statisticsviewDao;

    @Autowired
    PrescribeDao prescribeDao;

    @Override
    public List<Statisticsview> selectAllPatient(int doctorid) {
        return statisticsviewDao.selectAllPatient(doctorid);
    }

    @Override
    public int getCount(int doctorid) {
        return statisticsviewDao.getCount(doctorid);
    }

    @Override
    public List<Statisticsview> selectByMedicalrecordid(String medicalrecordid) {
        return statisticsviewDao.selectByMedicalrecordid(medicalrecordid);
    }

    @Override
    public BigDecimal selectMoney(String medicalrecordid) {
        return prescribeDao.selectMoney(medicalrecordid);
    }
}
