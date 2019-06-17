package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Examcheckone;
import com.neusoft.ssm.bean.Fmeditem;
import com.neusoft.ssm.dao.ExamcheckoneMapper;
import com.neusoft.ssm.service.ExamcheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamcheckServiceImpl implements ExamcheckService {

    @Autowired
    ExamcheckoneMapper examcheckoneMapper;

    @Override
    public List<Examcheckone> getPro(Integer doctorid, Integer medicalid) {
        return examcheckoneMapper.getPro(doctorid,medicalid);
    }

    @Override
    public int deleteByExamId(Integer i, Integer id) {
        return examcheckoneMapper.deleteByExamId(i,id);
    }

    @Override
    public void deleteUnsave() {
        examcheckoneMapper.deleteUnsave();
    }

    @Override
    public Integer findIdByCode(Integer i) {
        return examcheckoneMapper.findIdByCode(i);
    }

    @Override
    public Integer saveByExamId(Integer i, Integer id) {
        return examcheckoneMapper.saveByExamId(i,id);
    }

    @Override
    public Integer openByExamId(Integer i, Integer id) {
        return examcheckoneMapper.openByExamId(i,id);
    }

    @Override
    public Integer cancelByExamId(Integer i, Integer id) {
        return examcheckoneMapper.cancelByExamId(i,id);
    }

    @Override
    public List<Fmeditem> findByExamType(String id) {
        return examcheckoneMapper.findByExamType(id);
    }
}
