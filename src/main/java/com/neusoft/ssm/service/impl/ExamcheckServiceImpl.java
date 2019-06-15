package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Examcheckone;
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
}
