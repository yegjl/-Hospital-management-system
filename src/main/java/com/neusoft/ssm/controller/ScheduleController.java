package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.ScheduleResult;
import com.neusoft.ssm.bean.ScheduleRule;
import com.neusoft.ssm.bean.schedule;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.*;
import com.neusoft.ssm.util.DBTool;
import com.neusoft.ssm.util.DateTool;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("schedule")
public class ScheduleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScheduleRuleService scheduleRuleService;

    @Autowired
    private ScheduleResultService scheduleResultService;

    @Autowired
    RegistrationLevelService registrationlevelService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DepartmentService departmentService;

    String keyword = null;

    //跳转至添加页面
    @RequestMapping(value = "/addUI")
    public String Toadd() {
        return "schedule/add_schedule";
    }

    //跳转至编辑页面
    @RequestMapping(value = "/editUI")
    public String Toedit() {
        return "schedule/edit_schedule";
    }

    //跳转至删除页面
    @RequestMapping(value = "/delUI")
    public String Todel() {
        return "schedule/del_schedule";
    }

    //添加排班规则
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num) {
        java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

        int message = 1;
        try{
            String type = departmentService.findTypeByCode(doctorService.findDeptCodeById(doctor_id));
            if(scheduleRuleService.findByIdAndDate(doctor_id, week_time) != null) {
                message = 2;
                return message;
            }
            if(type.equals("2")) {
                message = 3;
                return message;
            }

            scheduleRuleService.alterAUTO();
            boolean flag = scheduleRuleService.add(doctor_id, week_time, register_level, noon_level, limit_num, sqlDate);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //规则列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<ScheduleRule> list = null;

        try {
            PageHelper.startPage(page, limit);
            if(keyword == null)
                list = scheduleRuleService.findAll();
            else
                list = scheduleRuleService.findByAll(keyword);
            for(ScheduleRule sr : list) {
                sr.setDoctor_name(doctorService.findNameById(sr.getDoctor_id()));
                sr.setDepartment_name(departmentService.findNameById(doctorService.findDeptCodeById(sr.getDoctor_id())));
                sr.setDate(new Date(sr.getOperate_date().getTime()));
            }

            List<schedule> list1 = new ArrayList<schedule>();

            for(int i = 0; i < list.size(); i++) {
                schedule s = new schedule();
                s.setId(list.get(i).getId());
                s.setDoctor_id(list.get(i).getDoctor_id());
                s.setWeek_time(DBTool.dbToWeek(list.get(i).getWeek_time()));
                s.setRegister_level(registrationlevelService.findByCode(list.get(i).getRegister_level()).getNumbername());
                s.setNoon_level(DBTool.dbToNoon(list.get(i).getNoon_level()));
                s.setLimit_num(list.get(i).getLimit_num());
                s.setDoctor_name(list.get(i).getDoctor_name());
                s.setDepartment_name(list.get(i).getDepartment_name());
                s.setDate(DateTool.SqlToString(list.get(i).getOperate_date()));
                list1.add(s);
            }

            PageInfo<schedule> pageInfo = new PageInfo<>(list1);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list1)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> deleteById(Long[] id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(Long i : id){
                scheduleRuleService.deleteById(i);
            }
            scheduleRuleService.alterAUTO();
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(1);
            return resultDTO;
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //修改排班规则
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public int update(Long id, Long doctor_id, String week_time, String register_level, String noon_level, Integer limit_num) {
        java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

        int message = 1;
        try{
            boolean flag = scheduleRuleService.update(id, doctor_id, week_time, register_level, noon_level, limit_num, sqlDate);
            if(flag == false)
                message = 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    //生成排班表
    @RequestMapping(value = "createSchedule", method = RequestMethod.POST)
    @ResponseBody
    public int create(Date startDate, Date endDate) throws ParseException {
        int message = 0;

        try{
            List<String> dateList = DateTool.getEveryday(startDate, endDate);
            List<ScheduleRule> rule = scheduleRuleService.findAll();
            List<ScheduleResult> result = new ArrayList<ScheduleResult>();
            List<ScheduleResult> list = scheduleResultService.findAll();

            for(String s : dateList) {
                for(int i = 0; i < list.size(); i++) {
                    if(s.equals(DateTool.getDateToString(list.get(i).getDateTime())))
                        scheduleResultService.deleteByDate(list.get(i).getDateTime());
                }
            }
            scheduleResultService.alterAUTO();

            int a = 0;
            boolean flag = true;
            while(flag) {
                String week = DateTool.dayToWeek(dateList.get(a));
                for(int i = 0; i < rule.size(); i++) {
                    if(DBTool.dbToWeek(rule.get(i).getWeek_time()).equals(week)) {
                        ScheduleResult scheduleResult = new ScheduleResult();
                        scheduleResult.setDateTime(DateTool.getStringToDate(dateList.get(a)));
                        scheduleResult.setDoctor_id(rule.get(i).getDoctor_id());
                        scheduleResult.setRegister_level(rule.get(i).getRegister_level());
                        scheduleResult.setNoon_level(rule.get(i).getNoon_level());
                        scheduleResult.setLimit_num(rule.get(i).getLimit_num());
                        scheduleResult.setRemain_num(rule.get(i).getLimit_num());
                        scheduleResult.setDepartment_id(doctorService.findDeptCodeById(rule.get(i).getDoctor_id()));
                        result.add(scheduleResult);
                    }
                }
                if(a == dateList.size() - 1)
                    flag = false;
                a++;
            }

            scheduleResultService.alterAUTO();
            for(ScheduleResult s : result) {
                scheduleResultService.alterAUTO();
                scheduleResultService.add(s.getDateTime(), s.getDoctor_id(), s.getDepartment_id(), s.getRegister_level(), s.getNoon_level(), s.getLimit_num(), s.getRemain_num());
                scheduleResultService.alterAUTO();
            }
            message = 1;
        }catch (Exception e){
            e.printStackTrace();
            message = -1;
        }
        return message;
    }

    //提取排班表
    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listschedule(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<ScheduleResult> list = null;

        try {
            PageHelper.startPage(page, limit);
            list = scheduleResultService.findAll();
            for(ScheduleResult s : list) {
                s.setDate(DateTool.getDateToString(s.getDateTime()));
                s.setNoon_level(DBTool.dbToNoon(s.getNoon_level()));
                s.setRegister_level(registrationlevelService.findByCode(s.getRegister_level()).getNumbername());
                s.setDoctor_name(doctorService.findNameById(s.getDoctor_id()));
                s.setDepartment_name(departmentService.findNameById(doctorService.findDeptCodeById(s.getDoctor_id())));
            }

            PageInfo<ScheduleResult> pageInfo = new PageInfo<>(list);
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

    //提取医生姓名
    @RequestMapping(value = "/getDoctorName/{doctor_id}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDoctorName(@PathVariable("doctor_id") long id) {
        String name =  doctorService.findNameById(id);
        return name;
    }

    //提取科室名称
    @RequestMapping(value = "/getDepartmentName/{doctor_id}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDepartmentName(@PathVariable("doctor_id") long id) {
        String name =  departmentService.findNameById(doctorService.findDeptCodeById(id));
        return name;
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

}
