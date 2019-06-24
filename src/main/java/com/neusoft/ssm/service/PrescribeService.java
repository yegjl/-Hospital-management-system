package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.*;

import java.util.List;

public interface PrescribeService {

    int insertPrescribe(Prescribe record);

    int insertPrescribecategory(Prescribecategory record);

    int deletePrescribe(Integer id);

    int deletePrescribecategory(Integer id);

    List<Drugs> selectDrugsByKey(String key);

    int updateZhenbi(int medicalrecordid);

    List<Drugs> getAllChengDrugs(String drugid);

    List<Drugs> getAllCaoDrugs(String drugid);

    Drugs findByid(int id);

    List<Prescribe> getAllpreidByDoc(int doctorid);

    List<Prescribecategory> getNeedPrescribe(int prescribeid);

    List<Prescribelogview> getByMrecordidAndDid(int medicalrecordid,int doctorid);

    int getPreCount(Integer doctorid,Integer medicalid);

    Integer getNowID(Integer doctorid, Integer medicalrecordid);

    int updateIstemp(int id);

    int updateIsdone(int id);

    int prescribeFormulation(int id);

    int prescribecateFormulation(int id);

    int prescribeCancel(int id);

    int prescribecateCancel(int id);

    int addPrescribemodel(Prescribemodel record);

    int addPrescribemodellog(Prescribemodellog record);

    Prescribelogview findByTwoid(int prescribeid,int medicalid);

    int updatePrescribecategory(Prescribecategory record);

}
