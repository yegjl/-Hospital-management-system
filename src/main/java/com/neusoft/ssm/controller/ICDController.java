package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Disease;
import com.neusoft.ssm.bean.Diswithcate;
import com.neusoft.ssm.bean.Icd;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.ICDService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("icd")
public class ICDController {
    @Autowired
    private ICDService icdService;

    @RequestMapping(value = "/index")
    public String index01(String icdfirstname,String icdid, Model model) {
        model.addAttribute("icdfirstname", icdfirstname);
        model.addAttribute("icdid", icdid);
        return "department/basic/Department_management/dissecond";
    }
    @RequestMapping(value = "/index01")
    public String index02(String secondid,String secondname, Model model) {
        model.addAttribute("secondname", secondname);
        model.addAttribute("secondid", secondid);
        return "department/basic/Department_management/disease";
    }


    @RequestMapping(value = "/firstname", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Map<String,String>> getFirstName() {
        ResultDTO<Map<String,String>> resultDTO = new ResultDTO<>();
        try {
            Map<String,String> names = icdService.findFirstName();
            resultDTO.setTotal(names.size());
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(names);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/secondname",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getSecondName(String icdid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Icd> list = icdService.findSecondName(icdid);
            System.out.println(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            // TODO: 2019/5/30 将list转为JSON格式传至前端
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getAll(int page, int limit, String secondid, String deptid){
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Diswithcate> list = null;
        try {
            PageHelper.startPage(page, limit);
            if (deptid == null) {
                list = icdService.findAll(secondid);
            } else {
                list = icdService.findSearch(deptid, secondid);
            }

            PageInfo<Diswithcate> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> makeInsert(Disease disease) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issuccess = icdService.doinsert(disease);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(issuccess);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> makeDelete(Integer[] ids) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                icdService.deleteByKey(id);
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(1);
        }catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> makeUpdate(Disease record){
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issucess = icdService.updateDisease(record);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            //TODO:将更新改为用ID查找，改完的输入框的值作为新值传入
            resultDTO.setData(issucess);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/gkd")
    public String nnn(){
        return "department/basic/Department_management/dissecond";
    }
}
