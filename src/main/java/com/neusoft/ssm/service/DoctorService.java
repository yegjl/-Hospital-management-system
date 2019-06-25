package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Doctor;

import java.util.List;

public interface DoctorService {

    String findNameById(Long id);

    String findDeptCodeById(Long id);

    List<Doctor> findAll();

}
