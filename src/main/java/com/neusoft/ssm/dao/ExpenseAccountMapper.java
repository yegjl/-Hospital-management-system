package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.ExpenseAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpenseAccountMapper {

    String findByCode(@Param("account_code") String account_code);

    List<ExpenseAccount> findAll();

    List<ExpenseAccount> select(@Param("keyword") String keyword);

    boolean add(@Param("account_code") String account_code, @Param("account_name") String account_name);

    boolean delete(@Param("id") Long id);

    boolean update(@Param("id") Long id, @Param("account_code") String account_code, @Param("account_name") String account_name);

    void alterAUTO();

}
