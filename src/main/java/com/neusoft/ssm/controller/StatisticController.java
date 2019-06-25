package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Department;
import com.neusoft.ssm.bean.ExpenseAccount;
import com.neusoft.ssm.bean.Statistic;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.AssistService;
import com.neusoft.ssm.service.StatisticService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @Autowired
    AssistService assistService;

    String startDate = null;
    String endDate = null;

    //获取表头
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

    @RequestMapping(value = "/deptList", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> searchlist(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Department> deptList = statisticService.findDeptType("1");
            List<Statistic> list = new ArrayList<>(deptList.size());

//            List<Expense> elist = statisticService.findtest(startDate, endDate);
//            for(Expense e : elist)
//                assistService.add(e.getId(), e.getMedical_record_no(), e.getExpense_category(), e.getExpense_id(), e.getNumber(), e.getReal_expense(), e.getReal_expense(), e.getPay_category(), e.getPay_sign(), e.getDay_settle_sign(), e.getExpense_date(), e.getIs_consume());

            if(startDate == null || endDate == null) {

            }
            else {
                for(int i = 0; i < deptList.size(); i++) {
                    String code = deptList.get(i).getDeptcode();
                    List<Statistic> slist = statisticService.ToFindExpense(startDate, endDate, code);
                    Statistic s = new Statistic();
                    s.setName(deptList.get(i).getDeptname());
                    s.setNum(statisticService.findNum(code, startDate, endDate));
//                    if(statisticService.findNum(code, startDate, endDate) == 0)
//                        continue;
//                    else {
                        for(Statistic sc : slist) {
                            if(sc.getAccount_code().equals("CLF"))
                                s.setCLF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("CZF"))
                                s.setCZF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("GHF"))
                                s.setGHF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("XYF"))
                                s.setXYF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("ZCHYF"))
                                s.setZCHYF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("ZCYF"))
                                s.setZCYF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("ZLF"))
                                s.setZLF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("JCF"))
                                s.setJCF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("JYF"))
                                s.setJYF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("MZF"))
                                s.setMZF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("MZYF"))
                                s.setMZYF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("MZSSF"))
                                s.setMZSSF(sc.getTotal_expense());
                            else if(sc.getAccount_code().equals("QT"))
                                s.setQT(sc.getTotal_expense());
                        }
                    //}
                    list.add(s);
                }
//                    Statistic s = new Statistic();
//                    String code = deptList.get(i).getDeptCode();
//                    s.setName(deptList.get(i).getDeptName());
//                    s.setNum(statisticService.findNum(code, startDate, endDate));
//                    if(statisticService.findNum(code, startDate, endDate) == 0) {
//                        continue;
//                    }
//                    else {
////                        s.setCLF(statisticService.ToFindExpense("CLF", startDate, endDate, code));
////                        s.setCZF(statisticService.ToFindExpense("CZF", startDate, endDate, code));
////                        s.setGHF(statisticService.ToFindExpense("GHF", startDate, endDate, code));
////                        s.setXYF(statisticService.ToFindExpense("XYF", startDate, endDate, code));
////                        s.setZCHYF(statisticService.ToFindExpense("ZCHYF", startDate, endDate, code));
////                        s.setZCYF(statisticService.ToFindExpense("ZCYF", startDate, endDate, code));
////                        s.setZLF(statisticService.ToFindExpense("ZLF", startDate, endDate, code));
////                        s.setJCF(statisticService.ToFindExpense("JCF", startDate, endDate, code));
////                        s.setJYF(statisticService.ToFindExpense("JYF", startDate, endDate, code));
////                        s.setMZF(statisticService.ToFindExpense("MZF", startDate, endDate, code));
////                        s.setMZYF(statisticService.ToFindExpense("MZYF", startDate, endDate, code));
////                        s.setMZSSF(statisticService.ToFindExpense("MZSSF", startDate, endDate, code));
////                        s.setQT(statisticService.ToFindExpense("QT", startDate, endDate, code));
//
////                        s.setCLF(assistService.ToFindExpense("CLF", code));
////                        s.setCZF(assistService.ToFindExpense("CZF", code));
////                        s.setGHF(assistService.ToFindExpense("GHF", code));
////                        s.setXYF(assistService.ToFindExpense("XYF", code));
////                        s.setZCHYF(assistService.ToFindExpense("ZCHYF", code));
////                        s.setZCYF(assistService.ToFindExpense("ZCYF", code));
////                        s.setZLF(assistService.ToFindExpense("ZLF", code));
////                        s.setJCF(assistService.ToFindExpense("JCF", code));
////                        s.setJYF(assistService.ToFindExpense("JYF", code));
////                        s.setMZF(assistService.ToFindExpense("MZF", code));
////                        s.setMZYF(assistService.ToFindExpense("MZYF", code));
////                        s.setMZSSF(assistService.ToFindExpense("MZSSF", code));
////                        s.setQT(assistService.ToFindExpense("QT", code));
//                    }
//                    list.add(s);
//                }
            }

//            assistService.delete();

            PageHelper.startPage(page, limit);
            PageInfo<Statistic> pageInfo = new PageInfo<>(list);
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

    //查询
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public void searchlist(String start, String end) {
        startDate = start;
        endDate = end;
    }

    //页面刷新
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        startDate = null;
        endDate = null;
    }
}
