package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Feetype;
import com.neusoft.ssm.dao.FeetypeDao;
import com.neusoft.ssm.service.FeetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeTypeServiceImpl implements FeetypeService {

    @Autowired
    FeetypeDao feetypeDao;

    @Override
    public List<Feetype> findAll() {
        return feetypeDao.findAll();
    }

    @Override
    public String findById(Integer id) {
        return feetypeDao.findById(id);
    }
    @Override
    public int doInsert(Feetype record) {
        return feetypeDao.insertSelective(record);
    }

    @Override
    public int delete(int id) {
        return feetypeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Feetype record) {
        return feetypeDao.updateByPrimaryKeySelective(record);
    }
}
