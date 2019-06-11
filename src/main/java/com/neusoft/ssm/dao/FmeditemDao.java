package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Fmeditem;

import java.util.List;

public interface FmeditemDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Fmeditem record);

    int insertSelective(Fmeditem record);

    Fmeditem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fmeditem record);

    int updateByPrimaryKey(Fmeditem record);

    List<Fmeditem> findAll();

    int uploadDepartmentInfo(List<Fmeditem> fmeditems);
}