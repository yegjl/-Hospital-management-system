package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.DepartmentService;
import com.neusoft.ssm.service.DoctorService;
import com.neusoft.ssm.service.StatisticService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计控制类
 * 实现门诊开单、执行科室工作量统计和门诊医生工作量统计
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DoctorService doctorService;

    /**存放开单科室统计开始日期*/
    String startDate = null;
    /**存放开单科室统计结束日期*/
    String endDate = null;
    /**存放执行科室统计开始日期*/
    String sDate = null;
    /**存放执行科室统计结束日期*/
    String eDate = null;
    /**存放门诊医生统计开始日期*/
    String sdate = null;
    /**存放门诊医生统计结束日期*/
    String edate = null;

    /**
     * 获取表格的表头数据
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/listTitle", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<JSONArray> listTitle() {
        List<ExpenseAccount> title = statisticService.findTitle();
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        for(int i = 0; i < title.size(); i++) {
            if(title.get(i).getAccount_code().contains("JCF")) {
                title.get(i).setAccount_name("检查费");
                title.get(i).setAccount_code("JCF");
            }
            else if(title.get(i).getAccount_code().contains("CLF")) {
                title.get(i).setAccount_name("材料费");
                title.get(i).setAccount_code("CLF");
            }
        }
        for(int i = 0; i < title.size() - 1; i++) {
            for(int j = title.size() - 1; j > i; j--) {
                if(title.get(j).getAccount_name().equals(title.get(i).getAccount_name()))
                    title.remove(j);
            }
        }
        resultDTO.setStatus(0);
        resultDTO.setMessage("");
        resultDTO.setData(JSONArray.fromObject(title)); //将list转为JSON格式传至前端
        return resultDTO;
    }

    /**
     * 返回开单科室工作量统计列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/deptList", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> searchlist(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Statistic> list = deptList(startDate, endDate, "1");

            //PageHelper.startPage(page, limit);
            //PageInfo<Statistic> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            //resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    /**
     * 返回执行科室工作量统计列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/ZdeptList", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> selectlist(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Statistic> list = deptList(sDate, eDate, "2");

            //PageHelper.startPage(page, limit);
            //PageInfo<Statistic> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            //resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    /**
     * 生成科室工作量统计列表
     * @param date1 开始日期
     * @Param date2 结束日期
     * @Param type 科室类型
     * @return list(List<Statistic>) 返回操作状态代码和数据
     */
    public List<Statistic> deptList(String date1, String date2, String type) {
        List<Department> deptList = statisticService.findDeptType(type);
        List<Statistic> list = new ArrayList<>(deptList.size());
        List<Statistic> slist = null;
        Long num = (long) 0;
        Double CLF = 0.0, CZF = 0.0, GHF = 0.0, XYF = 0.0, ZCHYF = 0.0, ZCYF = 0.0, ZLF = 0.0, JCF = 0.0, JYF = 0.0, MZF = 0.0, MZYF = 0.0, MZSSF = 0.0, QT = 0.0;

        if(date1 == null || date2 == null) {
        }
        else {
            for(int i = 0; i < deptList.size(); i++) {
                String code = deptList.get(i).getDeptcode();
                Statistic s = new Statistic();
                if(type.equals("1")) {
                    slist = statisticService.ToFindExpense(date1, date2, code);
                    s.setNum(statisticService.findNum(code, date1, date2));
                    num += statisticService.findNum(code, date1, date2);
                }
                else {
                    slist = statisticService.findExpense(date1, date2, departmentService.findIdByCode(code));
                    s.setNum(statisticService.getNum(date1, date2, departmentService.findIdByCode(code)));
                    num += statisticService.getNum(date1, date2, departmentService.findIdByCode(code));
                }
                s.setName(deptList.get(i).getDeptname());
//                    if(statisticService.findNum(code, startDate, endDate) == 0) //不显示全部数据为0的科室
//                        continue;
//                    else {
                for (Statistic sc : slist) {
                    if (sc.getAccount_code().contains("CLF")) {
                        s.setCLF(sc.getTotal_expense());
                        CLF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("CZF")) {
                        s.setCZF(sc.getTotal_expense());
                        CZF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("GHF")) {
                        s.setGHF(sc.getTotal_expense());
                        GHF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("XYF")) {
                        s.setXYF(sc.getTotal_expense());
                        XYF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("ZCHYF")) {
                        s.setZCHYF(sc.getTotal_expense());
                        ZCHYF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("ZCYF")) {
                        s.setZCYF(sc.getTotal_expense());
                        ZCYF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("ZLF")) {
                        s.setZLF(sc.getTotal_expense());
                        ZLF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("JCF")) {
                        s.setJCF(sc.getTotal_expense());
                        JCF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("JYF")) {
                        s.setJYF(sc.getTotal_expense());
                        JYF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("MZF")) {
                        s.setMZF(sc.getTotal_expense());
                        MZF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("MZYF")) {
                        s.setMZYF(sc.getTotal_expense());
                        MZYF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("MZSSF")) {
                        s.setMZSSF(sc.getTotal_expense());
                        MZSSF += sc.getTotal_expense();
                    }
                    else if (sc.getAccount_code().contains("QT")) {
                        s.setQT(sc.getTotal_expense());
                        QT += sc.getTotal_expense();
                    }
                }
                //}
                list.add(s);
            }
            Statistic s = new Statistic();
            s.setName("合计");
            s.setNum(num);
            s.setXYF(XYF);
            s.setZCHYF(ZCHYF);
            s.setZCYF(ZCYF);
            s.setGHF(GHF);
            s.setZLF(ZLF);
            s.setJCF(JCF);
            s.setJYF(JYF);
            s.setCLF(CLF);
            s.setCZF(CZF);
            s.setMZF(MZF);
            s.setMZYF(MZYF);
            s.setMZSSF(MZSSF);
            s.setQT(QT);
            list.add(s);
        }
        return list;
    }

    /**
     * 返回门诊医生工作量统计列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/docList", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> docList(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Statistic> slist = null;
            List<Doctor> dlist = doctorService.findAll();
            List<Statistic> list = new ArrayList<>(dlist.size());
            Long num = (long) 0;
            Double CLF = 0.0, CZF = 0.0, GHF = 0.0, XYF = 0.0, ZCHYF = 0.0, ZCYF = 0.0, ZLF = 0.0, JCF = 0.0, JYF = 0.0, MZF = 0.0, MZYF = 0.0, MZSSF = 0.0, QT = 0.0;

            if(sdate == null || edate == null) {
            }
            else {
                for(int i = 0; i < dlist.size(); i++) {
                    Long id = dlist.get(i).getId();
                    slist = statisticService.findDocExpense(sdate, edate, id);
                    Statistic s = new Statistic();
                    s.setName(dlist.get(i).getName());
                    s.setNum(statisticService.getDocNum(sdate, edate, id));
                    num += statisticService.getDocNum(sdate, edate, id);

                    for (Statistic sc : slist) {
                        if (sc.getAccount_code().contains("CLF")) {
                            s.setCLF(sc.getTotal_expense());
                            CLF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("CZF")) {
                            s.setCZF(sc.getTotal_expense());
                            CZF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("GHF")) {
                            s.setGHF(sc.getTotal_expense());
                            GHF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("XYF")) {
                            s.setXYF(sc.getTotal_expense());
                            XYF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("ZCHYF")) {
                            s.setZCHYF(sc.getTotal_expense());
                            ZCHYF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("ZCYF")) {
                            s.setZCYF(sc.getTotal_expense());
                            ZCYF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("ZLF")) {
                            s.setZLF(sc.getTotal_expense());
                            ZLF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("JCF")) {
                            s.setJCF(sc.getTotal_expense());
                            JCF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("JYF")) {
                            s.setJYF(sc.getTotal_expense());
                            JYF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("MZF")) {
                            s.setMZF(sc.getTotal_expense());
                            MZF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("MZYF")) {
                            s.setMZYF(sc.getTotal_expense());
                            MZYF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("MZSSF")) {
                            s.setMZSSF(sc.getTotal_expense());
                            MZSSF += sc.getTotal_expense();
                        }
                        else if (sc.getAccount_code().contains("QT")) {
                            s.setQT(sc.getTotal_expense());
                            QT += sc.getTotal_expense();
                        }
                    }
                    list.add(s);
                }
                Statistic s = new Statistic();
                s.setName("合计");
                s.setNum(num);
                s.setXYF(XYF);
                s.setZCHYF(ZCHYF);
                s.setZCYF(ZCYF);
                s.setGHF(GHF);
                s.setZLF(ZLF);
                s.setJCF(JCF);
                s.setJYF(JYF);
                s.setCLF(CLF);
                s.setCZF(CZF);
                s.setMZF(MZF);
                s.setMZYF(MZYF);
                s.setMZSSF(MZSSF);
                s.setQT(QT);
                list.add(s);
            }
            //PageHelper.startPage(page, limit);
            //PageInfo<Statistic> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            //resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list)); //将list转为JSON格式传至前端
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    /**
     * 接收开单科室统计查询关键字
     * @param start 开始日期
     * @Param end 结束日期
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public void searchlist(String start, String end) {
        startDate = start;
        endDate = end;
    }

    /**
     * 接收执行科室统计查询关键字
     * @param start 开始日期
     * @Param end 结束日期
     */
    @RequestMapping(value = "/searchList", method = RequestMethod.POST)
    @ResponseBody
    public void searchlist2(String start, String end) {
        sDate = start;
        eDate = end;
    }

    /**
     * 接收门诊医生统计查询关键字
     * @param start 开始日期
     * @Param end 结束日期
     */
    @RequestMapping(value = "/searchDoc", method = RequestMethod.POST)
    @ResponseBody
    public void searchDoc(String start, String end) {
        sdate = start;
        edate = end;
    }

    /**
     * 实现开单科室表格数据刷新
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        startDate = null;
        endDate = null;
    }

    /**
     * 实现执行科室表格数据刷新
     */
    @RequestMapping(value = "/refresh2", method = RequestMethod.GET)
    @ResponseBody
    public void refresh2() {
        sDate = null;
        eDate = null;
    }

    /**
     * 实现门诊医生表格数据刷新
     */
    @RequestMapping(value = "/refreshDoc", method = RequestMethod.GET)
    @ResponseBody
    public void refreshDoc() {
        sdate = null;
        edate = null;
    }
}
