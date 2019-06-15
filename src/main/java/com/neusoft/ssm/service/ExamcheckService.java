package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Examcheckone;

import java.util.List;

public interface ExamcheckService {
    List<Examcheckone> getPro(Integer doctorid, Integer medicalid);
}
