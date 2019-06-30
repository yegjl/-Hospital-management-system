package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Feetype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface FeetypeDao {
    int deleteByPrimaryKey(int id);

    int insert(Feetype record);

    int insertSelective(Feetype record);

    Feetype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feetype record);

    int updateByPrimaryKey(Feetype record);

    List<Feetype> selectAll();
    /**
     * 获取全部结算类别信息列表
     * @return (List<Feetype>)
     */
    List<Feetype> findAll();
    /**
     * 按id获取结算类型名称
     * @Param id 结算类型id
     * @return (String)
     */
    String findById(@Param("id") Integer id);
}