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

    @RequestMapping(value = "/addModel",method = RequestMethod.GET)
    public String index03() {
        return "fifthpart/inspection_application/add_muban"; }

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
            resultDTO.setTotal((int) pageInfo.getTotal());
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
    public ResultDTO<Integer> deleteById(String[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(String i:ids){
               int i1=examcheckService.findIdByCode(i);
                examcheckService.deleteByExamId(i1,id);
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
    public ResultDTO<Integer> saveById(String[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(String i:ids){
               int i1=examcheckService.findIdByCode(i);
                examcheckService.saveByExamId(i1,id);
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
    public ResultDTO<Integer> openById(String[] ids,Integer id) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(String i:ids){
               int i1=examcheckService.findIdByCode(i);
                examcheckService.openByExamId(i1,id);
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
public ResultDTO<Integer> cancelById(String[] ids,Integer id) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    try {
        for(String i:ids){
           int i1=examcheckService.findIdByCode(i);
            examcheckService.cancelByExamId(i1,id);
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

//快速查询项目
@RequestMapping(value = "/getQue")
@ResponseBody
public Fmeditem getQue(String name,String id) {
    Fmeditem fmeditem =  examcheckService.findProByName(name,id);
    return fmeditem;
}

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> add(ExamcheckInfo examcheckInfo,Integer doctorid,Integer medicalid) {
        if(examcheckService.getCount(doctorid,medicalid)==0){
            Examcheck examcheck=new Examcheck();
            examcheck.setDoctorid(doctorid);
            examcheck.setMedicalrecordid(medicalid);
            examcheck.setMark("0");
            examcheckService.addExam(examcheck);
        }
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            System.out.println("操作开始！！！");
            examcheckInfo.setExamcheckid(examcheckService.getExamId(doctorid,medicalid));
            examcheckInfo.setStatus("0");
            int issuccess = examcheckService.addInfo(examcheckInfo);
            System.out.println("添加函数已调用");
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

    @RequestMapping(value = "/addmuban",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addmuban(ExamcheckSet examcheckSet,String[] myArray,String[] myArray1,String[] myArray2) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        ExamcheckSetInfo examcheckSetInfo=new ExamcheckSetInfo();
        try {
            Date time= new java.sql.Date(new java.util.Date().getTime());
            examcheckSet.setTime(time);
            int issuccess = examcheckService.addMuban(examcheckSet);
            System.out.println(examcheckSet.getId());
            for (int i = 0; i < myArray.length; i++) {
                examcheckSetInfo.setSetid(examcheckSet.getId());
                examcheckSetInfo.setFmeditemid(examcheckService.findIdByCode(myArray[i]));
                examcheckSetInfo.setEntrust(myArray1[i]);
                examcheckSetInfo.setGoal(myArray2[i]);
                examcheckService.addMubanInfo(examcheckSetInfo);
            }
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

    @RequestMapping(value = "/findprobyid",method = RequestMethod.POST)
    @ResponseBody
    public Fmeditem findprobyid(Integer proid) {
        return examcheckService.findprobyid(proid);
    }

    @RequestMapping(value = "/getsets")
    @ResponseBody
    public List<ExamcheckSet> getsets() {
        List<ExamcheckSet> examcheckSets =  examcheckService.getsets();
        return JSONArray.fromObject(examcheckSets);
    }

}
