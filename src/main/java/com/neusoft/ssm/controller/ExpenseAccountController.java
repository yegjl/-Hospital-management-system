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

@Controller
@RequestMapping("account")
public class ExpenseAccountController {

    @Autowired
    ExpenseAccountService expenseAccountService;

    String keyword = null; //模糊搜索全局变量

    //增加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(String account_code, String account_name) {
        int message = 1;
        try{
            expenseAccountService.alterAUTO();
            boolean flag = expenseAccountService.add(account_code, account_name);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //编辑
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public int update(Long id, String account_code, String account_name) {
        int message = 1;
        try{
            boolean flag = expenseAccountService.update(id, account_code, account_name);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //删除
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

    //提取列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<ExpenseAccount> list = null;

        try {
            PageHelper.startPage(page, limit);
            System.out.println("11111111111111111111111111111111111111111:" + keyword);
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

    //模糊搜索
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public void select(String key) {
        keyword = key;
    }

    //刷新
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        keyword = null;
    }

    //跳转至添加页面
    @RequestMapping(value = "/addUI")
    public String Toadd() {
        return "finance/add_account";
    }

    //跳转至编辑页面
    @RequestMapping(value = "/editUI")
    public String Toedit() {
        return "finance/edit_account";
    }
}
