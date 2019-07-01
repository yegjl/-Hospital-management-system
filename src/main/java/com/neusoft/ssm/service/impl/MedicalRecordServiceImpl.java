package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dao.*;
import com.neusoft.ssm.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordPageDao medicalRecordPageDao;
    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    DiagnosisDao diagnosisDao;
    @Autowired
    CommonDiagnosisDao commonDiagnosisDao;
    @Autowired
    MedicalRecordPageTemplateDao medicalRecordPageTemplateDao;

    @Override
    public MedicalRecordPage findById(Integer id) {
        return medicalRecordPageDao.selectByPrimaryKey(id);
    }

    @Override
    public MedicalRecordPage findBymedicalRecordNo(String medicalRecordNo) {
        return medicalRecordPageDao.selectBymedicalRecordNo(medicalRecordNo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return medicalRecordPageDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(MedicalRecordPage record) {
        return medicalRecordPageDao.insertSelective(record);
    }

    @Override
    public List<Disease> findallDisease() {
        return diseaseDao.selectByExample(new DiseaseExample());
    }

    @Override
    public Disease findDiseaseById(Integer id) {
        return diseaseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Diagnosis> findDiaAllBymedicalRecordNo(String medicalRecordNo) {
        return diagnosisDao.selectAllBymedicalRecordNo(medicalRecordNo);
    }


    @Override
    public List<CommonDiagnosis> findAllCommonDiagnosis(Integer doctorid) {
        return commonDiagnosisDao.selectAll(doctorid);
    }
    @Override
    public int deleteCommonDiagnosis(Integer diagnosisid) {
        return commonDiagnosisDao.deleteBydiagnosisid(diagnosisid);
    }
    @Override
    public Diagnosis findDiagnosisByID(Integer id) {
        return diagnosisDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelectiveDia(Diagnosis record) {
        return diagnosisDao.insertSelective(record);
    }

    @Override
    public int updateDia(Diagnosis record) {
        return diagnosisDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteDia(Integer id) {
        return diagnosisDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteDiaByMedNo(String medicalRecordNo) {
        return diagnosisDao.deleteByMedNo(medicalRecordNo);
    }

    @Override
    public List<MedicalRecordPageTemplate> getSet(Integer doctorid) {
        return medicalRecordPageTemplateDao.selectAllBydoctorid(doctorid);
    }

    @Override
    public MedicalRecordPageTemplate getSetByID(Integer id) {
        return medicalRecordPageTemplateDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertMedicalRecordPageTemplate(MedicalRecordPageTemplate record) {
        return medicalRecordPageTemplateDao.insertSelective(record);
    }

}
