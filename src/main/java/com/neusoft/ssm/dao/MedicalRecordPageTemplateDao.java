package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.MedicalRecordPageTemplate;

import java.util.List;

public interface MedicalRecordPageTemplateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecordPageTemplate record);

    int insertSelective(MedicalRecordPageTemplate record);

    MedicalRecordPageTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicalRecordPageTemplate record);

    int updateByPrimaryKey(MedicalRecordPageTemplate record);
    List<MedicalRecordPageTemplate> selectAll();
}