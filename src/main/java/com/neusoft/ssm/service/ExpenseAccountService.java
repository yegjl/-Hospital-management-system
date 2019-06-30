package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.ExpenseAccount;

import java.util.List;

public interface ExpenseAccountService {

    String findByCode(String account_code);

    List<ExpenseAccount> findAll();

    List<ExpenseAccount> select(String keyword);

    boolean add(String account_code, String account_name);

    boolean delete(Long id);

    boolean update(Long id, String account_code, String account_name);

    Integer findSame(String account_code, String account_name);

    Integer findEditSame(String account_code, String real_code, String account_name, String real_name);

    void alterAUTO();

}
