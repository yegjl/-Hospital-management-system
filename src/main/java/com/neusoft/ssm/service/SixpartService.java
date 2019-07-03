package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.*;

import java.util.Date;
import java.util.List;

public interface SixpartService {
    List<Sixpartone> getPro();

    List<Sixpartone> getPro1(String medical_record_no, String patient_name);

    Integer findExamInfoId(String s, String s1);

    void updateStatus(int i1);

    List<Drugs> getdrugs();

    Integer getExamCheckId(String medical_record_no, String itemname);

    Integer addInfo(ExamcheckInfo examcheckInfo);

    Integer findIdByName(String itemname);

    String getMedNameById(Integer idByName);

    Integer getResultId(int i1);

    Integer addResult(ExamcheckResult examcheckResult);

    void addResultPic(ExamcheckResultPic examcheckResultPic);

    void updateResult(Integer resultId, String suojian, String advice);

    Integer getResultIdNum(int i1);

    void updateStatus1(int i1);

    List<ExamcheckResultPic> getPicsById(int i2);

    ExamcheckResult getResultByInfoId(int i1);

    Drugs getMedById(Integer drugid);

    void addOften(Sixpartoften sixpartoften);

    List<Sixpartoften> findAllOften();

    void deleteByDrugName(String name);

    Integer getDrugIdByName(String name);

    List<Sixpartone> getPro2(Date startDate, Date endDate);

    int getMedicalIdByNo(String medicalRecordNo);

    String getNumById(Integer examcheckid);

    String getPatientName(Integer examcheckid);
}
