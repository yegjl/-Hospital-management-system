package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.PrescribeService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("prescribe")
public class PrescribeController {
    @Autowired
    private PrescribeService prescribeService;

    @RequestMapping(value = "/in")
    public String rr(){
        return "fifthpart/medicine_prescription/iti";
    }

    @RequestMapping(value = "/addmed")
    public String addmed(String deptcategoryid,Model model)
    {
        String drugid = "103";
        if (!deptcategoryid.equals("20")) {
            model.addAttribute("projects", prescribeService.getAllChengDrugs(drugid));//存储成药或者草药，id=103时为草药，其余是成药
        } else {
            model.addAttribute("projects", prescribeService.getAllCaoDrugs(drugid));
        }
        model.addAttribute("drugstpe", drugid);
        return "fifthpart/medicine_prescription/add";
    }

    @RequestMapping(value = "/addcaomed")
    public String addcaomed(String drugid,Model model)
    {
        model.addAttribute("drugstpe", drugid);
        model.addAttribute("projects", prescribeService.getAllCaoDrugs(drugid));//存储成药或者草药，id=103时为草药，其余是成药
        return "fifthpart/medicine_prescription/add";
    }

    @RequestMapping(value = "/updatemed")
    public String updatemed(int prescribeid, int medicalid,Model model)
    {
        model.addAttribute("prescribeid", prescribeid);
        model.addAttribute("medicalid", medicalid);
//        model.addAttribute("projects", prescribeService.getAllChengDrugs(drugid));//存储成药或者草药，id=103时为草药，其余是成药
        return "fifthpart/medicine_prescription/update";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> add(Prescribe prescribe, Prescribecategory[] prescribecategorys) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int presuccess = prescribeService.insertPrescribe(prescribe);
            for (Prescribecategory prescribecategory : prescribecategorys) {
                prescribeService.insertPrescribecategory(prescribecategory);
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(presuccess);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/deleteprescribelog",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> makeDelete(Integer[] ids) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                prescribeService.deletePrescribecategory(id);
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

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> makeSearch(String key,int page,int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            PageHelper.startPage(page, limit);
            List<Drugs> list = prescribeService.selectDrugsByKey(key);
            PageInfo<Drugs> pageInfo = new PageInfo<>(list);
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
        return resultDTO;
    }



    @RequestMapping(value = "/indexadd",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<JSONArray> indexadd(String drugid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Drugs> list = prescribeService.getAllChengDrugs(drugid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/indexup",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<JSONArray> indexup(String drugid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Drugs> list = prescribeService.getAllChengDrugs(drugid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //新增药品
    @RequestMapping(value = "/addmedtest",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> add(Prescribecategory prescribecategory,Integer doctorid,String medicalrecordid,String prestatus,String medicaltype) {
        if (prescribeService.getPreCount(doctorid, medicalrecordid) == 0) {
            Prescribe prescribe = new Prescribe();
            prescribe.setDoctorid(doctorid);
            prescribe.setMedicalrecordid(medicalrecordid);
            prescribe.setGetmedicalflag(0);
            prescribe.setType(prestatus);
            prescribe.setMedicaltype(medicaltype);
            prescribe.setIsdone(0);
            prescribeService.insertPrescribe(prescribe);
        }
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            prescribecategory.setPrescribeid(prescribeService.getNowID(doctorid, medicalrecordid));
            int issuccess = prescribeService.insertPrescribecategory(prescribecategory);
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

    //修改药品
    @RequestMapping(value = "/updatemedtest",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> updatemedtest(int id,Prescribecategory prescribecategory) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            prescribecategory.setId(id);
            int issuccess = prescribeService.updatePrescribecategory(prescribecategory);
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


    //诊毕点击此更新处方表里的isdone的值
    @RequestMapping(value = "/zhenbi",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> makeIsdone(int medicalrecordid){
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issucess = prescribeService.updateZhenbi(medicalrecordid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(issucess);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //用在add弹窗中
    @RequestMapping(value = "/getinfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Drugs> findbyID(int id){
        ResultDTO<Drugs> resultDTO = new ResultDTO();
        try {
            Drugs drugs = prescribeService.findByid(id);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(drugs);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //用在update弹窗中
    @RequestMapping(value = "/updateinfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Prescribelogview> updateinfo(int prescribeid,int medicalid){
        ResultDTO<Prescribelogview> resultDTO = new ResultDTO();
        try {
            Prescribelogview prescribelogview = prescribeService.findByTwoid(prescribeid, medicalid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(prescribelogview);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/showAllid",method = RequestMethod.POST)//得到所有的病历号
    @ResponseBody
    public ResultDTO<JSONArray> showAllid(int doctorid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Prescribe> list = prescribeService.getAllpreidByDoc(doctorid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/indexiti")
    public String index01(){//(int prescribeid, Model model) {
//        model.addAttribute("prescribeid", prescribeid);
        return "fifthpart/medicine_prescription/iti";

    }

    @RequestMapping(value = "/getAllCate",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getAllCate(int prescribeid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Prescribecategory> list = prescribeService.getNeedPrescribe(prescribeid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //中间的table获取测试值，以病历号和类型进行搜索（prescribe表中的medicalrecordid和type）
    @RequestMapping(value = "/gettestinfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> gettestinfo(String medicalrecordid, int doctorid,int page,int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Prescribelogview> list = prescribeService.getByMrecordidAndDid(medicalrecordid, doctorid);
            PageInfo<Prescribelogview> pageInfo = new PageInfo<>(list);
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
        return resultDTO;
    }


    //暂存处方
    @RequestMapping(value = "/upIstemp",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> updateIstemp(Integer[] ids) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                prescribeService.updateIstemp(id);
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

    //删除处方
    @RequestMapping(value = "/deletepreandcate",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> deletepreandcate(Integer[] ids,Integer prescriid) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                prescribeService.deletePrescribecategory(id);
            }
            prescribeService.deletePrescribe(prescriid);
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

    //开立处方
    @RequestMapping(value = "/formulation",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> formulation(Integer[] ids,Integer prescriid) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                prescribeService.prescribecateFormulation(id);
            }
            prescribeService.prescribeFormulation(prescriid);
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

    //作废处方
    @RequestMapping(value = "/cancelprescribe",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> cancelprescribe(Integer[] ids,Integer prescriid) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                prescribeService.prescribecateCancel(id);
            }
            prescribeService.prescribeCancel(prescriid);
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

    //跳转到增加模板界面
    @RequestMapping(value = "/addModel",method = RequestMethod.GET)
    public String index03(String createman, String createdept,Model model) {
        model.addAttribute("createman", createman);
        model.addAttribute("createdept", createdept);
        return "fifthpart/medicine_prescription/add_muban";
    }

    //新增模板功能实现
    @RequestMapping(value = "/addmuban",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addmuban(Prescribemodel prescribemodel, String[] drugsnames, String[] formats, BigDecimal[] prices,String[] usages, String[] dosages, String[] units, String[] timess, String[] entrusts) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        Prescribemodellog prescribemodellog=new Prescribemodellog();
        try {
            Date createtime= new java.sql.Date(new java.util.Date().getTime());
            prescribemodel.setCreatetime(createtime);
            int issuccess = prescribeService.addPrescribemodel(prescribemodel);
//            System.out.println(examcheckSet.getId());
            for (int i = 0; i < drugsnames.length; i++) {
                prescribemodellog.setPrescribemodelid(prescribemodel.getId());
                prescribemodellog.setMedicalname(drugsnames[i]);
                prescribemodellog.setFormat(formats[i]);
                prescribemodellog.setPrice(prices[i]);
                prescribemodellog.setUsage(usages[i]);
                prescribemodellog.setDosage(dosages[i]);
                prescribemodellog.setUnit(units[i]);
                prescribemodellog.setTimes(timess[i]);
                prescribemodellog.setEntrust(entrusts[i]);
                prescribeService.addPrescribemodellog(prescribemodellog);
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

    //    settotalmoney
    //在开立处方时间中添加存入处方总值的事件
    @RequestMapping(value = "/settotalmoney",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> settotalmoney(int id,String fee) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            BigDecimal bigfee = new BigDecimal(fee);
            int issuccess = prescribeService.updateMoney(id, bigfee);
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

    //将数据发送到expense表里
//    insertExpense
//    medicalrecordid,（用medicalid查drugs表的101，赋值13.14.15，查对应拼音）,(String)medicalid,prescribeid,amount,price,date
    @RequestMapping(value = "/sendtoexpense",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> sendtoexpense(String[] medicalrecordids, Integer[] medicalids, Integer[] presribeids, Integer[] amounts, Integer[] prices){
        ResultDTO<Integer> resultDTO = new ResultDTO();
        Expense expense = new Expense();
        try {
            Date createtime= new java.sql.Date(new java.util.Date().getTime());
            for (int i = 0; i < medicalrecordids.length; i++) {
                expense.setMedical_record_no(medicalrecordids[i]);
                String accountcode = null;
                int type = prescribeService.getDrugsTypeID(medicalids[i]);
                if (type == 101) {
                    accountcode = "XYF";
                } else if (type == 102) {
                    accountcode = "ZCYF";
                } else {
                    accountcode = "ZCYF1";
                }
                expense.setExpense_category(accountcode);
                expense.setExpense_id(String.valueOf(medicalids[i]));
                expense.setPrescribe_id((long)presribeids[i]);
                Long a = new Long((long) amounts[i]);
                expense.setNumber(a);
                int emoney = amounts[i] * prices[i];
                BigDecimal expensemoney = new BigDecimal(emoney);
                expense.setExpense(expensemoney.doubleValue());
                expense.setExpense_date(createtime);
                prescribeService.insertExpense(expense);
            }
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(0);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }


    @RequestMapping(value = "/indexaddoften")
    public String indexaddoften(int doctorid,Model model)
    {
        model.addAttribute("doctorid", doctorid);
        model.addAttribute("drugstpe", "103");
        model.addAttribute("projects", prescribeService.getAllChengDrugs("103"));//存储成药或者草药，id=103时为草药，其余是成药
        return "fifthpart/medicine_prescription/often";
    }

//    @RequestMapping(value = "indexaddoften")
//    @RequestMapping(value = "/indexaddoften",method = RequestMethod.POST)
//    @ResponseBody
//    public ResultDTO<JSONArray> indexaddoften() {
//        ResultDTO<JSONArray> resultDTO = new ResultDTO();
//        try {
//            List<Drugs> list = prescribeService.getAllChengDrugs("103");
//            resultDTO.setStatus(0);
//            resultDTO.setMessage("");
//            resultDTO.setData(JSONArray.fromObject(list));
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultDTO.setStatus(1);
//            resultDTO.setMessage("操作失败！");
//        }
//        return resultDTO;
//    }

//    添加常用药
    @RequestMapping(value = "/addoftendrug",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addoftendrug(Oftendrug oftendrug){
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issuccess = prescribeService.addoften(oftendrug);
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

    @RequestMapping(value = "/findoften", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> findoften(int doctorid) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            List<Oftendrug> list = prescribeService.showoften(doctorid);
//            PageHelper.startPage(page, limit);
//            PageInfo<Oftendrug> pageInfo = new PageInfo<>(list);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
//            resultDTO.setTotal((int)pageInfo.getTotal());
            resultDTO.setData(JSONArray.fromObject(list));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //删除常用项目
    @RequestMapping(value = "/deleteoften",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> deleteoften(Integer[] medicalids) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for(int id : medicalids){
                prescribeService.deleteOften(id);
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

    @RequestMapping(value = "/indexuseoften")
    public String indexuseoften(int medicalid,String medicalname,int doctorid,Model model)
    {
        model.addAttribute("medicalid", medicalid);
        model.addAttribute("medicalname", medicalname);
        model.addAttribute("doctorid", doctorid);
        model.addAttribute("drugstpe", "103");
//        model.addAttribute("projects", prescribeService.getAllChengDrugs("103"));//存储成药或者草药，id=103时为草药，其余是成药
        return "fifthpart/medicine_prescription/useoften";
    }
}
