package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Diswithcate;
import com.neusoft.ssm.bean.DiswithcateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiswithcateDao {
    long countByExample(DiswithcateExample example);

    int deleteByExample(DiswithcateExample example);

    int insert(Diswithcate record);

    int insertSelective(Diswithcate record);

    List<Diswithcate> selectByExample(DiswithcateExample example);

    int updateByExampleSelective(@Param("record") Diswithcate record, @Param("example") DiswithcateExample example);

    int updateByExample(@Param("record") Diswithcate record, @Param("example") DiswithcateExample example);

    List<Diswithcate> selectAll(String ICDID);

    List<Diswithcate> getSearch(String keyword, String secondid);

}