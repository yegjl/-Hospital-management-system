package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Constantitem;
import com.neusoft.ssm.bean.ConstantitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConstantitemDao {
    long countByExample(ConstantitemExample example);

    int deleteByExample(ConstantitemExample example);

    int insert(Constantitem record);

    int insertSelective(Constantitem record);

    List<Constantitem> selectByExample(ConstantitemExample example);

    int updateByExampleSelective(@Param("record") Constantitem record, @Param("example") ConstantitemExample example);

    int updateByExample(@Param("record") Constantitem record, @Param("example") ConstantitemExample example);

    List<Constantitem> selectType(String constanttypeid);
}