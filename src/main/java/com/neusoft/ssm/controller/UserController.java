package com.neusoft.ssm.controller;

import com.neusoft.ssm.bean.User;
import com.neusoft.ssm.service.IUserService;
import com.neusoft.ssm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 登录跳转控制类
 * 实现登录、注册、忘记密码、数据加密和页面跳转
 * @author Nebula
 * @version 1.20 2019/06/28
 * */

@Controller
@RequestMapping("login")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转至登录页面
     */
    @RequestMapping("/login")
    public String toLogin() {
        return "login/login";
    }

    /**
     * 登录
     * @param login_name 用户名
     * @Param password 密码
     * @Param request 返回值
     * @Param session 连接
     * @return message(int) 返回操作状态代码和数据
     */
    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    @ResponseBody
    public int login(String login_name, String password, HttpServletRequest request, HttpSession session) {
        String passwordByMd5 = MD5.MD5(password);
        String lgName = request.getParameter("login_name");
        String lgCate = request.getParameter("category");
        request.getSession().setAttribute("lgName", lgName);
        request.getSession().setAttribute("lgCate", lgCate);

        session.setAttribute("user_name", login_name);

        int count = userService.login(login_name, passwordByMd5);
        int message = 0;
        String category = userService.selectCategory(login_name);

        if (count == 1 && category.equals("01")) {
            message = 1;
        }
        else if(count == 1 && category.equals("02")) {
            message = 2;
        }
        else if(count == 1 && category.equals("03")) {
            message = 3;
        }
        else if(count == 1 && category.equals("04")) {
            message = 4;
        }
        else if(count == 1 && category.equals("05")) {
            message = 5;
        }
        else if(count == 1 && category.equals("06")) {
            message = 6;
        }
        else {
            message = 0;
        }
        int data = message;
        request.getSession().setAttribute("data", data);
        return message;
    }

    /**
     * 跳转至挂号收费员主页
     */
    @RequestMapping(value = "/index01")
    public String index01() { return "fifthpart/ODW_index"; }

    /**
     * 跳转至门诊医生主页
     */
    @RequestMapping(value = "/index02")
    public String index02() { return  "department/department"; }

    /**
     * 跳转至医技医生主页
     */
    @RequestMapping(value = "/index03")
    public String index03() { return  "fifthpart/YSGZZ_index"; }

    /**
     * 跳转至药房操作员主页
     */
    @RequestMapping(value = "/index04")
    public String index04() { return  "Pharmacy_Workstation/PW_index"; }

    /**
     * 跳转至财务管理员主页
     */
    @RequestMapping(value = "/index05")
    public String index05() { return  "register/register"; }

    /**
     * 跳转至医院管理员主页
     */
    @RequestMapping(value = "/index06")
    public String index06() { return  "expense/expense"; }

    @RequestMapping(value = "/index07")
    public String index07() { return  "Pharmacy_Workstation/PW_index"; }

    @RequestMapping(value = "/index08")
    public String index08() { return  "expense/daily_settle"; }

    @RequestMapping(value = "/index09")
    public String index09() { return  "schedule/schedule"; }

    @RequestMapping(value = "/index10")
    public String index10() { return  "finance/expense_account"; }

    @RequestMapping(value = "/index11")
    public String index11() { return  "finance/settle_check"; }

    @RequestMapping(value = "/index12")
    public String index12() { return  "expense/search_expense"; }

    @RequestMapping(value = "/index13")
    public String index13() { return  "statistic/dept_statistic"; }

    @RequestMapping(value = "/index14")
    public String index14() { return  "statistic/doc_statistic"; }
    //实现注册
    @RequestMapping(value = "/implAdd", method = RequestMethod.POST)
    @ResponseBody
    public int add(String login_name, String password, String category, String question, String answer) {
        String passwordByMd5 = MD5.MD5(password);
        String answerByMd5 = MD5.MD5(answer);
        int findUserByLgName = userService.findUserByLgName(login_name);
        int message;
        if (login_name.length() == 0 || password.length() == 0) {
            message = -1;
        } else if (findUserByLgName == 0) {
            userService.register(login_name, passwordByMd5, category, question, answerByMd5);
            message = 1;
        } else {
            message = 0;
        }
        return message;
    }

    /**
     * 跳转至首页
     */
    @RequestMapping(value = "/return")
    public String returnIndex() { return "login/login"; }

    /**
     * 注销
     * @Param session 连接
     * @return (String) 返回主页
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("lgName");
        session.removeAttribute("data");
        session.invalidate();
        return "login/login";
    }

    /**
     * 跳转至排班页面
     */
    @RequestMapping(value = "/schedule")
    public String schedule() {
        return "schedule/schedule";
    }

    /**
     * 跳转至挂号页面
     */
    @RequestMapping(value = "/register")
    public String register() {
        return "register/register";
    }

    /**
     * 跳转至收费页面
     */
    @RequestMapping(value = "/expense")
    public String expense() {
        return "expense/expense";
    }

    /**
     * 跳转至患者费用查询页面
     */
    @RequestMapping(value = "/search")
    public String search_expense() {
        return "expense/search_expense";
    }

    /**
     * 跳转至日结页面
     */
    @RequestMapping(value = "/settle")
    public String settle() {
        return "expense/daily_settle";
    }

    /**
     * 跳转至费用科目管理页面
     */
    @RequestMapping(value = "/account")
    public String account() {
        return "finance/expense_account";
    }

    /**
     * 跳转至门诊日结核对页面
     */
    @RequestMapping(value = "/check")
    public String check() {
        return "finance/settle_check";
    }

    /**
     * 跳转至门诊科室工作量统计页面
     */
    @RequestMapping(value = "/statistic")
    public String statistic() {
        return "statistic/dept_statistic";
    }

    /**
     * 跳转至门诊医生工作量统计页面
     */
    @RequestMapping(value = "/statistic2")
    public String statistic2() {
        return "statistic/doc_statistic";
    }

    /**
     * 忘记密码，重置密码
     * @Param login_name 用户名
     * @Param password 密码
     * @Param request 返回值
     * @Param session 连接
     * @return message(int) 返回操作状态代码和数据
     */
    @RequestMapping("/verify")
    @ResponseBody
    public int verify(String login_name, String password, String answer, HttpServletRequest request, HttpSession session) {
        User user = userService.findUserById(login_name);
        String re_answer = user.getAnswer();
        String answerByMd5 = MD5.MD5(answer);
        int message = 0;
        if(re_answer.equals(answerByMd5) == true) {
            String passwordByMd5 = MD5.MD5(password);
            User newUser = new User();
            newUser.setLogin_name(login_name);
            newUser.setPassword(passwordByMd5);
            boolean i = userService.updateUser(newUser);
            if(i == true)
                message = 1;
            else
                message = 0;
        }
        else
            message = 0;
        return message;
    }

    /**
     * 获取密保问题
     * @Param login_name 用户名
     * @return user(User) 返回数据
     */
    @RequestMapping("/getQue/{login_name}")
    @ResponseBody
    public User getQue(@PathVariable String login_name) {
        User user =  userService.findUserById(login_name);
        return user;
    }

    /**
     * 对cookie里的密码加密
     * @Param password 密码
     * @return passwd(String) 返回加密后的密码
     * @throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
     */
    @RequestMapping(value = "/getlock", method = RequestMethod.POST)
    @ResponseBody
    public String getlock(String password) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String passwd = MD5.KL(password);
        return passwd;
    }

    /**
     * 对cookie里的密码解密
     * @Param password 加密的密码
     * @return passwd(String) 返回解密后的密码
     * @throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
     */
    @RequestMapping(value = "/getdelock", method = RequestMethod.POST)
    @ResponseBody
    public String getdelock(String password) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String passwd = MD5.JM(password);
        return passwd;
    }
}
