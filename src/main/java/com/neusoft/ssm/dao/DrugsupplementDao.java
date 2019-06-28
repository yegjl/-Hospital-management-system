package com.neusoft.ssm.dao;

import java.util.List;

import com.neusoft.ssm.bean.Drugsupplement;
import com.neusoft.ssm.bean.DrugsupplementExample;
import org.apache.ibatis.annotations.Param;

public interface DrugsupplementDao {
    long countByExample(DrugsupplementExample example);

    int deleteByExample(DrugsupplementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Drugsupplement record);

    int insertSelective(Drugsupplement record);

    List<Drugsupplement> selectByExample(DrugsupplementExample example);

    Drugsupplement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drugsupplement record, @Param("example") DrugsupplementExample example);

    int updateByExample(@Param("record") Drugsupplement record, @Param("example") DrugsupplementExample example);

    int updateByPrimaryKeySelective(Drugsupplement record);

    int updateByPrimaryKey(Drugsupplement record);

    int updateReturnamount(int id,int drugsamount);

    int updateDispenseamounr(int id,int drugsamount);
}