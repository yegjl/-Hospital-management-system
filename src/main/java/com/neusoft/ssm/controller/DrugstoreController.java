package com.neusoft.ssm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.*;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.DrugstoreService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("drugstore")
public class DrugstoreController {
    @Autowired
    DrugstoreService drugstoreService;

    @RequestMapping(value = "/dispensing")
    public String dispensing(){
        return "Pharmacy_Workstation/dispensing/dispensing";
    }

    @RequestMapping(value = "/return")
    public String retu(){
        return "Pharmacy_Workstation/return/return";
    }

    @RequestMapping(value = "/catalogue")
    public String catalogue() {

        return "Pharmacy_Workstation/catalogue/catalogue";
    }

    //药品管理页的得到所有药
    @RequestMapping(value = "/getAllDrug",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getAllDrug(int page, int limit,String drug){
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Druglogview> list = null;
        try {
            PageHelper.startPage(page, limit);
            if (drug == null) {
                list = drugstoreService.getAllDrgus();
            } else {
                list = drugstoreService.searchByKey(drug);
            }
            PageInfo<Druglogview> pageInfo = new PageInfo<>(list);
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

    //初始化药品管理界面的剂量类型
    @RequestMapping(value = "indexadd")
    public String indexadd(String constanttypeid, Model model){
        model.addAttribute("projects", drugstoreService.getType(constanttypeid));
        return "Pharmacy_Workstation/catalogue/add";
    }


    //新增药品功能
    @RequestMapping(value = "/addmedicine",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> addmedicine(Druglogview druglogview) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        Drugs drugs = new Drugs();
        Drugsupplement drugsupplement = new Drugsupplement();
        try {
            Date createtime= new java.sql.Date(new Date().getTime());
            drugs.setDrugscode(druglogview.getDrugscode());
            drugs.setDrugsname(druglogview.getDrugsname());
            drugs.setDrugsformat(druglogview.getDrugsformat());
            drugs.setDrugsunit(druglogview.getDrugsunit());
            drugs.setManufacturer(druglogview.getManufacturer());
            drugs.setDrugsdosageid(druglogview.getConstantname());
            drugs.setDrugstypeid(druglogview.getTypename());
            drugs.setDrugsprice(druglogview.getDrugsprice());
            drugs.setMnemoniccode(druglogview.getMnemoniccode());
            drugs.setCreationdate(createtime);
            int issuccess = drugstoreService.addDrug(drugs);
            drugsupplement.setDrugsname(druglogview.getDrugsname());
            drugsupplement.setDrugstatus(druglogview.getDrugstatus());
            drugsupplement.setDrugamount(druglogview.getDrugamount());
            drugstoreService.addDrugsupplement(drugsupplement);
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

    //删除药品
    @RequestMapping(value = "/delmedicine",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> delmedicine(Integer[] ids) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            for (Integer id : ids) {
                drugstoreService.delDrug(id);
            }
            for (Integer id : ids) {
                drugstoreService.delDrugsupplement(id);
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


    @RequestMapping(value = "/indexedit")
    public String updatemed(String constanttypeid, int id, Model model)
    {
        model.addAttribute("projects", drugstoreService.getType(constanttypeid));
        model.addAttribute("id", id);
        return "Pharmacy_Workstation/catalogue/edit";
    }

    //在修改药品界面初始化时，得到药的信息
    @RequestMapping(value = "/updateinfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<Druglogview> updateinfo(int id){
        ResultDTO<Druglogview> resultDTO = new ResultDTO();
        try {
            Druglogview druglogview = drugstoreService.selectDruglog(id);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(druglogview);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //修改药品
    @RequestMapping(value = "/editmedicine",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> editmedicine(int id,Druglogview druglogview) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        Drugs drugs = new Drugs();
        Drugsupplement drugsupplement = new Drugsupplement();
        try {
            Date createtime= new java.sql.Date(new Date().getTime());
            drugs.setId(id);
            drugs.setDrugscode(druglogview.getDrugscode());
            drugs.setDrugsname(druglogview.getDrugsname());
            drugs.setDrugsformat(druglogview.getDrugsformat());
            drugs.setDrugsunit(druglogview.getDrugsunit());
            drugs.setManufacturer(druglogview.getManufacturer());
            drugs.setDrugsdosageid(druglogview.getConstantname());
            drugs.setDrugstypeid(druglogview.getTypename());
            drugs.setDrugsprice(druglogview.getDrugsprice());
            drugs.setMnemoniccode(druglogview.getMnemoniccode());
            drugs.setCreationdate(createtime);
            int issuccess = drugstoreService.updateDrugs(drugs);
            drugsupplement.setId(id);
            drugsupplement.setDrugsname(druglogview.getDrugsname());
            drugsupplement.setDrugstatus(druglogview.getDrugstatus());
            drugsupplement.setDrugamount(druglogview.getDrugamount());
            drugstoreService.updateDrugsupplement(drugsupplement);
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

    @RequestMapping(value = "/indexchange")
    public String indexchange(int id, Model model)
    {
        Date createtime= new java.sql.Date(new Date().getTime());
        model.addAttribute("datte", createtime);
        model.addAttribute("id", id);
        return "Pharmacy_Workstation/catalogue/change";
    }

    //调价弹窗的赋值
    @RequestMapping(value = "/changeinfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<Druglogview> changeinfo(int id){
        ResultDTO<Druglogview> resultDTO = new ResultDTO();
        try {
            Druglogview druglogview = drugstoreService.selectDruglog(id);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(druglogview);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //调价
    @RequestMapping(value = "/changemedicine",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> changemedicine(int id,Adjustprice adjustprice) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            Date createtime= new java.sql.Date(new Date().getTime());
            int issuccess = drugstoreService.upPriceAndDate(id,adjustprice.getNewprice(),createtime);
            drugstoreService.addAdjustprice(adjustprice);
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

    @RequestMapping(value = "/indextable")
    public String indextable(int id, Model model)
    {
        model.addAttribute("id", id);
        return "Pharmacy_Workstation/catalogue/table";
    }

    //药品管理页的得到所有药
    @RequestMapping(value = "/showtable",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> showtable(int drugid,int page, int limit){
        ResultDTO<JSONArray> resultDTO = new ResultDTO();

        try {
            PageHelper.startPage(page, limit);
            List<Adjustprice> list = drugstoreService.getAdjustByID(drugid);
            List<Showtable> showtables = new ArrayList<>();
            for (Adjustprice a: list) {
                Showtable showtable = new Showtable();
                showtable.setId(a.getId());
                showtable.setDrugid(a.getDrugid());
                showtable.setDrugname(a.getDrugname());
                showtable.setFormat(a.getFormat());
                showtable.setManufacturer(a.getManufacturer());
                showtable.setOldprice(a.getOldprice());
                showtable.setNewprice(a.getNewprice());
                showtable.setAdjustid(a.getAdjustid());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                showtable.setDate(formatter.format(a.getDate()));
                showtable.setAdjustnumber(a.getAdjustnumber());
                showtable.setReason(a.getReason());
                showtables.add(showtable);
            }
            PageInfo<Showtable> pageInfo = new PageInfo<>(showtables);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int)pageInfo.getTotal());
            // 将list转为JSON格式传至前端
            resultDTO.setData(JSONArray.fromObject(showtables));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //发药界面右边simple2框值的重载
    @RequestMapping(value = "/getDispensing",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getDispensing(int page, int limit,String preid , Date today , Integer statu){
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Dispense> list = null;
        try {
            PageHelper.startPage(page, limit);
            if ((preid == null || preid =="") & today != null) {//存在日期和状态
                list = drugstoreService.getDispenseByTodayAndStatu(statu, today);
            } else if (preid != null & today == null & preid !="") {//存在处方号和状态
                list = drugstoreService.getDispenseByPreidAndStatu(preid, statu);
            } else if ( preid =="" & today == null & statu != null) {//仅存在状态
                list = drugstoreService.getDispenseByStatu(statu);
            } else if (preid != null & today != null) {//三值都存在
                list = drugstoreService.getDispenseByTriInfo(preid, statu, today);
            } else {//初始化的时候打印所有值
                list = drugstoreService.getAllDispense();
            }
//            List<Dispense> list = drugstoreService.getAllDispense();
            PageInfo<Dispense> pageInfo = new PageInfo<>(list);
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

    //发药界面中间的simple框值的重载
    @RequestMapping(value = "/getDispenselog",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getDispenselog(int page, int limit,String medicalrecordno){
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        List<Dispensecategory> list = null;
        try {
            PageHelper.startPage(page, limit);
            if (medicalrecordno != null) {
                list = drugstoreService.getCategoryByMedicalrecordno(medicalrecordno);
            } else {
                list = drugstoreService.getCategoryByMedicalrecordno("0");
            }
//            List<Dispensecategory> list = drugstoreService.getAllDispense();
            PageInfo<Dispensecategory> pageInfo = new PageInfo<>(list);
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

    //发药界面中间上面部分表单的重载
    @RequestMapping(value = "/getRegistInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<RegistrationInfo> getRegistInfo(String medicalrecordno){
        ResultDTO<RegistrationInfo> resultDTO = new ResultDTO();
        try {
            RegistrationInfo list = drugstoreService.getInfoByRecordno(medicalrecordno);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功");
            resultDTO.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //changestatus,通过病历号，用于（发药、全退）
    @RequestMapping(value = "/changestatus",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> changestatus(String medicalrecordno,int status) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issuccess = drugstoreService.upStatus(medicalrecordno, status);
            drugstoreService.updateDispenseStatu(medicalrecordno, status);
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

    //通过发药详情表id进行发药状态的改变，用于退部分药
    @RequestMapping(value = "/returnstatus",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> returnstatus(int id,int status,String medicalrecordid) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issuccess = drugstoreService.upreStatus(id, status);
            drugstoreService.updateDispenseStatu(medicalrecordid, status);
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

    //初始化退药弹窗
    @RequestMapping("/indexmakereturn")
    public String indexmakereturn(int id, Model model) {
        model.addAttribute("id", id);
        return "Pharmacy_Workstation/return/makereturn";
    }


    //    findreturninfo
    @RequestMapping(value = "/findreturninfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<Dispensecategory> findreturninfo(int id){
        ResultDTO<Dispensecategory> resultDTO = new ResultDTO();
        try {
            Dispensecategory list = drugstoreService.findDispenseLogById(id);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功");
            resultDTO.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    //退药
    @RequestMapping(value = "/returnmedicine",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> returnmedicine(int id,int amount,int renum) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int nowmount = amount - renum;
            int issuccess = drugstoreService.reMedicine(id, nowmount);
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

    //returnall,通过病历号，用于（发药、全退）
    //用病历号改变所有表格中的数量为0，用药id和数量遍历药品库存表，找到对应数据，加上值
    @RequestMapping(value = "/returnall",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> returnall(String medicalrecordno,Integer[] ids,Integer[] medicineids,Integer[] amounts) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int issuccess = drugstoreService.upreturnall(medicalrecordno);
            for (int i = 0; i < medicineids.length; i++) {
                drugstoreService.updateReturnamount(medicineids[i], amounts[i]);
            }
//            int issuccess = drugstoreService.upStatus(medicalrecordno, status);
//            drugstoreService.updateDispenseStatu(medicalrecordno, status);
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

//    dispensenall?medicineids="+medicineids+"&amounts="+amounts,
    @RequestMapping(value = "/dispensenall",method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> dispensenall(Integer[] medicineids,Integer[] amounts) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        int issuccess = 0;
        try {
            for (int i = 0; i < medicineids.length; i++) {
                issuccess = drugstoreService.updateDispenseamounr(medicineids[i], amounts[i]);
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

//    returnamount
//    dispensenall?medicineids="+medicineids+"&amounts="+amounts,
@RequestMapping(value = "/returnamount",method = RequestMethod.POST)
@ResponseBody
public ResultDTO<Integer> returnamount(Integer medicineid,Integer amount) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    int issuccess = 0;
    try {
        issuccess = drugstoreService.updateReturnamount(medicineid, amount);
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

//    sendtorefund
@RequestMapping(value = "/sendtorefund",method = RequestMethod.POST)
@ResponseBody
public ResultDTO<Integer> sendtorefund(String medicalrecordid,Integer medicineid,Integer renum) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    RefundDrug refundDrug = new RefundDrug();
    int issuccess = 0;
    try {
        refundDrug.setMedicalRecordNo(medicalrecordid);
        refundDrug.setExpenseId(String.valueOf(medicineid));
        refundDrug.setRefundNumber(renum);
        refundDrug.setPrescribeId(drugstoreService.getPrescribeID(medicalrecordid));
        issuccess = drugstoreService.insertRefundDrug(refundDrug);
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

//sendalltorefund
@RequestMapping(value = "/sendalltorefund",method = RequestMethod.POST)
@ResponseBody
public ResultDTO<Integer> sendalltorefund(String[] medicalrecordids,Integer[] medicineids,Integer[] renums) {
    ResultDTO<Integer> resultDTO = new ResultDTO();
    int issuccess = 0;
    try {
        for (int i = 0; i < medicalrecordids.length; i++) {
            RefundDrug refundDrug = new RefundDrug();
            refundDrug.setMedicalRecordNo(medicalrecordids[i]);
            refundDrug.setExpenseId(String.valueOf(medicineids[i]));
            refundDrug.setRefundNumber(renums[i]);
            refundDrug.setPrescribeId(drugstoreService.getPrescribeID(medicalrecordids[i]));
            issuccess = drugstoreService.insertRefundDrug(refundDrug);
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


}
