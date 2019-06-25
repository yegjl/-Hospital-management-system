package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Prescribe;
import com.neusoft.ssm.bean.PrescribeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescribeDao {
    long countByExample(PrescribeExample example);

    int deleteByExample(PrescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prescribe record);

    int insertSelective(Prescribe record);

    List<Prescribe> selectByExample(PrescribeExample example);

    Prescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prescribe record, @Param("example") PrescribeExample example);

    int updateByExample(@Param("record") Prescribe record, @Param("example") PrescribeExample example);

    int updateByPrimaryKeySelective(Prescribe record);

    int updateByPrimaryKey(Prescribe record);

    int updateIsdone(int id);//传值是直接传处方id

    List<Prescribe> selectPrescribe(int doctorid);

    int getPreCount(Integer doctorid,Integer medicalid);

    Integer getNowID(Integer doctorid, Integer medicalrecordid);

    int updateFormulation(int id);

    int updateCancel(int id);
}