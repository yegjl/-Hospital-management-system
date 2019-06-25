package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.dao.ExpenseAccountMapper;
import com.neusoft.ssm.service.ExpenseAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseAccountServiceImpl implements ExpenseAccountService {

    @Autowired
    ExpenseAccountMapper expenseAccountMapper;

    @Override
    public String findByCode(String account_code) {
        return expenseAccountMapper.findByCode(account_code);
    }

    @Override
    public List<ExpenseAccount> findAll() {
        return expenseAccountMapper.findAll();
    }

    @Override
    public List<ExpenseAccount> select(String keyword) {
        keyword = "%" + keyword + "%";
        return expenseAccountMapper.select(keyword);
    }

    @Override
    public boolean add(String account_code, String account_name) {
        return expenseAccountMapper.add(account_code, account_name);
    }

    @Override
    public boolean delete(Long id) {
        return expenseAccountMapper.delete(id);
    }

    @Override
    public boolean update(Long id, String account_code, String account_name) {
        return expenseAccountMapper.update(id, account_code, account_name);
    }

    @Override
    public void alterAUTO() {
        expenseAccountMapper.alterAUTO();
    }
}
