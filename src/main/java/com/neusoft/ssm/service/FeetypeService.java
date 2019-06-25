package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Feetype;

import java.util.List;

public interface FeetypeService {

    List<Feetype> findAll();

    String findById(Integer id);
    int doInsert(Feetype record);
    int delete(int id);
    int update(Feetype record);
}
