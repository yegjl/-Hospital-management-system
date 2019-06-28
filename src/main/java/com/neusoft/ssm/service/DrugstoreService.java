package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface DrugstoreService {

    int addDrug(Drugs record);

    int addDrugsupplement(Drugsupplement record);

    List<Druglogview> getAllDrgus();

    List<Constantitem> getType(String constanttypeid);

    int delDrug(Integer id);

    int delDrugsupplement(Integer id);

    Druglogview selectDruglog(int id);

    int updateDrugs(Drugs record);

    int updateDrugsupplement(Drugsupplement record);

    int upPriceAndDate(int id, BigDecimal price, Date creationdate);

    int addAdjustprice(Adjustprice record);

    List<Adjustprice> getAdjustByID(int drugid);

    List<Druglogview> searchByKey(String drug);

    List<Dispense> getDispenseByTodayAndStatu(int statu, Date today);

    List<Dispense> getDispenseByPreidAndStatu(String preid, int statu);

    List<Dispense> getDispenseByStatu(int statu);

    List<Dispense> getDispenseByTriInfo(String preid, int statu, Date today);

    List<Dispense> getAllDispense();

    List<Dispensecategory> getCategoryByMedicalrecordno(String medicalrecordno);

    RegistrationInfo getInfoByRecordno(String recordno);

    int upStatus(String medicalrecordno, int status);

    int upreStatus(int id, int status);

    Dispensecategory findDispenseLogById(int id);

    int reMedicine(int id,int nowamount);

    int updateDispenseStatu(String medicalrecordno, int status);

    int upreturnall(String medicalrecordno);

    int updateReturnamount(int id,int drugsamount);

    int updateDispenseamounr(int id,int drugsamount);

}
