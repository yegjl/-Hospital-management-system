package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dao.*;
import com.neusoft.ssm.service.PrescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PrescribeServiceImpl implements PrescribeService {

    @Autowired
    private PrescribeDao prescribeDao;

    @Autowired
    private DrugsDao drugsDao;

    @Autowired
    private PrescribecategoryDao prescribecategoryDao;

    @Autowired
    private PrescribelogviewDao prescribelogviewDao;

    @Autowired
    private PrescribemodelDao prescribemodelDao;

    @Autowired
    private PrescribemodellogDao prescribemodellogDao;

    @Autowired
    private ExpenseMapper expenseMapper;

    @Autowired
    private OftendrugDao oftendrugDao;


    @Override
    public int insertPrescribe(Prescribe record) {
        return prescribeDao.insertSelective(record);
    }

    @Override
    public int insertPrescribecategory(Prescribecategory record) {
        return prescribecategoryDao.insertSelective(record);
    }

    @Override
    public int deletePrescribe(Integer id) {
        return prescribeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deletePrescribecategory(Integer id) {
        return prescribecategoryDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Drugs> selectDrugsByKey(String key) {
        return drugsDao.selectByKey(key);
    }

    @Override
    public int updateZhenbi(int medicalrecordid) {
        return prescribeDao.updateIsdone(medicalrecordid);
    }

    @Override
    public List<Drugs> getAllChengDrugs(String drugid) {
        return drugsDao.selectAllCheng(drugid);
    }

    @Override
    public List<Drugs> getAllCaoDrugs(String drugid) {
        return drugsDao.selectAllCao(drugid);
    }

//    @Override
//    public int updateTest(String name) {
//        return prescribecategoryDao.updateTest(name);
//    }



    @Override
    public Drugs findByid(int id) {
        return drugsDao.selectByid(id);
    }

    @Override
    public List<Prescribe> getAllpreidByDoc(int doctorid) {
        return prescribeDao.selectPrescribe(doctorid);
    }

    @Override
    public List<Prescribecategory> getNeedPrescribe(int prescribeid) {
        return prescribecategoryDao.selectNeedPrescribe(prescribeid);
    }

    @Override
    public List<Prescribelogview> getByMrecordidAndDid(String medicalrecordid, int doctorid) {
        return prescribelogviewDao.selectByMrecordidAndDid(medicalrecordid,doctorid);
    }

    @Override
    public int getPreCount(Integer doctorid, String medicalid) {
        return prescribeDao.getPreCount(doctorid,medicalid);
    }

    @Override
    public Integer getNowID(Integer doctorid, String medicalrecordid) {
        return prescribeDao.getNowID(doctorid, medicalrecordid);
    }

    @Override
    public int updateIstemp(int id) {
        return prescribecategoryDao.updateIstemp(id);
    }

    @Override
    public int updateIsdone(int id) {
        return prescribeDao.updateIsdone(id);
    }

    @Override
    public int prescribeFormulation(int id) {
        return prescribeDao.updateFormulation(id);
    }

    @Override
    public int prescribecateFormulation(int id) {
        return prescribecategoryDao.updateFormulation(id);
    }

    @Override
    public int prescribeCancel(int id) {
        return prescribeDao.updateCancel(id);
    }

    @Override
    public int prescribecateCancel(int id) {
        return prescribecategoryDao.updateCancel(id);
    }

    @Override
    public int addPrescribemodel(Prescribemodel record) {
        return prescribemodelDao.insertSelective(record);
    }

    @Override
    public int addPrescribemodellog(Prescribemodellog record) {
        return prescribemodellogDao.insertSelective(record);
    }

    @Override
    public Prescribelogview findByTwoid(int prescribeid, int medicalid) {
        return prescribelogviewDao.selectByTwoid(prescribeid, medicalid);
    }

    @Override
    public int updatePrescribecategory(Prescribecategory record) {
        return prescribecategoryDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMoney(int id, BigDecimal money) {
        return prescribeDao.updateTotalmoney(id, money);
    }

    @Override
    public int insertExpense(Expense record) {
        return expenseMapper.insertSelective(record);
    }

    @Override
    public int getDrugsTypeID(int medicalid) {
        return drugsDao.selectDrugsTypeID(medicalid);
    }

    @Override
    public int addoften(Oftendrug record) {
        return oftendrugDao.insertSelective(record);
    }

    @Override
    public List<Oftendrug> showoften(int doctorid) {
        return oftendrugDao.selectByDoctorid(doctorid);
    }

    @Override
    public int deleteOften(Integer medicalid) {
        return oftendrugDao.deleteByPrimaryKey(medicalid);
    }


}
