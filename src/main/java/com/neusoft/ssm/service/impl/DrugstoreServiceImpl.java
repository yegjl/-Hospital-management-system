package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dao.*;
import com.neusoft.ssm.service.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class DrugstoreServiceImpl implements DrugstoreService {
    @Autowired
    DrugsDao drugsDao;

    @Autowired
    DrugsupplementDao drugsupplementDao;

    @Autowired
    DruglogviewDao druglogviewDao;

    @Autowired
    ConstantitemDao constantitemDao;

    @Autowired
    AdjustpriceDao adjustpriceDao;

    @Autowired
    DispenseDao dispenseDao;

    @Autowired
    DispensecategoryDao dispensecategoryDao;

    @Autowired
    RegisterMapper registerMapper;

    @Override
    public int addDrug(Drugs record) {
        return drugsDao.insertSelective(record);
    }

    @Override
    public int addDrugsupplement(Drugsupplement record) {
        return drugsupplementDao.insertSelective(record);
    }

    @Override
    public List<Druglogview> getAllDrgus() {
        return druglogviewDao.selectAll();
    }

    @Override
    public List<Constantitem> getType(String constanttypeid) {
        return constantitemDao.selectType(constanttypeid);
    }

    @Override
    public int delDrug(Integer id) {
        return drugsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delDrugsupplement(Integer id) {
        return drugsupplementDao.deleteByPrimaryKey(id);
    }

    @Override
    public Druglogview selectDruglog(int id) {
        return druglogviewDao.selectById(id);
    }

    @Override
    public int updateDrugs(Drugs record) {
        return drugsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateDrugsupplement(Drugsupplement record) {
        return drugsupplementDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int upPriceAndDate(int id, BigDecimal price, Date creationdate) {
        return drugsDao.updatePriceAndDate(id, price, creationdate);
    }

    @Override
    public int addAdjustprice(Adjustprice record) {
        return adjustpriceDao.insertSelective(record);
    }

    @Override
    public List<Adjustprice> getAdjustByID(int drugid) {
        return adjustpriceDao.selectAdjustByID(drugid);
    }

    @Override
    public List<Druglogview> searchByKey(String drug) {
        return druglogviewDao.selectByKey(drug);
    }

    @Override
    public List<Dispense> getDispenseByTodayAndStatu(int statu, Date today) {
        return dispenseDao.selectDispenseByTodayAndStatu(statu,today);
    }

    @Override
    public List<Dispense> getDispenseByPreidAndStatu(String preid, int statu) {
        return dispenseDao.selectDispenseByPreidAndStatu(preid,statu);
    }

    @Override
    public List<Dispense> getDispenseByStatu(int statu) {
        return dispenseDao.selectDispenseByStatu(statu);
    }

    @Override
    public List<Dispense> getDispenseByTriInfo(String preid, int statu, Date today) {
        return dispenseDao.selectDispenseByTriInfo(preid, statu, today);
    }

    @Override
    public List<Dispense> getAllDispense() {
        return dispenseDao.selectAllDispense();
    }

    @Override
    public List<Dispensecategory> getCategoryByMedicalrecordno(String medicalrecordno) {
        return dispensecategoryDao.selectCategoryByMedicalrecordno(medicalrecordno);
    }

    @Override
    public RegistrationInfo getInfoByRecordno(String recordno) {
        return registerMapper.selectInfoByRecordno(recordno);
    }

    @Override
    public int upStatus(String medicalrecordno, int status) {
        return dispensecategoryDao.updateStatus(medicalrecordno, status);
    }

    @Override
    public int upreStatus(int id, int status) {
        return dispensecategoryDao.upreturnStatus(id, status);
    }

    @Override
    public Dispensecategory findDispenseLogById(int id) {
        return dispensecategoryDao.selectLogById(id);
    }

    @Override
    public int reMedicine(int id, int nowamount) {
        return dispensecategoryDao.returnMedicine(id, nowamount);
    }

    @Override
    public int updateDispenseStatu(String medicalrecordno, int status) {
        return dispenseDao.updateDispenseStatu(medicalrecordno, status);
    }

    //全退将数量变为0
    @Override
    public int upreturnall(String medicalrecordno) {
        return dispensecategoryDao.upreturnall(medicalrecordno);
    }

    @Override
    public int updateReturnamount(int id, int drugsamount) {
        return drugsupplementDao.updateReturnamount(id, drugsamount);
    }

    @Override
    public int updateDispenseamounr(int id, int drugsamount) {
        return drugsupplementDao.updateDispenseamounr(id, drugsamount);
    }


}
