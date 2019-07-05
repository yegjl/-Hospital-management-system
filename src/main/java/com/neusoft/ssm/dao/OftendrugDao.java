package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Oftendrug;
import com.neusoft.ssm.bean.OftendrugExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OftendrugDao {
    long countByExample(OftendrugExample example);

    int deleteByExample(OftendrugExample example);

    int deleteByPrimaryKey(Integer medicalid);

    int insert(Oftendrug record);

    int insertSelective(Oftendrug record);

    List<Oftendrug> selectByExample(OftendrugExample example);

    Oftendrug selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Oftendrug record, @Param("example") OftendrugExample example);

    int updateByExample(@Param("record") Oftendrug record, @Param("example") OftendrugExample example);

    int updateByPrimaryKeySelective(Oftendrug record);

    int updateByPrimaryKey(Oftendrug record);

    List<Oftendrug> selectByDoctorid(int doctorid);

    Integer getMedIdByName(String s,String s1);
}