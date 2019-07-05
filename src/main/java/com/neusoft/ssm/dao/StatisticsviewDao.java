package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Statisticsview;
import com.neusoft.ssm.bean.StatisticsviewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticsviewDao {
    long countByExample(StatisticsviewExample example);

    int deleteByExample(StatisticsviewExample example);

    int insert(Statisticsview record);

    int insertSelective(Statisticsview record);

    List<Statisticsview> selectByExample(StatisticsviewExample example);

    int updateByExampleSelective(@Param("record") Statisticsview record, @Param("example") StatisticsviewExample example);

    int updateByExample(@Param("record") Statisticsview record, @Param("example") StatisticsviewExample example);

    List<Statisticsview> selectAllPatient(int doctorid);

    int getCount(int doctorid);

    List<Statisticsview> selectByMedicalrecordid(String medicalrecordid);
}