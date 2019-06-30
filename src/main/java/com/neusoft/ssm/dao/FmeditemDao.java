package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Fmeditem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FmeditemDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Fmeditem record);

    int insertSelective(Fmeditem record);

    Fmeditem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fmeditem record);

    int updateByPrimaryKey(Fmeditem record);

    List<Fmeditem> findAll();

    int uploadDepartmentInfo(List<Fmeditem> fmeditems);
    /**
     * 按项目编码获取项目记录信息
     * @Param itemCode 项目编码
     * @return (Fmeditem)
     */
    Fmeditem findByItemCode(@Param("itemCode") String itemCode);

}