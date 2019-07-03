package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Dispense;
import com.neusoft.ssm.bean.Dispensecategory;
import com.neusoft.ssm.bean.Drugs;
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

/**
 * 收费退费控制类
 * 实现费用科目增删改查和患者费用查询
 * @author Nebula
 * @version 1.30 2019/06/29
 * */

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

    /**存放查找患者信息的病历号*/
    String num = null;
    /**存放查询收费列表的患者病历号*/
    String search = null;
    /**存放查询收费列表的开始日期*/
    Date startDate = null;
    /**存放查询收费列表的结束日期*/
    Date endDate = null;

    /**
     * 跳转至收费弹窗
     */
    @RequestMapping(value = "/chargeUI")
    public String ToCharge() {
        return "expense/charge_expense";
    }

    /**
     * 跳转至退费弹窗
     */
    @RequestMapping(value = "/refundUI")
    public String ToRefund() {
        return "expense/refund_expense";
    }

    /**
     * 生成收费项目信息列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
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
                else if(s.getExpense_category().contains("YF")) {
                    Drugs drug = expenseService.findDrugByCode(s.getExpense_id());
                    s.setExpense_category(expenseAccountService.findByCode(s.getExpense_category()));
                    s.setExpense_name(drug.getDrugsname());
                    s.setSpecifications(drug.getDrugsformat());
                    s.setUnit(drug.getDrugsunit());
                    s.setUnit_price(drug.getDrugsprice().doubleValue());
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

    /**
     * 获取查询收费列表的参数
     * @param medical_record_no 分页页数请求
     * @Param start 开始日期
     * @Param end 结束日期
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public void searchlist(String medical_record_no, Date start, Date end) {
        search = medical_record_no;
        startDate = start;
        endDate = end;
    }

    /**
     * 生成查询到的患者收费信息列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/searchlist", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> searchlist(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Expense> list = null;

        try {
            if(search == null || startDate == null || endDate == null) {
                return resultDTO;
            }
            else {
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
                    else if(s.getExpense_category().contains("YF")) {
                        Drugs drug = expenseService.findDrugByCode(s.getExpense_id());
                        s.setExpense_category(expenseAccountService.findByCode(s.getExpense_category()));
                        s.setExpense_name(drug.getDrugsname());
                        s.setSpecifications(drug.getDrugsformat());
                        s.setUnit(drug.getDrugsunit());
                        s.setUnit_price(drug.getDrugsprice().doubleValue());
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

    /**
     * 收费
     * @param id 收费条目的id
     * @Param real_expense 实收金额
     * @Param pay_category 付款类型
     * @Param pay_sign 付款标志
     * @Param expense_date 付款日期
     * @return message(int) 返回操作状态代码
     */
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
            //收费后更新检查检验里面对应的项目为已收费
            Expense expense = expenseService.getExpenceById(id);
            if(expense.getExpense_category().equals("CTJCF")||expense.getExpense_category().equals("JYAN")||expense.getExpense_category().equals("CZF")){
               String medical_record_no = expense.getMedical_record_no();
               String itemcode = expense.getExpense_id();
               Integer examInfoId = expenseService.getInfoId(medical_record_no,itemcode);
               //将检查检验明细里面的项目更新
                expenseService.updateStatus(examInfoId);
            }
            //往Dispense表里面插入药品
            if(expense.getExpense_category().contains("YF")){
                String medical_record_no = expense.getMedical_record_no();
                String itemcode = expense.getExpense_id();
                String patient_name = expenseService.getPatientName(medical_record_no);
                Dispense dispense = new Dispense();
                Date createtime= new java.sql.Date(new java.util.Date().getTime());
                if(expenseService.getDispenseNum(medical_record_no)==0){
                    dispense.setMedicalrecordid(medical_record_no);
                    dispense.setPatientname(patient_name);
                    dispense.setDoctorid(1);
                    dispense.setDispensestatus(0);
                    dispense.setDispensedate(createtime);
                    expenseService.insertDispense(dispense);
                }
                Dispensecategory dispensecategory = new Dispensecategory();
                dispensecategory.setMedicalrecordno(medical_record_no);
                dispensecategory.setMedicineid(Integer.valueOf(expense.getExpense_id()));
                Drugs drugs = new Drugs();
                drugs = expenseService.findDrugByCode(expense.getExpense_id());
                dispensecategory.setMedicinename(drugs.getDrugsname());
                dispensecategory.setFormat(drugs.getDrugsformat());
                dispensecategory.setAmount(expense.getNumber().intValue());
                dispensecategory.setUnit(drugs.getDrugsunit());
                dispensecategory.setPrice(drugs.getDrugsprice());
                dispensecategory.setManufacturer(drugs.getManufacturer());
                dispensecategory.setDispensestatus(0);
                expenseService.insertDispenselog(dispensecategory);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 退费
     * @param id 退费条目的id
     * @Param number 退费项目数量
     * @Param expense 应付金额
     * @Param real_expense 实收金额
     * @Param pay_sign 付款标志
     * @Param expense_date 付款日期
     * @return message(int) 返回操作状态代码
     */
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ResponseBody
    public int refund(Long id, Long number, Double expense, Double real_expense, String pay_sign, Date expense_date) {
        int message = 1;
        try{
            Expense e = expenseService.findById(id);
            if(e.getIs_consume().equals("1")) {
                message = 2;
                return message;
            }
            refundService.alterAUTO();
            boolean sign = refundService.add(e.getMedical_record_no(), e.getExpense_category(), e.getExpense_id(), e.getPrescribe_id(), e.getNumber() - number, e.getExpense() - expense, e.getPay_category(), "0", expense_date);
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

    /**
     * 按病历号获取患者信息
     * @param medical_record_no 患者病历号
     * @return info(String[]) 返回患者信息数组
     */
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

    /**
     * 按病历号计算患者收费项目的合计金额
     * 病历号来自于获取患者信息时的num
     * @return info(Double[]) 返回患者合计金额数组
     */
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

    /**
     * 获取退药数量
     * @param id 收费项目id
     * @return num(Integer) 返回退药数量
     */
    @RequestMapping(value = "/refundDrug", method = RequestMethod.POST)
    @ResponseBody
    public Integer refundDrug(Long id) {
        Integer num = 0;
        try{
            Expense es = expenseService.findById(id);
            num = expenseService.findRefundDrugNum(es.getMedical_record_no(), es.getExpense_id(), es.getPrescribe_id());
            if(num == null)
                num = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 实现收费页面表格数据刷新
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        num = null;
    }

    /**
     * 实现患者收费信息查询页面表格数据刷新
     */
    @RequestMapping(value = "/searchRefresh", method = RequestMethod.GET)
    @ResponseBody
    public void searchRefresh() {
        search = null;
        startDate = null;
        endDate = null;
    }
}
