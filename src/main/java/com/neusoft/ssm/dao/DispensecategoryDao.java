package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Dispensecategory;
import com.neusoft.ssm.bean.DispensecategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispensecategoryDao {
    long countByExample(DispensecategoryExample example);

    int deleteByExample(DispensecategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dispensecategory record);

    int insertSelective(Dispensecategory record);

    List<Dispensecategory> selectByExample(DispensecategoryExample example);

    Dispensecategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dispensecategory record, @Param("example") DispensecategoryExample example);

    int updateByExample(@Param("record") Dispensecategory record, @Param("example") DispensecategoryExample example);

    int updateByPrimaryKeySelective(Dispensecategory record);

    int updateByPrimaryKey(Dispensecategory record);

    List<Dispensecategory> selectCategoryByMedicalrecordno(String medicalrecordno);

    int updateStatus(String medicalrecordno, int status);//在发药的时候状态值为1，退药的时候，状态值为2

    Dispensecategory selectLogById(int id);

    int returnMedicine(int id,int nowamount);

    int upreturnStatus(int id, int status);

    int upreturnall(String medicalrecordno);

}