package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.CommonDiagnosis;

import java.util.List;

public interface CommonDiagnosisDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonDiagnosis record);

    int insertSelective(CommonDiagnosis record);

    CommonDiagnosis selectByPrimaryKey(Integer id);
    List<CommonDiagnosis> selectAll(Integer doctorid);
    int updateByPrimaryKeySelective(CommonDiagnosis record);

    int updateByPrimaryKey(CommonDiagnosis record);

    int deleteBydiagnosisid(Integer diagnosisid);
}