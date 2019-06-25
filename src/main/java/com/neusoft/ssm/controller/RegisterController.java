package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.*;
import com.neusoft.ssm.util.DBTool;
import com.neusoft.ssm.util.DateTool;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Autowired
    ScheduleResultService scheduleResultService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    RegistrationlevelService registrationlevelService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    FeetypeService feetypeService;

    int serialNumber = 0; //生成病历号
    String keyword = null; //模糊搜索全局变量
    String category = null; //挂号类别，用于条件检索医生列表
    String dept = null; //科室，用于条件检索医生列表

    //挂号添加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(String medical_record_no, String patient_name, String gender, Long age, Date birthday, String registration_category, String medical_category, String identity_card_no, String family_address, Date registration_date, Date see_doctor_date, String department_id, Long doctor_id, String registration_source, Integer settle_accounts_category, String is_seen_doctor, String status, Double expense) {
        int message = 1;
        try{
            if(scheduleResultService.findByIdAndDate(doctor_id, registration_date).getRemain_num() == 0) {
                message = 2;
                return message;
            }
            registerService.alterAUTO();
            boolean flag = registerService.add(medical_record_no, patient_name, gender, age, birthday, registration_category, medical_category, identity_card_no, family_address, registration_date, see_doctor_date, department_id, doctor_id, registration_source, settle_accounts_category, is_seen_doctor, status, expense);
            boolean sign = scheduleResultService.registerToNum(doctor_id, registration_date);
            expenseService.alterAUTO();
            boolean i = expenseService.registerExpense(medical_record_no, "GHF", "GHF", (long) 1, expense, (double) 0, "", "0", "0", registration_date, "0");
            if(flag == false)
                message = 0;
            else if(sign == false)
                message = 0;
            else if(i == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //提取挂号列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<RegistrationInfo> list = null;

        try {
            PageHelper.startPage(page, limit);
            if(keyword == null)
                list = registerService.findAll();
            else
                list = registerService.findByKey(keyword);
            for(RegistrationInfo r : list) {
                r.setDepartment_name(departmentService.findNameById(doctorService.findDeptCodeById(r.getDoctor_id())));
                r.setDoctor_name(doctorService.findNameById(r.getDoctor_id()));
                r.setDate(DateTool.getDateToString(r.getRegistration_date()));
                r.setBirthday_date(DateTool.getDateToString(r.getBirthday()));
                r.setGender(DBTool.dbToGender(r.getGender()));
                r.setSettle_category(feetypeService.findById(r.getSettle_accounts_category()));
                r.setRegistration_category(registrationlevelService.findByCode(r.getRegistration_category()).getNumbername());
                r.setIs_seen_doctor(DBTool.dbToSeen(r.getIs_seen_doctor()));
                r.setStatus(DBTool.dbToStatus(r.getStatus()));
                r.setSee_doctor_date(new Date());
            }

            PageInfo<RegistrationInfo> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return  resultDTO;
    }

    //退号
    @RequestMapping(value = "/back", method = RequestMethod.POST)
    @ResponseBody
    public int back(Long id) {
        Date date = new Date();
        int message = 1;
        try{
            String str = registerService.findById(id).getIs_seen_doctor();
            Expense e = expenseService.findByRecordAndDate(registerService.findById(id).getMedical_record_no(), "GHF", date);
            if(str.equals("02"))
                message = 2;
            else {
                if(e.getPay_sign().equals("1"))
                    message = 3;
                else if(e.getPay_sign().equals("2")) {
                    boolean flag = registerService.backRegister(id);
                    boolean i = scheduleResultService.backRegisterToNum(registerService.findById(id).getDoctor_id(), date);
                    if(flag == false || i == false)
                        message = 0;
                }
                else {
                    boolean flag = registerService.backRegister(id);
                    boolean sign = expenseService.delete(registerService.findById(id).getMedical_record_no(), "GHF", date);
                    boolean i = scheduleResultService.backRegisterToNum(registerService.findById(id).getDoctor_id(), date);
                    if(flag == false || sign == false || i == false)
                        message = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //生成病历号
    @RequestMapping(value = "/getmedicalrecordno", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<String> getNo() {
        ResultDTO<String> result = new ResultDTO();
        try {
            String max = registerService.findMaxRecord() + "";
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String strSerialNumber = format.format(new Date());
            if(max.contains(strSerialNumber)) {
                Long num = registerService.findMaxRecord() + 1;
                strSerialNumber = num + "";
            }
            else
                strSerialNumber += String.format("%05d", ++serialNumber);
            result.setStatus(0);
            result.setMessage("操作成功！");
            result.setData(strSerialNumber);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(1);
            result.setMessage("操作失败！");
        }
        return result;
    }

    //获取医生列表
    @RequestMapping(value = "/doctorlist", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<ScheduleResult>> getDoctor() {
        ResultDTO<List<ScheduleResult>> resultDTO = new ResultDTO();
        Date date = new Date();
        List<ScheduleResult> list = null;
        try {
            if(category == null || category.equals("")) {
                if(dept == null || dept.equals(""))
                    list = scheduleResultService.findById(date);
                else
                    list = scheduleResultService.findByDateAndDept(date, dept);
            }
            else {
                if(dept == null || dept.equals(""))
                    list = scheduleResultService.findByDateAndCategory(date, category);
                else
                    list = scheduleResultService.findByDateCategoryAndDept(date, category, dept);
            }
            if(list.size() > 0) {
                for(int i = 0; i < list.size(); i++) {
                    if(DateTool.NowTime(date).equals("下午")) {
                        if(DBTool.dbToNoon(list.get(i).getNoon_level()).equals("上午"))
                            list.remove(list.get(i));
                        if(list.size() > 0)
                            list.get(i).setDoctor_name(doctorService.findNameById(list.get(i).getDoctor_id()));
                    }
                    else if(DateTool.NowTime(date).equals("晚上")) {
                        if(DBTool.dbToNoon(list.get(i).getNoon_level()).equals("上午") || DBTool.dbToNoon(list.get(i).getNoon_level()).equals("下午"))
                            list.remove(list.get(i));
                        if(list.size() > 0)
                            list.get(i).setDoctor_name(doctorService.findNameById(list.get(i).getDoctor_id()));
                    }
                    else
                        list.get(i).setDoctor_name(doctorService.findNameById(list.get(i).getDoctor_id()));
                }
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //获取科室列表
    @RequestMapping(value = "/departmentlist", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<ScheduleResult>> getDepartment() {
        ResultDTO<List<ScheduleResult>> resultDTO = new ResultDTO();
        List<ScheduleResult> list = null;
        Date date = new Date();
        try {
            list = scheduleResultService.findByDept(date);
            for(ScheduleResult s : list) {
                s.setDepartment_name(departmentService.findNameById(doctorService.findDeptCodeById(s.getDoctor_id())));
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //获取结算类别列表
    @RequestMapping(value = "/feetypelist", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<Feetype>> getFeeType() {
        ResultDTO<List<Feetype>> resultDTO = new ResultDTO();
        List<Feetype> list = null;
        try {
            list = feetypeService.findAll();
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //获取挂号费
    @RequestMapping(value = "/getExpense", method = RequestMethod.POST)
    @ResponseBody
    public Double getExpense(String register_category) {
        Registrationlevel r = registrationlevelService.findByCode(register_category);
        Double expense = r.getFee();
        category = register_category;
        return expense;
    }

    //模糊搜索
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public void select(String key) {
        keyword = key;
    }

    //获取下拉列表选择的科室
    @RequestMapping(value = "/postDepartment", method = RequestMethod.POST)
    @ResponseBody
    public void postDepartment(String department_id) {
        dept = department_id;
    }

    //刷新
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        keyword = null;
        category = null;
        dept = null;
    }
}
