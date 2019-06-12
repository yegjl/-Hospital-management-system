package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Disease;
import com.neusoft.ssm.bean.Diswithcate;
import com.neusoft.ssm.bean.Icd;

import java.util.List;
import java.util.Map;

public interface ICDService {
    Map<String,String> findFirstName();

    List<Icd> findSecondName(String icdid);

    List<Diswithcate> findAll(String ICDID);

    int doinsert(Disease record);

    int deleteByKey(int id);

    int updateDisease(Disease record);

    List<Diswithcate> findSearch(String keyword, String secondid);
}
