package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Examcheckone;
import com.neusoft.ssm.bean.Fmeditem;

import java.util.List;

public interface ExamcheckService {
    List<Examcheckone> getPro(Integer doctorid, Integer medicalid);

    int deleteByExamId(Integer i, Integer id);

    void deleteUnsave();

    Integer findIdByCode(Integer i);

    Integer saveByExamId(Integer i, Integer id);

    Integer openByExamId(Integer i, Integer id);

    Integer cancelByExamId(Integer i, Integer id);

    List<Fmeditem> findByExamType(String id);
}
