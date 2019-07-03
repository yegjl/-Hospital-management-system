package com.neusoft.ssm.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.SixpartService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("sixpart")
public class SixPartController {

    @Autowired
    private SixpartService sixpartService;
    //返回檢驗結果爲什麽是繁體
    @RequestMapping(value = "/index1")
    public String index1() {
        return "sixpart/Inspection";
    }
    @RequestMapping(value = "/index2")
    public String index2() {
        return "sixpart/Personal_workload";
    }
    @RequestMapping(value = "/index3",method = RequestMethod.GET)
    public String index3(Model model) {
        List<Drugs> drugs = sixpartService.getdrugs();
        model.addAttribute("drugs", drugs);
        return "sixpart/layer/bulu";
    }
    @RequestMapping(value = "/index4",method = RequestMethod.GET)
    public String index4(Model model,String medical_record_no,String patient_name,String itemname) {
        model.addAttribute("medical_record_no", medical_record_no);
        model.addAttribute("patient_name", patient_name);
        model.addAttribute("itemname", itemname);
        return "sixpart/layer/jcjy";
    }
    @RequestMapping(value = "/index5",method = RequestMethod.GET)
    public String index5(Model model) {
        List<Drugs> drugs = sixpartService.getdrugs();
        model.addAttribute("drugs", drugs);
        return "sixpart/layer/often";
    }
//寻找所有患者及项目，可以用执行科室id作为限制条件
    @RequestMapping(value = "/findpro",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> listall(int page, int limit,String medical_record_no,String patient_name) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Sixpartone> list = null;
        try {
            PageHelper.startPage(page, limit);
            if (medical_record_no==null&&patient_name==null) {
                list = sixpartService.getPro();
            } else {
                list = sixpartService.getPro1(medical_record_no,patient_name);
            }
//            list = sixpartService.getPro(medical_record_no,patient_name);
            PageInfo<Sixpartone> pageInfo = new PageInfo<>(list);
            for(Sixpartone sixpartone : list){
                if(sixpartone.getMark().equals("0"))
                    sixpartone.setMark("检查项目");
                else if(sixpartone.getMark().equals("1"))
                    sixpartone.setMark("检验项目");

                if(sixpartone.getStatus().equals("4"))
                    sixpartone.setStatus("已缴费");
                else if(sixpartone.getStatus().equals("5"))
                    sixpartone.setStatus("已登记");
                else if(sixpartone.getStatus().equals("6"))
                    sixpartone.setStatus("已录入结果");
                else sixpartone.setStatus("已补录");

                if((sixpartone.getIsmed()).equals("1")) {
                    sixpartone.setMark("补录药品/材料");
                    sixpartone.setItemname(sixpartService.getMedNameById(sixpartService.findIdByName(sixpartone.getItemname())));
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

    //登记选中项目
    @RequestMapping(value = "/dengjipro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> saveById(String[] myArray,String[] myArray1) {
        //myArray是medical_record_no数组，myArray1是itemname数组。
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(int i=0;i<myArray.length;i++){
                //通过病历号和项目名称从视图二找出检查检验详情id
                int i1=sixpartService.findExamInfoId(myArray[i],myArray1[i]);
                //修改该id对应的状态为5
                sixpartService.updateStatus(i1);
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

    //得到选定项目的详细信息
    @RequestMapping(value = "/getdrug")
    @ResponseBody
    public Drugs getQue(Integer id) {
        List<Drugs> drugs = sixpartService.getdrugs();
        for(Drugs drugs1:drugs) {
            if (drugs1.getId()==id)
                return drugs1;
        }
        return null;
    }

    @RequestMapping(value = "/addpro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addpro(String medical_record_no,String itemname,Integer drugid,Integer number) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            ExamcheckInfo examcheckInfo = new ExamcheckInfo();
            examcheckInfo.setFmeditemid(drugid);
            examcheckInfo.setIsmed("1");
            examcheckInfo.setNumber(number);
            examcheckInfo.setRequirement("辅助检查");
            examcheckInfo.setGoal("辅助检查");
            Date time= new java.sql.Date(new java.util.Date().getTime());
            examcheckInfo.setDate(time);
            examcheckInfo.setExamcheckid(sixpartService.getExamCheckId(medical_record_no,itemname));
            examcheckInfo.setStatus("7");
            int issuccess = sixpartService.addInfo(examcheckInfo);
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

    //保存上传的图片
    @RequestMapping(value = "/uploadFile" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPicture(@RequestParam("file")MultipartFile file, HttpServletRequest request)
            throws IOException {
        //如果文件内容不为空，则写入上传路径
        //String str = "";
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
//        String path = "D:\\webworkspace";
        String path = request.getSession().getServletContext().getRealPath("/") + "/static/resultpics/" ;
            System.out.println("文件名称" + file.getOriginalFilename());
            //上传文件名
            String name = file.getOriginalFilename();//上传文件的真实名称
            String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
            String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
            String fileName = hash + suffixName;
            File filepath = new File(path, fileName);
            System.out.println("随机数文件名称" + filepath.getName());
            //判断路径是否存在，没有就创建一个
//            if (!filepath.getParentFile().exists()) {
//                filepath.getParentFile().mkdirs();
//            }
            //将上传文件保存到一个目标文档中
//            File tempFile = new File(path + File.separator + fileName);
        File tempFile = new File(request.getSession().getServletContext().getRealPath("/") + "/static/resultpics/" +  fileName);
            file.transferTo(tempFile);

//            resUrl.put("src", tempFile.getPath());
            res.put("code", 0);
            res.put("msg", "");
            res.put("data", fileName);
//        res.put("data", fileName);
            //str = "{\"code\": 0,\"msg\": \"上传成功\",\"data\": {\"src\":\""+path+fileName + "\"}}";
            System.out.println("res里面的值：");
            System.out.println(res.toString());
        return res;
    }

//图片地址存入对应数据库
    @RequestMapping(value = "/resultpic",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> resultpic(String medical_record_no,String itemname,String picurl) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            ExamcheckResultPic examcheckResultPic = new ExamcheckResultPic();
//通过病历号和项目名称找到项目id
            int i1=sixpartService.findExamInfoId(medical_record_no,itemname);
//判断该项目的id是否已经存在与结果目录中，存在的话直接得到结果id，不存在的话创建
            int num = sixpartService.getResultIdNum(i1);
            if(num==0){
                ExamcheckResult examcheckResult=new ExamcheckResult();
                examcheckResult.setExamcheckid(i1);
                sixpartService.addResult(examcheckResult);
//                examcheckResultPic.setResultid(examcheckResult.getId());
                examcheckResultPic.setResultid(sixpartService.getResultId(i1));
                examcheckResultPic.setDirectory(picurl);
                sixpartService.addResultPic(examcheckResultPic);
            }
            else{
                examcheckResultPic.setResultid(sixpartService.getResultId(i1));
                examcheckResultPic.setDirectory(picurl);
                sixpartService.addResultPic(examcheckResultPic);
            }

            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

//存入所见和医生建议
//图片地址存入对应数据库
@RequestMapping(value = "/resultadd",method = RequestMethod.POST)
@ResponseBody
public ResultDTO<Integer> resultadd(String medical_record_no,String itemname,String suojian,String advice) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    try {
//通过病历号和项目名称找到项目id
        int i1=sixpartService.findExamInfoId(medical_record_no,itemname);
//判断该项目的id是否已经存在与结果目录中，存在的话直接得到结果id，不存在的话创建
        int num = sixpartService.getResultIdNum(i1);
        if(num==0){
            ExamcheckResult examcheckResult=new ExamcheckResult();
            examcheckResult.setExamcheckid(i1);
            examcheckResult.setSuojian(suojian);
            examcheckResult.setDiagnosis(advice);
            sixpartService.addResult(examcheckResult);
        }
        else{
            sixpartService.updateResult(sixpartService.getResultId(i1),suojian,advice);
        }
        sixpartService.updateStatus1(i1);
        resultDTO.setStatus(0);
        resultDTO.setMessage("操作成功！");
    } catch (Exception e) {
        e.printStackTrace();
        resultDTO.setStatus(1);
        resultDTO.setMessage("操作失败！");
    }
    return resultDTO;
}

//显示检查检验结果
    @RequestMapping(value = "/getresult",method = RequestMethod.GET)
    public String getresult(Model model,String medical_record_no,String patient_name,String itemname) {
        int i1=sixpartService.findExamInfoId(medical_record_no,itemname);
        int i2=sixpartService.getResultId(i1);
        List<ExamcheckResultPic> examcheckResultPics = sixpartService.getPicsById(i2);
        ExamcheckResult examcheckResult = sixpartService.getResultByInfoId(i1);
        model.addAttribute("suojian", examcheckResult.getSuojian());
        model.addAttribute("advice", examcheckResult.getDiagnosis());
        model.addAttribute("examcheckResultPics", examcheckResultPics);
        model.addAttribute("medical_record_no", medical_record_no);
        model.addAttribute("patient_name", patient_name);
        model.addAttribute("itemname", itemname);
        return "sixpart/layer/result";
    }

    //显示检查检验结果1
    @RequestMapping(value = "/getresult1",method = RequestMethod.GET)
    public String getresult1(Model model,Integer examcheckid,String itemname) {
        String medical_record_no = sixpartService.getNumById(examcheckid);
        String patient_name = sixpartService.getPatientName(examcheckid);
        int i1=sixpartService.findExamInfoId(medical_record_no,itemname);
        int i2=sixpartService.getResultId(i1);
        List<ExamcheckResultPic> examcheckResultPics = sixpartService.getPicsById(i2);
        ExamcheckResult examcheckResult = sixpartService.getResultByInfoId(i1);
        model.addAttribute("suojian", examcheckResult.getSuojian());
        model.addAttribute("advice", examcheckResult.getDiagnosis());
        model.addAttribute("examcheckResultPics", examcheckResultPics);
        model.addAttribute("medical_record_no", medical_record_no);
        model.addAttribute("patient_name", patient_name);
        model.addAttribute("itemname", itemname);
        return "sixpart/layer/result";
    }

    //添加常用项目
    @RequestMapping(value = "/addoften",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addoften(Integer drugid) {
        //myArray是medical_record_no数组，myArray1是itemname数组。
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            Drugs drugs = sixpartService.getMedById(drugid);
            Sixpartoften sixpartoften = new Sixpartoften();
            sixpartoften.setDrugid(drugid);
            sixpartoften.setDrugsname(drugs.getDrugsname());
            sixpartoften.setDrugsprice(String.valueOf(drugs.getDrugsprice()));
            sixpartService.addOften(sixpartoften);
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

    //寻找常用项目表里面的条目
    //寻找所有患者及项目，可以用执行科室id作为限制条件
    @RequestMapping(value = "/findoften",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> findoften(int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Sixpartoften> list = null;
        try {
            list = sixpartService.findAllOften();
            PageHelper.startPage(page, limit);
            PageInfo<Sixpartoften> pageInfo = new PageInfo<>(list);
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

    //删除常用项目
    @RequestMapping(value = "/deleteoften",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> deleteoften(String[] names) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(String name:names){
                sixpartService.deleteByDrugName(name);
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

//引用常用项目
    @RequestMapping(value = "/useoften",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> useoften(String medical_record_no,String drugname,Integer number,String itemname) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
                ExamcheckInfo examcheckInfo = new ExamcheckInfo();
                examcheckInfo.setFmeditemid(sixpartService.getDrugIdByName(drugname));
                examcheckInfo.setIsmed("1");
                examcheckInfo.setNumber(number);
                examcheckInfo.setRequirement("辅助检查");
                examcheckInfo.setGoal("辅助检查");
                Date time = new java.sql.Date(new java.util.Date().getTime());
                examcheckInfo.setDate(time);
                examcheckInfo.setExamcheckid(sixpartService.getExamCheckId(medical_record_no, itemname));
                examcheckInfo.setStatus("7");
                int issuccess = sixpartService.addInfo(examcheckInfo);
                resultDTO.setData(issuccess);
            System.out.println("添加函数已调用");
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
//            resultDTO.setData(issuccess);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //个人工作量统计
    @RequestMapping(value = "/tongji",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> tongji(int page, int limit,Date startDate,Date endDate) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Sixpartone> list = null;
        try {
            PageHelper.startPage(page, limit);
            if (startDate==null&&endDate==null) {
                list = sixpartService.getPro();
            } else {
                list = sixpartService.getPro2(startDate,endDate);
            }
            for(Sixpartone sixpartone:list){
                if((sixpartone.getIsmed()).equals("1")) {
                    sixpartone.setMark("补录药品/材料");
                    Drugs drug=sixpartService.getMedById(sixpartService.findIdByName(sixpartone.getItemname()));
                    sixpartone.setItemname(sixpartService.getMedNameById(sixpartService.findIdByName(sixpartone.getItemname())));
                    BigDecimal price = drug.getDrugsprice();
                    double price1 = price.doubleValue();
                    double price2 = price1*sixpartone.getNumber();
                    sixpartone.setPrice(price2);
                }
                if(sixpartone.getMark().equals("0"))
                    sixpartone.setMark("检查项目");
                else if(sixpartone.getMark().equals("1"))
                    sixpartone.setMark("检验项目");

            }
//            list = sixpartService.getPro(medical_record_no,patient_name);
            PageInfo<Sixpartone> pageInfo = new PageInfo<>(list);
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

}
