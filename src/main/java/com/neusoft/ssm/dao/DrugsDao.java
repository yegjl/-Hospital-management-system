package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Drugs;
import com.neusoft.ssm.bean.DrugsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugsDao {
    long countByExample(DrugsExample example);

    int deleteByExample(DrugsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Drugs record);

    int insertSelective(Drugs record);

    List<Drugs> selectByExample(DrugsExample example);

    Drugs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drugs record, @Param("example") DrugsExample example);

    int updateByExample(@Param("record") Drugs record, @Param("example") DrugsExample example);

    List<Drugs> selectByKey(String key);

    List<Drugs> selectAllCheng(String drugid);

    List<Drugs> selectAllCao(String drugid);

    Drugs selectByid(int id);

}