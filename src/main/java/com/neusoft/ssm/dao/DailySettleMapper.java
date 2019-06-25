package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.DailySettle;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DailySettleMapper {

    List<DailySettle> findAll();

    List<DailySettle> findAllByUser(@Param("user_id") Long user_id);

    DailySettle findById(@Param("id") Long id);

    List<DailySettle> findByDate(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    List<DailySettle> findByDateAndUser(@Param("user_id") Long user_id, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

    Timestamp findMaxDate();

    List<DailySettle> findList();

    boolean addSettle(@Param("user_id") Long user_id, @Param("start_date") String start_date, @Param("end_date") String end_date, @Param("expense") Double expense, @Param("check_sign") String check_sign);

    boolean checkSettle(@Param("id") Long id, @Param("check_sign") String check_sign, @Param("check_date") String check_date);

    void alterAUTO();
}
