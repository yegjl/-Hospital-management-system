package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.DailySettle;
import com.neusoft.ssm.bean.Expense;
import com.neusoft.ssm.bean.Refund;
import com.neusoft.ssm.bean.User;
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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 结算控制类
 * 实现收费员日结、日结明细查询和日结财务核对
 * @author Nebula
 * @version 1.20 2019/06/28
 * */

@Controller
@RequestMapping("settle")
public class SettleController {

    @Autowired
    DailySettleService dailySettleService;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    RefundService refundService;

    @Autowired
    RegisterService registerService;

    @Autowired
    ExpenseAccountService expenseAccountService;

    @Autowired
    FmeditemService fmeditemService;

    @Autowired
    IUserService iUserService;

    /**存放日结信息查询开始日期*/
    Timestamp start = null;
    /**存放日结信息查询结束日期*/
    Timestamp end = null;
    /**存放日结明细查询弹窗开始日期*/
    Timestamp startDate = null;
    /**存放日结明细查询弹窗结束日期*/
    Timestamp endDate = null;
    /**存放日结财务核对查询开始日期*/
    Timestamp sDate = null;
    /**存放日结财务核对查询结束日期*/
    Timestamp eDate = null;
    /**存放日结财务核对查询收费员id*/
    Long userId = (long) 0;

    /**
     * 接收日结信息查询关键字
     * @param start_date 开始日期
     * @Param end_date 结束日期
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public void select(Timestamp start_date, Timestamp end_date) {
        start = start_date;
        end = end_date;
    }

    /**
     * 返回日结信息列表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<DailySettle> list = null;
        if(start == null || end == null)
            return resultDTO;

        try {
            PageHelper.startPage(page, limit);
            list = dailySettleService.findByDate(start, end);
            int num = list.size();
            if(num == 0)
                return resultDTO;

            for(DailySettle d : list) {
                d.setStartDate(Timestamp.valueOf(d.getStart_date()));
                d.setEndDate(Timestamp.valueOf(d.getEnd_date()));
                d.setUsername(iUserService.findNameById(d.getUser_id()).getLogin_name());
            }

            PageInfo<DailySettle> pageInfo = new PageInfo<>(list);
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
     * 返回收费员日结时间表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listuser(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<DailySettle> list = null;

        try {
            PageHelper.startPage(page, limit);
            list = dailySettleService.findList();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for(int i = 0; i < list.size(); i++) {
                list.get(i).setStartDate(Timestamp.valueOf(list.get(i).getStart_date()));
                list.get(i).setEnd_date(sdf.format(list.get(i).getEndDate()));
                list.get(i).setUsername(iUserService.findNameById(list.get(i).getUser_id()).getLogin_name());
            }

            PageInfo<DailySettle> pageInfo = new PageInfo<>(list);
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
     * 收费员日结
     * @param start_date 开始日期
     * @Param end_date 结束日期
     * @return expense(Double) 返回日结金额
     */
    @RequestMapping(value = "/settle", method = RequestMethod.POST)
    @ResponseBody
    public Double ToSettle(Timestamp start_date, Timestamp end_date, HttpSession session) {
        Double expense = 0.0;
        List<Expense> elist = null;
        List<Refund> rlist = null;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            elist = expenseService.SettleFind(start_date, end_date);
            rlist = refundService.settleFind(start_date, end_date);
            if(elist.size() > 0) {
                for(Expense e : elist) {
                    if(e.getPay_sign().equals("1") || e.getPay_sign().equals("3"))
                        expense += e.getReal_expense();
                    expenseService.settle(e.getId());
                }
            }
            if(rlist.size() > 0) {
                for(Refund r : rlist) {
                    refundService.settle(r.getId());
                }
            }
            String id = session.getAttribute("user_name").toString(); //通过session获取登录用户的id

            dailySettleService.alterAUTO();
            dailySettleService.addSettle((long) 1, sdf.format(start_date), sdf.format(end_date), expense, "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expense;
    }

    /**
     * 接收日结明细查询关键字
     * @param start_date 开始日期
     * @Param end_date 结束日期
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public void listfind(Timestamp start_date, Timestamp end_date) {
        startDate = start_date;
        endDate = end_date;
    }

    /**
     * 返回日结明细表-收费表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/findexpense", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> findexpense(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Expense> list = null;
        try {
            PageHelper.startPage(page, limit);
            list = expenseService.find(startDate, endDate);
            if(list.size() > 0) {
                for(int i = 0; i < list.size(); i++) {
                    list.get(i).setId((long) i + 1);
                    list.get(i).setName(registerService.findByRecord(list.get(i).getMedical_record_no()).getPatient_name());
                    if(list.get(i).getExpense_category().equals("GHF"))
                        list.get(i).setExpense_name("门诊挂号");
                    else
                        list.get(i).setExpense_name(fmeditemService.findByItemCode(list.get(i).getExpense_id()).getItemname());
                    list.get(i).setExpense_category(expenseAccountService.findByCode(list.get(i).getExpense_category()));
                    list.get(i).setPay_sign(DBTool.dbToPaySign(list.get(i).getPay_sign()));
                    list.get(i).setPay_category(DBTool.dbToPayCategory(list.get(i).getPay_category()));
                    list.get(i).setDate(DateTool.getDateToString(list.get(i).getExpense_date()));
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
     * 返回日结明细表-退费表
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/findrefund", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> findrefund(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Refund> list = null;
        try {
            PageHelper.startPage(page, limit);
            list = refundService.find(startDate, endDate);
            if(list.size() > 0) {
                for(int i = 0; i < list.size(); i++) {
                    list.get(i).setId((long) i + 1);
                    list.get(i).setName(registerService.findByRecord(list.get(i).getMedical_record_no()).getPatient_name());
                    if(list.get(i).getExpense_category().equals("GHF"))
                        list.get(i).setExpense_name("门诊挂号");
                    else
                        list.get(i).setExpense_name(fmeditemService.findByItemCode(list.get(i).getExpense_id()).getItemname());
                    list.get(i).setExpense_category(expenseAccountService.findByCode(list.get(i).getExpense_category()));
                    list.get(i).setRefund_expense(list.get(i).getRefund_expense() * -1);
                    list.get(i).setPay_category(DBTool.dbToPayCategory(list.get(i).getPay_category()));
                    list.get(i).setDate(DateTool.getDateToString(list.get(i).getRefund_date()));
                }
            }
            PageInfo<Refund> pageInfo = new PageInfo<>(list);
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
     * 获取上一次日结时间
     * @return d(String) 返回上一次日结时间
     */
    @RequestMapping(value = "/lastdate", method = RequestMethod.POST)
    @ResponseBody
    public String getLastDate() {
        Timestamp date = dailySettleService.findMaxDate();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = sdf.format(date);
        return d;
    }

    /**
     * 接收日结财务核对查询关键字
     * @Param user_id 收费员id
     * @param start_date 开始日期
     * @Param end_date 结束日期
     */
    @RequestMapping(value = "/checkfind", method = RequestMethod.POST)
    @ResponseBody
    public void checkfind(Long user_id, Timestamp start_date, Timestamp end_date) {
        userId = user_id;
        sDate = start_date;
        eDate = end_date;
    }

    /**
     * 返回日结财务核对结果
     * @param page 分页页数请求
     * @Param limit 每页数量请求
     * @return resultDTO(ResultDTO<JSONArray>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/checklist", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> check(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<DailySettle> list = null;
        try {
            PageHelper.startPage(page, limit);
            list = dailySettleService.findByDateAndUser(userId, sDate, eDate);

            for(DailySettle d : list) {
                d.setUsername(iUserService.findNameById(d.getUser_id()).getLogin_name());
                d.setCheck_sign(DBTool.dbToCheck(d.getCheck_sign()));
                d.setEndDate(Timestamp.valueOf(d.getEnd_date()));
                d.setStartDate(Timestamp.valueOf(d.getStart_date()));
                if(d.getCheck_date() == null || d.getCheck_date().equals(""))
                    d.setCheck_date("无");
            }

            PageInfo<DailySettle> pageInfo = new PageInfo<>(list);
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
     * 获取收费员信息列表
     * @return resultDTO(ResultDTO<List<User>>) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<User>> getUserList() {
        ResultDTO<List<User>> resultDTO = new ResultDTO();
        List<User> list = null;
        try {
            list = iUserService.selectByList();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getCategory().equals("01"))
                    continue;
                else
                    list.remove(list.get(i));
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
     * 日结财务核对
     * @param id 日结条目id
     * @Param check_sign 核对标志
     * @Param check_date 核对日期
     * @return message(int) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public int check(Long id, String check_sign, String check_date) {
        int message = 1;
        try {
            boolean flag = dailySettleService.checkSettle(id, check_sign, check_date);
            if(flag == false)
                message = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 跳转至日结明细弹窗
     */
    @RequestMapping(value = "/detailUI")
    public String Todetail() {
        return "expense/daily_detail";
    }

    /**
     * 跳转至日结财务核对弹窗
     */
    @RequestMapping(value = "/checkUI")
    public String Tocheck() {
        return "finance/settle_confirm";
    }

    /**
     * 实现日结信息表格数据刷新
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ResponseBody
    public void refresh() {
        start = null;
        end = null;
    }

    /**
     * 实现日结财务核对表格数据刷新
     */
    @RequestMapping(value = "/checkrefresh", method = RequestMethod.GET)
    @ResponseBody
    public void checkrefresh() {
        sDate = null;
        eDate = null;
        userId = (long) 0;
    }
}
