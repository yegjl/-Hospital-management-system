package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.*;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordPage findById(Integer id);
    MedicalRecordPage findBymedicalRecordNo(String medicalRecordNo);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(MedicalRecordPage record);
    List<Disease> findallDisease();
    Disease findDiseaseById(Integer id);
    List<Diagnosis> findDiaAllBymedicalRecordNo(String medicalRecordNo);
    List<CommonDiagnosis> findAllCommonDiagnosis(Integer doctorid);

    int deleteCommonDiagnosis(Integer diagnosisid);
    int deletemu(Integer id);
    Diagnosis findDiagnosisByID(Integer id);
     int insertSelectiveDia(Diagnosis record);
     int updateDia(Diagnosis record);
    int deleteDia(Integer id);
    int deleteDiaByMedNo(String medicalRecordNo);
    List<MedicalRecordPageTemplate> getSet(Integer doctorid);
    MedicalRecordPageTemplate getSetByID(Integer id);
    int insertMedicalRecordPageTemplate(MedicalRecordPageTemplate record);
}
