package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.*;
import com.neusoft.ssm.util.DBTool;
import com.neusoft.ssm.util.DateTool;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    RegisterService registerService;

    @Autowired
    ExpenseAccountService expenseAccountService;

    @Autowired
    FmeditemService fmeditemService;

    @Autowired
    RefundService refundService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    FeetypeService feetypeService;

    String num = null;
    String search = null;
    Date startDate = null;
    Date endDate = null;

    //跳转至收费页面
    @RequestMapping(value = "/chargeUI")
    public String ToCharge() {
        return "expense/charge_expense";
    }

    //跳转至退费页面
    @RequestMapping(value = "/refundUI")
    public String ToRefund() {
        return "expense/refund_expense";
    }

    //获取收费项目列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Expense> list = null;

        try {
            PageHelper.startPage(page, limit);
            list = expenseService.findByRecord(num);
            for(Expense s : list) {
                if(s.getExpense_category().equals("GHF")) {
                    s.setExpense_category(expenseAccountService.findByCode("GHF"));
                    s.setExpense_name("门诊挂号");
                    s.setSpecifications("次");
                    s.setUnit("次");
                    s.setUnit_price(s.getExpense());
                }
                else {
                    s.setExpense_category(expenseAccountService.findByCode(s.getExpense_category()));
                    s.setExpense_name(fmeditemService.findByItemCode(s.getExpense_id()).getItemname());
                    s.setSpecifications(fmeditemService.findByItemCode(s.getExpense_id()).getFormat());
                    s.setUnit("次");
                    s.setUnit_price(fmeditemService.findByItemCode(s.getExpense_id()).getPrice());
                }
                s.setDate(DateTool.getDateToString(s.getExpense_date()));
                s.setPay_category(DBTool.dbToPayCategory(s.getPay_category()));
                s.setPay_sign(DBTool.dbToPaySign(s.getPay_sign()));
                s.setDay_settle_sign(DBTool.dbToDaySign(s.getDay_settle_sign()));
            }

            PageInfo<Expense> pageInfo = new PageInfo<>(list);
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

    //查询收费列表
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public void searchlist(String medical_record_no, Date start, Date end) {
        search = medical_record_no;
        startDate = start;
        endDate = end;
    }

    //返回查询到的收费列表
    @RequestMapping(value = "/searchlist", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> searchlist(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Expense> list = null;

        try {
            PageHelper.startPage(page, limit);
            list = expenseService.search(search, startDate, endDate);

            for(Expense s : list) {
                if(s.getExpense_category().equals("GHF")) {
                    s.setExpense_category(expenseAccountService.findByCode(s.getExpense_category()));
                    s.setExpense_name("门诊挂号");
                    s.setSpecifications("次");
                    s.setUnit("次");
                    s.setUnit_price(s.getExpense());
                }
                else {
                    s.setExpense_category(expenseAccountService.findByCode(s.getExpense_category()));
                    s.setExpense_name(fmeditemService.findByItemCode(s.getExpense_id()).getItemname());
                    s.setSpecifications(fmeditemService.findByItemCode(s.getExpense_id()).getFormat());
                    s.setUnit("次");
                    s.setUnit_price(fmeditemService.findByItemCode(s.getExpense_id()).getPrice());
                }
                s.setDate(DateTool.getDateToString(s.getExpense_date()));
                s.setPay_category(DBTool.dbToPayCategory(s.getPay_category()));
                s.setPay_sign(DBTool.dbToPaySign(s.getPay_sign()));
                s.setDay_settle_sign(DBTool.dbToDaySign(s.getDay_settle_sign()));
            }

            PageInfo<Expense> pageInfo = new PageInfo<>(list);
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

    //收费
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    @ResponseBody
    public int charge(Long id, Double real_expense, String pay_category, String pay_sign, Date expense_date) {
        int message = 1;
        try{
            boolean flag = expenseService.charge(id, real_expense, pay_category, pay_sign, expense_date);
            if(flag == true)
                message = 1;
            else {
                message = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //退费
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ResponseBody
    public int refund(Long id, Long number, Double expense, Double real_expense, String pay_sign, Date expense_date) {
        int message = 1;
        try{
            Expense e = expenseService.findById(id);
            boolean sign = refundService.add(e.getMedical_record_no(), e.getExpense_category(), e.getExpense_id(), e.getNumber() - number, e.getExpense() - expense, e.getPay_category(), "0", expense_date);
            boolean flag = expenseService.refund(id, number, expense, real_expense, pay_sign, expense_date);
            if(flag == true || sign == true)
                message = 1;
            else {
                message = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //获取患者姓名
    @RequestMapping(value = "/info/{medical_record_no}")
    @ResponseBody
    public String[] patientInfo(@PathVariable String medical_record_no) {
        String[] info = new String[20];
        num = medical_record_no;
        if(registerService.findByRecord(medical_record_no) == null) {
            info[0] = "null";
            return info;
        }

        String name = registerService.findByRecord(medical_record_no).getPatient_name();
        String gender = DBTool.dbToGender(registerService.findByRecord(medical_record_no).getGender());
        String age = registerService.findByRecord(medical_record_no).getAge() + "";
        String birthday = DateTool.getDateToString(registerService.findByRecord(medical_record_no).getBirthday());
        String id_card = registerService.findByRecord(medical_record_no).getIdentity_card_no();
        String settle = feetypeService.findById(registerService.findByRecord(medical_record_no).getSettle_accounts_category());
        String medical = DBTool.dbToMedicalCategory(registerService.findByRecord(medical_record_no).getMedical_category());
        String doctor = doctorService.findNameById(registerService.findByRecord(medical_record_no).getDoctor_id());
        String department = departmentService.findNameById(doctorService.findDeptCodeById(registerService.findByRecord(medical_record_no).getDoctor_id()));

        info[0] = name;
        info[1] = gender;
        info[2] = age;
        info[3] = birthday;
        info[4] = id_card;
        info[5] = settle;
        info[6] = medical;
        info[7] = doctor;
        info[8] = department;

        return info;
    }

    //合计金额
    @RequestMapping(value = "/total", method = RequestMethod.GET)
    @ResponseBody
    public Double[] total() {
        Double[] info = new Double[1000];
        List<Expense> list = expenseService.findByRecord(num);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getPay_sign().equals("0") || list.get(i).getPay_sign().equals("3"))
                info[i] = list.get(i).getExpense();
        }
        return info;
    }

    //收费页面刷新
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        num = null;
    }

    //查询页面刷新
    @RequestMapping(value = "/searchRefresh", method = RequestMethod.GET)
    @ResponseBody
    public void searchRefresh() {
        search = null;
        startDate = null;
        endDate = null;
    }
}
