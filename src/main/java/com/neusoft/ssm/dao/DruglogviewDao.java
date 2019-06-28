package com.neusoft.ssm.dao;

import java.util.List;

import com.neusoft.ssm.bean.Druglogview;
import com.neusoft.ssm.bean.DruglogviewExample;
import org.apache.ibatis.annotations.Param;

public interface DruglogviewDao {
    long countByExample(DruglogviewExample example);

    int deleteByExample(DruglogviewExample example);

    int insert(Druglogview record);

    int insertSelective(Druglogview record);

    List<Druglogview> selectByExample(DruglogviewExample example);

    int updateByExampleSelective(@Param("record") Druglogview record, @Param("example") DruglogviewExample example);

    int updateByExample(@Param("record") Druglogview record, @Param("example") DruglogviewExample example);

    List<Druglogview> selectAll();

    Druglogview selectById(int id);

    List<Druglogview> selectByKey(String drug);
}