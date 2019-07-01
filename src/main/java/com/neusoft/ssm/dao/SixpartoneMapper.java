package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SixpartoneMapper {
    int countByExample(SixpartoneExample example);

    int deleteByExample(SixpartoneExample example);

    @Insert({
        "insert into sixpartone (status, goal, ",
        "requirement, number, ",
        "ItemName, patient_name, ",
        "medical_record_no, mark, ",
        "Price, date, ismed, ",
        "operatorid)",
        "values (#{status,jdbcType=CHAR}, #{goal,jdbcType=VARCHAR}, ",
        "#{requirement,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER}, ",
        "#{itemname,jdbcType=VARCHAR}, #{patientName,jdbcType=VARCHAR}, ",
        "#{medicalRecordNo,jdbcType=CHAR}, #{mark,jdbcType=CHAR}, ",
        "#{price,jdbcType=DOUBLE}, #{date,jdbcType=TIMESTAMP}, #{ismed,jdbcType=CHAR}, ",
        "#{operatorid,jdbcType=INTEGER})"
    })
    int insert(Sixpartone record);

    int insertSelective(Sixpartone record);

    List<Sixpartone> selectByExample(SixpartoneExample example);

    int updateByExampleSelective(@Param("record") Sixpartone record, @Param("example") SixpartoneExample example);

    int updateByExample(@Param("record") Sixpartone record, @Param("example") SixpartoneExample example);

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
}