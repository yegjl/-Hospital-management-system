package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Statisticsview;

import java.math.BigDecimal;
import java.util.List;

public interface StatisticsviewService {
    List<Statisticsview> selectAllPatient(int doctorid);
    int getCount(int doctorid);

    List<Statisticsview> selectByMedicalrecordid(String medicalrecordid);

    BigDecimal selectMoney(String medicalrecordid);

}
