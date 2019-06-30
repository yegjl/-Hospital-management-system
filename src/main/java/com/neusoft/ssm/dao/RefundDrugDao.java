package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.RefundDrug;
import com.neusoft.ssm.bean.RefundDrugExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundDrugDao {
    long countByExample(RefundDrugExample example);

    int deleteByExample(RefundDrugExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundDrug record);

    int insertSelective(RefundDrug record);

    List<RefundDrug> selectByExample(RefundDrugExample example);

    RefundDrug selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundDrug record, @Param("example") RefundDrugExample example);

    int updateByExample(@Param("record") RefundDrug record, @Param("example") RefundDrugExample example);

    int updateByPrimaryKeySelective(RefundDrug record);

    int updateByPrimaryKey(RefundDrug record);
}