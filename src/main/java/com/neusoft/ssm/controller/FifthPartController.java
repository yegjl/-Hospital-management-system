package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.ExamcheckService;
import com.neusoft.ssm.service.RegisterService;
import com.neusoft.ssm.service.SixpartService;
import com.neusoft.ssm.util.MD5;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("fifthpart")
public class FifthPartController {

    @Autowired
    private ExamcheckService examcheckService;
    @Autowired
    RegisterService registerService;

    @Autowired
    private SixpartService sixpartService;

    @RequestMapping(value = "/index")
    public String index(String id, Model model, String medicalRecordNo, HttpSession session) {
        String name;
        model.addAttribute("id", id);
        model.addAttribute("medicalRecordNo", medicalRecordNo);//病历号
        int doctorid = (int)session.getAttribute("doctorid");
        model.addAttribute("doctorid", doctorid);
        int medicalid = sixpartService.getMedicalIdByNo(medicalRecordNo);//这是检查检验申请用到的病历号对应的id
        model.addAttribute("medicalid", medicalid);
        if (id.equals("01"))
        return "fifthpart/null";
        else if(id.equals("03")) {
            model.addAttribute("name", "检验");
            return "fifthpart/inspection_application/inspection_application";
        }
        else if(id.equals("02")) {
            model.addAttribute("name", "检查");
            return "fifthpart/inspection_application/inspection_application";
        }
        else if(id.equals("04")){
            //从之前的界面里面获取到病历号（int还是char），然后传入处方界面使用
//            model.addAttribute("medicalrecordid",medicalrecordid);
            model.addAttribute("name", "处置");
            return "fifthpart/inspection_application/inspection_application";
        }
        else if(id.equals("05")){//草药
            //从之前的界面里面获取到病历号（int还是char），然后传入处方界面使用
//            model.addAttribute("medicalrecordid",medicalrecordid);

            return "fifthpart/medicine_prescription/cmedicine_pre";
        } else if (id==null) {
            return "fifthpart/inspection_application/inspection_application";
        }
        return "fifthpart/inspection_application/inspection_application";
    }
    @RequestMapping(value = "/index2")
    public String index2(String medicalRecordNo,Model model) {
        model.addAttribute("medicalRecordNo", medicalRecordNo);
        return "fifthpart/ODW_index2";
    }
    @RequestMapping(value = "/index3")
    public String index3(String medicalRecordNo,Model model) {
        model.addAttribute("medicalRecordNo", medicalRecordNo);
        return "fifthpart/ODW_index3";
    }
    @RequestMapping(value = "/daizhen",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<RegistrationInfo>> daizhen(Integer doctorid){

        ResultDTO<List<RegistrationInfo>> resultDTO = new ResultDTO<>();
        try {
            List<RegistrationInfo> list = registerService.findByDaidoctorid(doctorid);
            resultDTO.setTotal(list.size());
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
    @RequestMapping(value = "/dpartdaizhen",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<RegistrationInfo>> Dpartdaizhen(Integer departid){

        ResultDTO<List<RegistrationInfo>> resultDTO = new ResultDTO<>();
        try {
            List<RegistrationInfo> list = registerService.findByDaiDepart(departid);
            resultDTO.setTotal(list.size());
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
    @RequestMapping(value = "/yizhen",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<RegistrationInfo>> yizhen(Integer doctorid){

        ResultDTO<List<RegistrationInfo>> resultDTO = new ResultDTO<>();
        try {
            List<RegistrationInfo> list = registerService.findByYidoctorid(doctorid);
            resultDTO.setTotal(list.size());
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
    @RequestMapping(value = "/dpartyizhen",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<RegistrationInfo>> dpartyizhen(Integer departid){

        ResultDTO<List<RegistrationInfo>> resultDTO = new ResultDTO<>();
        try {
            List<RegistrationInfo> list = registerService.findByYiDepart(departid);
            resultDTO.setTotal(list.size());
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

    @RequestMapping(value = "/addUI")
    public String index02(String id,Model model) {
        model.addAttribute("id", id);
        if(id.equals("02"))
            model.addAttribute("projects", examcheckService.findByExamType("1"));
        else if(id.equals("03"))
            model.addAttribute("projects", examcheckService.findByExamType("2"));
        else
            model.addAttribute("projects", examcheckService.findByExamType("3"));
        return "fifthpart/inspection_application/add"; }

    @RequestMapping(value = "/addModel",method = RequestMethod.GET)
    public String index03(String id,Model model) {
        String name;
        if(id.equals("02"))
            name = "检查";
        else if(id.equals("03"))
            name = "检验";
        else name = "处置";
        model.addAttribute("name", name);
        model.addAttribute("id", id);
        return "fifthpart/inspection_application/add_muban"; }

    @RequestMapping(value = "/findpro",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit, int doctorid, int medicalid, String id) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Examcheckone> list = null;
        try {
            PageHelper.startPage(page, limit);
            String mark;
            if(id.equals("02"))
                mark = "1";
            else if(id.equals("03"))
                mark = "2";
            else
                mark = "3";
            list = examcheckService.getPro(doctorid,medicalid,mark);
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
                else examcheckone.setStatus("医技补录");

                if((examcheckone.getIsmed()).equals("1")) {
                    examcheckone.setMark("补录药品/材料");
                    examcheckone.setItemname(sixpartService.getMedNameById(sixpartService.findIdByName(examcheckone.getItemname())));
                }
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
    public ResultDTO<Integer> openById(String[] ids,Integer id,String mark,String medicalRecordNo) {
        String account_name;
        if(mark.equals("02"))
            account_name = "CTJCF";
        else if(mark.equals("03"))
            account_name = "JYAN";
        else
            account_name = "CZF";
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(String i:ids){
               int i1=examcheckService.findIdByCode(i);
                examcheckService.openByExamId(i1,id);
                Fmeditem fmeditem = examcheckService.findprobyid(i1);
                Expense expense = new Expense();
                expense.setMedical_record_no(medicalRecordNo);
                expense.setExpense_category(account_name);
                expense.setNumber((long)1);
                expense.setExpense_id(fmeditem.getItemcode());
                expense.setExpense(fmeditem.getPrice());
                Date time= new java.sql.Date(new java.util.Date().getTime());
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                expense.setDate(sdf.format(time));
                expense.setExpense_date(time);
                expense.setPrescribe_id((long)0);
                expense.setReal_expense(0.0);
                expense.setPay_sign("0");
                expense.setDay_settle_sign("0");
                expense.setIs_consume("0");
                expense.setPay_category("");
                examcheckService.insertExpense(expense);
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
    public ResultDTO<Integer> add(ExamcheckInfo examcheckInfo,Integer doctorid,Integer medicalid,String id) {
        String mark;
        if(id.equals("02"))
            mark = "1";
        else if(id.equals("03"))
            mark = "2";
        else
            mark = "3";
        if(examcheckService.getCount(doctorid,medicalid,mark)==0){
            Examcheck examcheck=new Examcheck();
            examcheck.setDoctorid(doctorid);
            examcheck.setMedicalrecordid(medicalid);
            examcheck.setMark(mark);
            examcheckService.addExam(examcheck);
        }
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            System.out.println("操作开始！！！");
            examcheckInfo.setExamcheckid(examcheckService.getExamId(doctorid,medicalid,mark));
            examcheckInfo.setStatus("0");
            examcheckInfo.setNumber(1);
            examcheckInfo.setIsmed("0");
            Date time= new java.sql.Date(new java.util.Date().getTime());
            examcheckInfo.setDate(time);
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
    public ResultDTO<Integer> addmuban(ExamcheckSet examcheckSet,String[] myArray,String[] myArray1,String[] myArray2,String id) {
        String mark;
        if(id.equals("02"))
            mark = "1";
        else if(id.equals("03"))
            mark = "2";
        else
            mark = "3";
        ResultDTO<Integer> resultDTO = new ResultDTO();
        ExamcheckSetInfo examcheckSetInfo=new ExamcheckSetInfo();
        try {
            Date time= new java.sql.Date(new java.util.Date().getTime());
            examcheckSet.setTime(time);
            examcheckSet.setMark(mark);
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
    public List<ExamcheckSet> getsets(String id) {
        String mark;
        if(id.equals("02"))
            mark = "1";
        else if(id.equals("03"))
            mark = "2";
        else
            mark = "3";
        List<ExamcheckSet> examcheckSets =  examcheckService.getsets(mark);
        return JSONArray.fromObject(examcheckSets);
    }
//引用模板
    @RequestMapping(value = "/useModel",method = RequestMethod.GET)
    public String useModel(Integer id,Model model) {
        ExamcheckSet examcheckSet=examcheckService.findSetById(id);
        model.addAttribute("examcheckSet", examcheckSet);
        List<ExamcheckSetInfo> examcheckSetInfos=examcheckService.findSetInfosById(id);
        List<ExamcheckSetInfoPlus> examcheckSetInfoPluses = new ArrayList<ExamcheckSetInfoPlus>();
        for(ExamcheckSetInfo e:examcheckSetInfos){
            ExamcheckSetInfoPlus examcheckSetInfoPlus = new ExamcheckSetInfoPlus();
            examcheckSetInfoPlus.setCode(examcheckService.findprobyid(e.getFmeditemid()).getItemcode());
            examcheckSetInfoPlus.setName(examcheckService.findprobyid(e.getFmeditemid()).getItemname());
            examcheckSetInfoPlus.setGoal(e.getGoal());
            examcheckSetInfoPlus.setEntrust(e.getEntrust());
            examcheckSetInfoPluses.add(examcheckSetInfoPlus);
        }
        model.addAttribute("examcheckSetInfos", examcheckSetInfoPluses);
        return "fifthpart/inspection_application/use_muban"; }

        //将引用组套里面的项目存入数据库
        @RequestMapping(value = "/usemubanpros",method = RequestMethod.POST)
        @ResponseBody
        public ResultDTO<Integer> usemubanpros(String[] myArray,String[] myArray1,String[] myArray2,Integer doctorid,Integer medicalid,String id) {
            String mark;
            if(id.equals("02"))
                mark = "1";
            else if(id.equals("03"))
                mark = "2";
            else
                mark = "3";
            if(examcheckService.getCount(doctorid,medicalid,mark)==0){
                Examcheck examcheck=new Examcheck();
                examcheck.setDoctorid(doctorid);
                examcheck.setMedicalrecordid(medicalid);
                examcheck.setMark(mark);
                examcheckService.addExam(examcheck);
            }
            ResultDTO<Integer> resultDTO = new ResultDTO();
            try {
                int issuccess=0;
                for(int i = 0; i < myArray.length; i++) {
                    ExamcheckInfo examcheckInfo = new ExamcheckInfo();
                    Date time= new java.sql.Date(new java.util.Date().getTime());
                    examcheckInfo.setDate(time);
                    examcheckInfo.setExamcheckid(examcheckService.getExamId(doctorid, medicalid,mark));
                    examcheckInfo.setStatus("0");
                    examcheckInfo.setIsmed("0");
                    examcheckInfo.setFmeditemid(examcheckService.findIdByCode(myArray[i]));
                    examcheckInfo.setRequirement(myArray1[i]);
                    examcheckInfo.setGoal(myArray2[i]);
                    issuccess = examcheckService.addInfo(examcheckInfo);
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

        //删除组套
        @RequestMapping(value = "/deleteset",method = RequestMethod.POST)
        @ResponseBody
        public ResultDTO<Integer> deleteset(Integer[] ids) {
            ResultDTO<Integer> resultDTO = new ResultDTO();
            try {
                for(Integer i:ids){
                    examcheckService.deleteSetById(i);
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
