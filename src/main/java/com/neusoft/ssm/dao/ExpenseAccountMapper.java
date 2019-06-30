package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.ExpenseAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 费用科目管理接口类
 * @author Nebula
 * @version 1.20 2019/06/28
 * */

public interface ExpenseAccountMapper {

    /**
     * 按费用科目编码获取费用科目名称
     * @Param account_code 费用科目编码
     * @return (String)
     */
    String findByCode(@Param("account_code") String account_code);

    /**
     * 获取全部费用科目信息列表
     * @return (List<ExpenseAccount>)
     */
    List<ExpenseAccount> findAll();

    /**
     * 模糊搜索
     * @Param keyword 搜索关键字
     * @return (List<ExpenseAccount>)
     */
    List<ExpenseAccount> select(@Param("keyword") String keyword);

    /**
     * 增加
     * @Param account_code 费用科目编码
     * @Param account_name 费用科目名称
     * @return (boolean)
     */
    boolean add(@Param("account_code") String account_code, @Param("account_name") String account_name);

    /**
     * 删除
     * @Param id 费用科目条目的id
     * @return (boolean)
     */
    boolean delete(@Param("id") Long id);

    /**
     * 编辑
     * @Param id 费用科目条目的id
     * @Param account_code 费用科目编码
     * @Param account_name 费用科目名称
     * @return (boolean)
     */
    boolean update(@Param("id") Long id, @Param("account_code") String account_code, @Param("account_name") String account_name);

    /**
     * 增加查重
     * @Param account_code 费用科目编码
     * @Param account_name 费用科目名称
     * @return (Integer)
     */
    Integer findSame(@Param("account_code") String account_code, @Param("account_name") String account_name);

    /**
     * 编辑查重
     * @Param account_code 费用科目编码
     * @Param real_code 原编码
     * @Param account_name 费用科目名称
     * @Param real_name 原名称
     * @return (Integer)
     */
    Integer findEditSame(@Param("account_code") String account_code, @Param("real_code") String real_code, @Param("account_name") String account_name, @Param("real_name") String real_name);

    /**
     * 重置MySQL主键自增机制
     */
    void alterAUTO();

}
