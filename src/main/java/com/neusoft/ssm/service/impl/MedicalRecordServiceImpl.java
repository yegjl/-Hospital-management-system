package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dao.CommonDiagnosisDao;
import com.neusoft.ssm.dao.DiagnosisDao;
import com.neusoft.ssm.dao.DiseaseDao;
import com.neusoft.ssm.dao.MedicalRecordPageDao;
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

    @Override
    public MedicalRecordPage findById(Integer id) {
        return medicalRecordPageDao.selectByPrimaryKey(id);
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
    public Diagnosis findDiagnosisByID(Integer id) {
        return diagnosisDao.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelectiveDia(Diagnosis record) {
        return diagnosisDao.insertSelective(record);
    }

}
