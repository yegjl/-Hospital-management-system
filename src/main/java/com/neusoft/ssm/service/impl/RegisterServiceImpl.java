package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.RegistrationInfo;
import com.neusoft.ssm.dao.RegisterMapper;
import com.neusoft.ssm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterMapper registerMapper;

    @Override
    public boolean add(String medical_record_no, String patient_name, String gender, Double age, Date birthday, String registration_category, String medical_category, String identity_card_no, String family_address, Date registration_date, Date see_doctor_date, String department_id, Long doctor_id, String registration_source, Integer settle_accounts_category, String is_seen_doctor, String status, Double expense) {
        return registerMapper.add(medical_record_no, patient_name, gender, age, birthday, registration_category, medical_category, identity_card_no, family_address, registration_date, see_doctor_date, department_id, doctor_id, registration_source, settle_accounts_category, is_seen_doctor, status, expense);
    }

    @Override
    public List<RegistrationInfo> findAll() {
        return registerMapper.findAll();
    }

    @Override
    public boolean backRegister(Long id) {
        return registerMapper.backRegister(id);
    }

    @Override
    public RegistrationInfo findById(Long id) {
        return registerMapper.findById(id);
    }

    @Override
    public RegistrationInfo findByRecord(String medical_record_no) {
        return registerMapper.findByRecord(medical_record_no);
    }

    @Override
    public List<RegistrationInfo> findByKey(String keyword) {
        keyword = "%" + keyword + "%";
        return registerMapper.findByKey(keyword);
    }
    @Override
    public List<RegistrationInfo> findByDaidoctorid(Integer doctorid) {

        return registerMapper.findByDaidoctorid(doctorid);
    }
    @Override
    public List<RegistrationInfo> findByYidoctorid(Integer doctorid) {

        return registerMapper.findByYidoctorid(doctorid);
    }

    @Override
    public List<RegistrationInfo> findByDaiDepart(String departcode) {
        return registerMapper.findByDaiDepart(departcode);
    }

    @Override
    public List<RegistrationInfo> findByYiDepart(String departcode) {
        return registerMapper.findByYiDepart(departcode);
    }

    @Override
    public Long findMaxRecord() {
        return registerMapper.findMaxRecord();
    }

    @Override
    @Transactional
    public void alterAUTO() {
        registerMapper.alterAUTO();
    }

    @Override
    public int quezhen(String medicalRecordNo) {
        return registerMapper.updateIsSeen(medicalRecordNo);
    }
}
