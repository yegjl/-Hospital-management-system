package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Prescribemodellog;
import com.neusoft.ssm.bean.PrescribemodellogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescribemodellogDao {
    long countByExample(PrescribemodellogExample example);

    int deleteByExample(PrescribemodellogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prescribemodellog record);

    int insertSelective(Prescribemodellog record);

    List<Prescribemodellog> selectByExample(PrescribemodellogExample example);

    Prescribemodellog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prescribemodellog record, @Param("example") PrescribemodellogExample example);

    int updateByExample(@Param("record") Prescribemodellog record, @Param("example") PrescribemodellogExample example);

    int updateByPrimaryKeySelective(Prescribemodellog record);

    int updateByPrimaryKey(Prescribemodellog record);
}