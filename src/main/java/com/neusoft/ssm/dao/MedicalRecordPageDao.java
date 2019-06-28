package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.MedicalRecordPage;

public interface MedicalRecordPageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecordPage record);

    int insertSelective(MedicalRecordPage record);

    MedicalRecordPage selectByPrimaryKey(Integer id);

    MedicalRecordPage selectBymedicalRecordNo(String medicalRecordNo);

    int updateByPrimaryKeySelective(MedicalRecordPage record);

    int updateByPrimaryKey(MedicalRecordPage record);
}