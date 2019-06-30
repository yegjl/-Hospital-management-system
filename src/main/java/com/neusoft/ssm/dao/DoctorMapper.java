package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医生信息接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface DoctorMapper {

    /**
     * 按医生id获取医生姓名
     * @Param id 医生id
     * @return (String)
     */
    String findNameById(@Param("id") Long id);

    /**
     * 按医生id获取医生所属科室id
     * @Param id 医生id
     * @return (String)
     */
    String findDeptCodeById(@Param("id") Long id);

    /**
     * 获取全部医生信息列表
     * @return (List<DailySettle>)
     */
    List<Doctor> findAll();

}
