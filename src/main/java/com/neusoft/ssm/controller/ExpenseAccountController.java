package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.ExpenseAccountService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 费用科目控制类
 * 实现费用科目增删改查
 * @author Nebula
 * @version 1.20 2019/06/28
 * */

@Controller
@RequestMapping("account")
public class ExpenseAccountController {

    @Autowired
    ExpenseAccountService expenseAccountService;

    /**存放模糊搜索关键字*/
    String keyword = null; //模糊搜索全局变量

    /**
     * 费用科目添加
     * @param account_code 费用科目代码
     * @Param account_name 费用科目名称
     * @return message(int) 返回操作状态代码
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(String account_code, String account_name) {
        int message = 1;
        try{
            Integer sign = expenseAccountService.findSame(account_code, account_name);
            if(sign != null) {
                if(sign == 0) {
                    message = 2;
                    return message;
                }
            }
            expenseAccountService.alterAUTO();
            boolean flag = expenseAccountService.add(account_code, account_name);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 费用科目编辑
     * @param account_code 费用科目代码
     * @Param account_name 费用科目名称
     * @Param code 原编码
     * @Param name 原名称
     * @return message(int) 返回操作状态代码
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public int update(Long id, String account_code, String account_name, String code, String name) {
        int message = 1;
        try{
            Integer sign = expenseAccountService.findEditSame(account_code, code, account_name, name);
            if(sign != null) {
                if (sign == 0) {
                    message = 2;
                    return message;
                }
            }
            boolean flag = expenseAccountService.update(id, account_code, account_name);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 费用科目删除
     * @param id 费用科目数据的id
     * @return resultDTO(ResultDTO<Integer>) 返回操作状态代码
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> delete(Long[] id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try{
            for(Long i : id){
                expenseAccountService.delete(i);
                expenseAccountService.alterAUTO();
            }
            expenseAccountService.alterAUTO();
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(1);
        }catch (Exception e){
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    /**
     * 生成费用科目列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<ExpenseAccount> list = null;

        try {
            PageHelper.startPage(page, limit);
            if(keyword == null || keyword.equals(""))
                list = expenseAccountService.findAll();
            else
                list = expenseAccountService.select(keyword);

            PageInfo<ExpenseAccount> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    /**
     * 接收模糊搜索关键字
     * @param key 模糊搜索关键字
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public void select(String key) {
        keyword = key;
    }

    /**
     * 实现表格数据刷新
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        keyword = null;
    }

    /**
     * 跳转至添加数据弹窗
     */
    @RequestMapping(value = "/addUI")
    public String Toadd() {
        return "finance/add_account";
    }

    /**
     * 跳转至编辑数据弹窗
     */
    @RequestMapping(value = "/editUI")
    public String Toedit() {
        return "finance/edit_account";
    }
}
