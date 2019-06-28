package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.RegistrationInfo;

import java.util.Date;
import java.util.List;

public interface RegisterService {

    boolean add(String medical_record_no, String patient_name, String gender, Long age, Date birthday, String registration_category, String medical_category, String identity_card_no, String family_address, Date registration_date, Date see_doctor_date, String department_id, Long doctor_id, String registration_source, Integer settle_accounts_category, String is_seen_doctor, String status, Double expense);

    List<RegistrationInfo> findAll();

    boolean backRegister(Long id);

    RegistrationInfo findById(Long id);

    RegistrationInfo findByRecord(String medical_record_no);

    List<RegistrationInfo> findByKey(String keyword);

    List<RegistrationInfo> findByDaidoctorid(Integer id);

    List<RegistrationInfo> findByYidoctorid(Integer doctorid);
    List<RegistrationInfo> findByDaiDepart(Integer departid);

    List<RegistrationInfo> findByYiDepart(Integer departid);
    Long findMaxRecord();

    void alterAUTO();
}
