package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Prescribecategory;
import com.neusoft.ssm.bean.PrescribecategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescribecategoryDao {
    long countByExample(PrescribecategoryExample example);

    int deleteByExample(PrescribecategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prescribecategory record);

    int insertSelective(Prescribecategory record);

    List<Prescribecategory> selectByExample(PrescribecategoryExample example);

    Prescribecategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prescribecategory record, @Param("example") PrescribecategoryExample example);

    int updateByExample(@Param("record") Prescribecategory record, @Param("example") PrescribecategoryExample example);

    int updateByPrimaryKeySelective(Prescribecategory record);

    int updateByPrimaryKey(Prescribecategory record);

    List<Prescribecategory> selectNeedPrescribe(int prescribeid);

    int updateIstemp(int id);

    int updateFormulation(int id);

    int updateCancel(int id);
}