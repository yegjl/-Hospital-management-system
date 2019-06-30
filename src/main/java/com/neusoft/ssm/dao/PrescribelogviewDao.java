package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Prescribelogview;
import com.neusoft.ssm.bean.PrescribelogviewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescribelogviewDao {
    long countByExample(PrescribelogviewExample example);

    int deleteByExample(PrescribelogviewExample example);

    int insert(Prescribelogview record);

    int insertSelective(Prescribelogview record);

    List<Prescribelogview> selectByExample(PrescribelogviewExample example);

    int updateByExampleSelective(@Param("record") Prescribelogview record, @Param("example") PrescribelogviewExample example);

    int updateByExample(@Param("record") Prescribelogview record, @Param("example") PrescribelogviewExample example);

    List<Prescribelogview> selectByMrecordidAndDid(String medicalrecordid,int doctorid);//需要处理的函数

    Prescribelogview selectByTwoid(int prescribeid,int medicalid);
}