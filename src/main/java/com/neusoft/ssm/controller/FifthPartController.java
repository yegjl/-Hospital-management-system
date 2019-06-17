package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Examcheckone;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.ExamcheckService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("fifthpart")
public class FifthPartController {

    @Autowired
    private ExamcheckService examcheckService;

    @RequestMapping(value = "/index")
    public String index(String id, Model model) {
        String name;
        model.addAttribute("id", id);
        if (id.equals("01"))
        return "fifthpart/null";
        else if(id.equals("02"))
            return "fifthpart/medical_record/medical_record";
        else if (id.equals("03")) {
            name="检查";
            model.addAttribute("name", name);
            return "fifthpart/inspection_application/inspection_application";
        }
        else return null;

    }

    @RequestMapping(value = "/addUI")
    public String index02(String id,Model model) {
        model.addAttribute("id", id);
        if(id.equals("03"))
            model.addAttribute("projects", examcheckService.findByExamType("1"));
        return "fifthpart/inspection_application/add"; }

    @RequestMapping(value = "/addModel")
    public String index03() { return "fifthpart/inspection_application/add_muban"; }

    @RequestMapping(value = "/findpro",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit, int doctorid, int medicalid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Examcheckone> list = null;
        try {
            PageHelper.startPage(page, limit);
            list = examcheckService.getPro(doctorid,medicalid);
            PageInfo<Examcheckone> pageInfo = new PageInfo<>(list);
            for(Examcheckone examcheckone : list){
                if (examcheckone.getStatus().equals("0"))
                    examcheckone.setStatus("未保存");
               else if (examcheckone.getStatus().equals("1"))
                    examcheckone.setStatus("未开立");
                else if (examcheckone.getStatus().equals("2"))
                    examcheckone.setStatus("已开立");
                else if (examcheckone.getStatus().equals("3"))
                    examcheckone.setStatus("已作废");
                else if (examcheckone.getStatus().equals("4"))
                    examcheckone.setStatus("已缴费");
                else if (examcheckone.getStatus().equals("5"))
                    examcheckone.setStatus("已登记");
                else if (examcheckone.getStatus().equals("6"))
                    examcheckone.setStatus("检查结果已录入");
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            // 将list转为JSON格式传至前端
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        //此方法用于删除未保存状态的项目，可以在页面切换时利用
//        examcheckService.deleteUnsave();
        return resultDTO;
    }

    @RequestMapping(value = "/deletepro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> deleteById(Integer[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(Integer i:ids){
                i=examcheckService.findIdByCode(i);
                examcheckService.deleteByExamId(i,id);
            }
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

    @RequestMapping(value = "/savepro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> saveById(Integer[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(Integer i:ids){
                i=examcheckService.findIdByCode(i);
                examcheckService.saveByExamId(i,id);
            }
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
//开立
    @RequestMapping(value = "/openpro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> openById(Integer[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(Integer i:ids){
                i=examcheckService.findIdByCode(i);
                examcheckService.openByExamId(i,id);
            }
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
//作废
@RequestMapping(value = "/cancelpro",method = RequestMethod.POST)
@ResponseBody
public ResultDTO<Integer> cancelById(Integer[] ids,Integer id) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    try {
        for(Integer i:ids){
            i=examcheckService.findIdByCode(i);
            examcheckService.cancelByExamId(i,id);
        }
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
}
