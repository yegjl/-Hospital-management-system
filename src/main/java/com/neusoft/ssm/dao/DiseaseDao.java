package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Disease;
import com.neusoft.ssm.bean.DiseaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiseaseDao {
    long countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Disease record);

    int insertSelective(Disease record);

    List<Disease> selectByExample(DiseaseExample example);

    Disease selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);
}