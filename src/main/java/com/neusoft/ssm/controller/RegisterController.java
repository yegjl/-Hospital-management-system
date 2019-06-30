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

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 挂号退号控制类
 * 实现挂号退号和模糊搜索
 * @author Nebula
 * @version 1.30 2019/06/29
 * */

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
    RegistrationLevelService registrationlevelService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    FeetypeService feetypeService;

    /**用于生成唯一的病历号*/
    int serialNumber = 0;
    /**存放模糊搜索关键字*/
    String keyword = null;
    /**存放用于条件检索医生列表的挂号类别*/
    String category = null;
    /**存放用于条件检索医生列表的科室id*/
    String dept = null;

    /**
     * 挂号
     * @param medical_record_no 病历号
     * @Param patient_name 患者姓名
     * @Param gender 性别
     * @Param age 年龄
     * @Param birthday 生日
     * @Param registration_category 挂号类别
     * @Param medical_category 医疗类别
     * @Param identity_card_no 身份证号
     * @Param family_address 家庭住址
     * @Param registration_date 挂号日期
     * @Param see_doctor_date 看诊日期
     * @Param department_id 科室id
     * @Param doctor_id 医生id
     * @Param registration_source 挂号来源
     * @Param settle_accounts_category 日结标志
     * @Param is_seen_doctor 是否看诊
     * @Param status 状态
     * @Param expense 价格
     * @return message(int) 返回操作状态代码
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(String medical_record_no, String patient_name, String gender, Double age, Date birthday, String registration_category, String medical_category, String identity_card_no, String family_address, Date registration_date, Date see_doctor_date, String department_id, Long doctor_id, String registration_source, Integer settle_accounts_category, String is_seen_doctor, String status, Double expense) {
        int message = 1;
        try{
            if(scheduleResultService.findByIdAndDate(doctor_id, registration_date).getRemain_num() == 0) {
                message = 2;
                return message;
            }
            if(medical_record_no.contains(registerService.findMaxRecord() + "")) {
                message = 3;
                return message;
            }
            registerService.alterAUTO();
            boolean flag = registerService.add(medical_record_no, patient_name, gender, age, birthday, registration_category, medical_category, identity_card_no, family_address, registration_date, see_doctor_date, department_id, doctor_id, registration_source, settle_accounts_category, is_seen_doctor, status, expense);
            boolean sign = scheduleResultService.registerToNum(doctor_id, registration_date);
            expenseService.alterAUTO();
            boolean i = expenseService.registerExpense(medical_record_no, "GHF", "GHF", (long) 0, (long) 1, expense, (double) 0, "", "0", "0", registration_date, "0");
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

    /**
     * 返回挂号信息列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit, HttpSession session) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<RegistrationInfo> list = null;

        String name = session.getAttribute("user_name").toString();

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

    /**
     * 退号
     * @param id 需要退号条目的id
     * @return message(int) 返回操作状态代码
     */
    @RequestMapping(value = "/back", method = RequestMethod.POST)
    @ResponseBody
    public int back(Long id) {
        Date date = new Date();
        int message = 1;
        try{
            Date re_date = registerService.findById(id).getRegistration_date();
            if(registerService.findById(id).getStatus().equals("02"))
                message = 5;
            else if(DateTool.getDateToString(date).equals(DateTool.getDateToString(re_date)) == false)
                message = 4;
            else {
                String str = registerService.findById(id).getIs_seen_doctor();
                Expense e = expenseService.findByRecordAndDate(registerService.findById(id).getMedical_record_no(), "GHF", date);
                if(str.equals("02"))
                    message = 2;
                else {
                    if(e.getPay_sign().equals("1")) {
                        message = 3;
                    }
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
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 根据日期生成唯一的病历号
     * @return result(ResultDTO<String>) 返回操作状态代码和数据
     */
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

    /**
     * 从排班表获取值班医生列表
     * @return resultDTO(ResultDTO<ScheduleResult>) 返回操作状态代码和数据
     */
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

    /**
     * 从排班表获取值班科室列表
     * @return resultDTO(ResultDTO<ScheduleResult>) 返回操作状态代码和数据
     */
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

    /**
     * 获取结算类型列表
     * @return resultDTO(ResultDTO<List<Feetype>>) 返回操作状态代码和数据
     */
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

    /**
     * 根据挂号类别获取挂号费
     * @Param register_category 号别
     * @return expense(Double) 返回挂号费
     */
    @RequestMapping(value = "/getExpense", method = RequestMethod.POST)
    @ResponseBody
    public Double getExpense(String register_category) {
        Registrationlevel r = registrationlevelService.findByCode(register_category);
        Double expense = r.getFee();
        category = register_category;
        return expense;
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
     * 接收下拉列表选择的科室id
     * @param department_id 科室id
     */
    @RequestMapping(value = "/postDepartment", method = RequestMethod.POST)
    @ResponseBody
    public void postDepartment(String department_id) {
        dept = department_id;
    }

    /**
     * 实现表格数据刷新
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        keyword = null;
        category = null;
        dept = null;
    }
}
