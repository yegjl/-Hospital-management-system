package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Dispense;
import com.neusoft.ssm.bean.DispenseExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispenseDao {
    long countByExample(DispenseExample example);

    int deleteByExample(DispenseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dispense record);

    int insertSelective(Dispense record);

    List<Dispense> selectByExample(DispenseExample example);

    Dispense selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dispense record, @Param("example") DispenseExample example);

    int updateByExample(@Param("record") Dispense record, @Param("example") DispenseExample example);

    int updateByPrimaryKeySelective(Dispense record);

    int updateByPrimaryKey(Dispense record);

    List<Dispense> selectDispenseByTodayAndStatu(int statu, Date today);

    List<Dispense> selectDispenseByPreidAndStatu(String preid,int statu);

    List<Dispense> selectDispenseByStatu(int statu);

    List<Dispense> selectDispenseByTriInfo(String preid,int statu,Date today);

    List<Dispense> selectAllDispense();

    int updateDispenseStatu(String medicalrecordno, int status);
}