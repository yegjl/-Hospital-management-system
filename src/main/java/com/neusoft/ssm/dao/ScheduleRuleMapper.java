package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.ScheduleRule;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * 排班规则接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface ScheduleRuleMapper {

    /**
     * 添加排班规则
     * @param doctor_id 医生id
     * @Param week_time 星期
     * @Param register_level 号别
     * @Param noon_level 午别
     * @Param limit_num 排班限额
     * @return (boolean)
     */
    boolean add(@Param("doctor_id") Long doctor_id, @Param("week_time") String week_time, @Param("register_level") String register_level, @Param("noon_level") String noon_level, @Param("limit_num") Integer limit_num, @Param("operate_date") Date operate_date);

    /**
     * 修改排班规则
     * @Param id 需要修改的规则id
     * @Param doctor_id 医生id
     * @Param week_time 星期
     * @Param register_level 号别
     * @Param noon_level 午别
     * @Param limit_num 排班限额
     * @return (boolean)
     */
    boolean update(@Param("id") Long id, @Param("doctor_id") Long doctor_id, @Param("week_time") String week_time, @Param("register_level") String register_level, @Param("noon_level") String noon_level, @Param("limit_num") Integer limit_num, @Param("operate_date") Date operate_date);

    /**
     * 按排班规则id删除
     * @Param id 排班规则id
     */
    void deleteById(Long id);

    /**
     * 获取全部排班规则列表
     * @return (List<ScheduleRule>)
     */
    List<ScheduleRule> findAll();

    /**
     * 按医生id和星期获取排班规则信息
     * @Param doctor_id 医生id
     * @Param week_time 星期
     * @return (ScheduleRule)
     */
    ScheduleRule findByIdAndDate(@Param("doctor_id") Long doctor_id, @Param("week_time") String week_time);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();

    /**
     * 根据医生姓名模糊搜索
     * @Param keyword 搜索关键字
     * @return (List<ScheduleRule>)
     */
    List<ScheduleRule> findByAll(@Param("keyword") String keyword);

}
