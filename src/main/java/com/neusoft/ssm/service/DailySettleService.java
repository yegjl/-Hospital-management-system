package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.DailySettle;

import java.sql.Timestamp;
import java.util.List;

public interface DailySettleService {

    List<DailySettle> findAll();

    List<DailySettle> findAllByUser(Long user_id);

    DailySettle findById(Long id);

    List<DailySettle> findByDate(Timestamp startDate, Timestamp endDate);

    List<DailySettle> findByDateAndUser(Long user_id, Timestamp startDate, Timestamp endDate);

    Timestamp findMaxDate();

    List<DailySettle> findList();

    boolean addSettle(Long user_id, String start_date, String end_date, Double expense, String check_sign);

    boolean checkSettle(Long id, String check_sign, String check_date);

    void alterAUTO();

    int findIdByLoginName(String loginName);
}
