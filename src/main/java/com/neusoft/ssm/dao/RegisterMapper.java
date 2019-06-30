package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.RegistrationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 挂号退号接口类
 * @author Nebula
 * @version 1.20 2019/06/29
 * */

public interface RegisterMapper {

    /**
     * 挂号
     * @Param medical_record_no 病历号
     * @Param patient_name 患者姓名
     * @Param gender 性别
     * @Param age 年龄
     * @Param birthday 生日
     * @Param registration_category 挂号类别
     * @Param medical_category 医疗类别
     * @Param identity_card_no 身份证号
     * @Param family_address 家庭住址
     * @Param registration_date 挂号日期
     * @Param see_doctor_date 看诊日期
     * @Param department_id 科室id
     * @Param doctor_id 医生id
     * @Param registration_source 挂号来源
     * @Param settle_accounts_category 日结标志
     * @Param is_seen_doctor 是否看诊
     * @Param status 状态
     * @Param expense 价格
     * @return (boolean)
     */
    boolean add(@Param("medical_record_no") String medical_record_no, @Param("patient_name") String patient_name, @Param("gender") String gender, @Param("age") Double age, @Param("birthday") Date birthday, @Param("registration_category") String registration_category, @Param("medical_category") String medical_category, @Param("identity_card_no") String identity_card_no, @Param("family_address") String family_address, @Param("registration_date") Date registration_date, @Param("see_doctor_date") Date see_doctor_date, @Param("department_id") String department_id, @Param("doctor_id") Long doctor_id, @Param("registration_source") String registration_source, @Param("settle_accounts_category") Integer settle_accounts_category, @Param("is_seen_doctor") String is_seen_doctor, @Param("status") String status, @Param("expense") Double expense);

    /**
     * 获取全部挂号信息列表
     * @return (List<RegistrationInfo>)
     */
    List<RegistrationInfo> findAll();

    /**
     * 退号
     * @Param id 挂号记录的id
     * @return (boolean)
     */
    boolean backRegister(@Param("id") Long id);

    /**
     * 按id查找挂号信息
     * @Param id 挂号记录的id
     * @return (RegistrationInfo)
     */
    RegistrationInfo findById(@Param("id") Long id);

    /**
     * 按病历号查找挂号信息
     * @Param medical_record_no 病历号
     * @return (RegistrationInfo)
     */
    RegistrationInfo findByRecord(@Param("medical_record_no") String medical_record_no);

    /**
     * 模糊搜索
     * @Param keyword 搜索关键字
     * @return (List<RegistrationInfo>)
     */
    List<RegistrationInfo> findByKey(@Param("keyword") String keyword);

    /**
     * 获取距离当前最近的病历号
     * @return (Long)
     */
    Long findMaxRecord();

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();

    List<RegistrationInfo> findByDaidoctorid(Integer doctorid);
    List<RegistrationInfo> findByYidoctorid(Integer doctorid);
    List<RegistrationInfo> findByDaiDepart(Integer departid);
    List<RegistrationInfo> findByYiDepart(Integer departid);

    RegistrationInfo selectInfoByRecordno(String recordno);

    int updateIsSeen(String medicalRecordNo);
}
