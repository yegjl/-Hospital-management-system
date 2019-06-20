package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Diagnosis;

import java.util.List;

public interface DiagnosisDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Diagnosis record);

    int insertSelective(Diagnosis record);

    Diagnosis selectByPrimaryKey(Integer id);

    List<Diagnosis> selectAllBymedicalRecordNo(String medicalRecordNo);
    int updateByPrimaryKeySelective(Diagnosis record);

    int updateByPrimaryKey(Diagnosis record);
}