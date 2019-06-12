package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Icd;
import com.neusoft.ssm.bean.IcdExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IcdDao {
    long countByExample(IcdExample example);

    int deleteByExample(IcdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Icd record);

    int insertSelective(Icd record);

    List<Icd> selectByExample(IcdExample example);

    Icd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Icd record, @Param("example") IcdExample example);

    int updateByExample(@Param("record") Icd record, @Param("example") IcdExample example);

    int updateByPrimaryKeySelective(Icd record);

    int updateByPrimaryKey(Icd record);

    @MapKey("ICDFirstName")
    Map<String, Map<String,String>> selectFirstName();

    List<Icd> selectSecondName(String icdid);



}