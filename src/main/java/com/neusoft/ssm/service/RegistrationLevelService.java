package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Registrationlevel;

import java.util.List;

public interface RegistrationLevelService {
    Registrationlevel findByCode(String numberCode);
    List<Registrationlevel> findAll();
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Registrationlevel record);
    int updateByPrimaryKeySelective(Registrationlevel record);
}
