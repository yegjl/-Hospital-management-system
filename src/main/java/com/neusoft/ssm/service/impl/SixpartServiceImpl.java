package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dao.SixpartoneMapper;
import com.neusoft.ssm.service.SixpartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SixpartServiceImpl implements SixpartService {

    @Autowired
    SixpartoneMapper sixpartoneMapper;

    @Override
    public List<Sixpartone> getPro() {
        return sixpartoneMapper.getPro();
    }

    @Override
    public List<Sixpartone> getPro1(String medical_record_no, String patient_name) {
        return sixpartoneMapper.getPro1(medical_record_no,patient_name);
    }

    @Override
    public Integer findExamInfoId(String s, String s1) {
        return sixpartoneMapper.findExamInfoId(s,s1);
    }

    @Override
    public void updateStatus(int i1) {
        sixpartoneMapper.updateStatus(i1);
    }

    @Override
    public List<Drugs> getdrugs() {
        return sixpartoneMapper.getdrugs();
    }

    @Override
    public Integer getExamCheckId(String medical_record_no, String itemname) {
        return sixpartoneMapper.getExamCheckId(medical_record_no,itemname);
    }

    @Override
    public Integer addInfo(ExamcheckInfo examcheckInfo) {
        return sixpartoneMapper.addInfo(examcheckInfo);
    }

    @Override
    public Integer findIdByName(String itemname) {
        return sixpartoneMapper.findIdByName(itemname);
    }

    @Override
    public String getMedNameById(Integer idByName) {
        return sixpartoneMapper.getMedNameById(idByName);
    }

    @Override
    public Integer getResultId(int i1) {
        return sixpartoneMapper.getResultId(i1);
    }

    @Override
    public Integer addResult(ExamcheckResult examcheckResult) {
        return sixpartoneMapper.addResult(examcheckResult);
    }

    @Override
    public void addResultPic(ExamcheckResultPic examcheckResultPic) {
        sixpartoneMapper.addResultPic(examcheckResultPic);
    }

    @Override
    public void updateResult(Integer resultId, String suojian, String advice) {
        sixpartoneMapper.updateResult(resultId,suojian,advice);
    }

    @Override
    public Integer getResultIdNum(int i1) {
        return sixpartoneMapper.getResultIdNum(i1);
    }

    @Override
    public void updateStatus1(int i1) {
        sixpartoneMapper.updateStatus1(i1);
    }

    @Override
    public List<ExamcheckResultPic> getPicsById(int i2) {
        return sixpartoneMapper.getPicsById(i2);
    }

    @Override
    public ExamcheckResult getResultByInfoId(int i1) {
        return sixpartoneMapper.getResultByInfoId(i1);
    }

    @Override
    public Drugs getMedById(Integer drugid) {
        return sixpartoneMapper.getMedById(drugid);
    }

    @Override
    public void addOften(Sixpartoften sixpartoften) {
        sixpartoneMapper.addOften(sixpartoften);
    }

    @Override
    public List<Sixpartoften> findAllOften() {
        return sixpartoneMapper.findAllOften();
    }

    @Override
    public void deleteByDrugName(String name) {
        sixpartoneMapper.deleteByDrugName(name);
    }

    @Override
    public Integer getDrugIdByName(String name) {
        return sixpartoneMapper.getDrugIdByName(name);
    }

    @Override
    public List<Sixpartone> getPro2(Date startDate, Date endDate) {
        return sixpartoneMapper.getPro2(startDate,endDate);
    }

    @Override
    public int getMedicalIdByNo(String medicalRecordNo) {
        return sixpartoneMapper.getMedicalIdByNo(medicalRecordNo);
    }

    @Override
    public String getNumById(Integer examcheckid) {
        return sixpartoneMapper.getNumById(examcheckid);
    }

    @Override
    public String getPatientName(Integer examcheckid) {
        return sixpartoneMapper.getPatientName(examcheckid);
    }


}
