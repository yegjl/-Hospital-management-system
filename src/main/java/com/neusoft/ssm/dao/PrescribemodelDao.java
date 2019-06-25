package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Prescribemodel;
import com.neusoft.ssm.bean.PrescribemodelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescribemodelDao {
    long countByExample(PrescribemodelExample example);

    int deleteByExample(PrescribemodelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prescribemodel record);

    int insertSelective(Prescribemodel record);

    List<Prescribemodel> selectByExample(PrescribemodelExample example);

    Prescribemodel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prescribemodel record, @Param("example") PrescribemodelExample example);

    int updateByExample(@Param("record") Prescribemodel record, @Param("example") PrescribemodelExample example);

    int updateByPrimaryKeySelective(Prescribemodel record);

    int updateByPrimaryKey(Prescribemodel record);
}