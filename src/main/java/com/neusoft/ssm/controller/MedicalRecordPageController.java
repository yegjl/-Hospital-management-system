package com.neusoft.ssm.controller;

import com.neusoft.ssm.bean.CommonDiagnosis;
import com.neusoft.ssm.bean.Diagnosis;
import com.neusoft.ssm.bean.MedicalRecordPage;
import com.neusoft.ssm.bean.MedicalRecordPageTemplate;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.MedicalRecordService;
import com.neusoft.ssm.service.RegisterService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("MedicalRecordPage")
public class MedicalRecordPageController {
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    RegisterService registerService;
    List<Diagnosis> diagnosisList = new ArrayList<>();

    @RequestMapping("/index")
    public String index(Model model, HttpSession session,String medicalRecordNo,Integer isSeen) {
        List<CommonDiagnosis> list = medicalRecordService.findAllCommonDiagnosis(2);
        diagnosisList = new ArrayList<>();
        Diagnosis diagnosis = null;
        for (CommonDiagnosis commonDiagnosis : list) {
            diagnosis = medicalRecordService.findDiagnosisByID(commonDiagnosis.getDiagnosisid());
            diagnosis.setMedicalRecordNo("2019061700001");
            diagnosisList.add(diagnosis);
        }
        session.setAttribute("doctorid", 2);
        model.addAttribute("medicalRecordNo", medicalRecordNo);
        model.addAttribute("isSeen", isSeen);
        model.addAttribute("CommonDiagnosises", replaceIDToName(diagnosisList));
        return "fifthpart/medical_record/medical_record";
    }

    @RequestMapping("/indexcost")
    public String indexcost() {
        return "fifthpart/medical_record/cost_inquiry";
    }
    @RequestMapping("/getsets")
    @ResponseBody
    //todo:根据医生id获取病历模板()
    public List<MedicalRecordPageTemplate> getsets(HttpSession session, String medicalRecordNo, Model model) {
        List<MedicalRecordPageTemplate> list = medicalRecordService.getSet((Integer) session.getAttribute("doctorid"));
        return JSONArray.fromObject(list);
    }

    @RequestMapping("/getTemplate")
    @ResponseBody
    public ResultDTO<MedicalRecordPage> getTemplate(Integer id, Model model) {
        ResultDTO<MedicalRecordPage> resultDTO = new ResultDTO<>();
        try {
            MedicalRecordPageTemplate medicalRecordPageTemplate = medicalRecordService.getSetByID(id);
            MedicalRecordPage medicalRecordPage = medicalRecordService.findById(medicalRecordPageTemplate.getMedicalRecordPageId());
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(medicalRecordPage);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;

    }
    @RequestMapping("/getHistory")
    @ResponseBody
    public ResultDTO<MedicalRecordPage> getHistory(String medicalRecordNo) {
        ResultDTO<MedicalRecordPage> resultDTO = new ResultDTO<>();
        try {
            MedicalRecordPage medicalRecordPage = medicalRecordService.findBymedicalRecordNo(medicalRecordNo);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(medicalRecordPage);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;

    }
    @RequestMapping("/quezhen")
    @ResponseBody
    public ResultDTO<Integer> quezhen(String medicalRecordNo) {
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        try {
            int success = registerService.quezhen(medicalRecordNo);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(success);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;

    }
    @RequestMapping("/indexadd")
    public String indexAdd(String medicalRecordNo, Model model) {
        model.addAttribute("medicalRecordNo", medicalRecordNo);
        model.addAttribute("diseases", medicalRecordService.findallDisease());
        return "fifthpart/medical_record/add";
    }

    @RequestMapping("/indexupdate")
    public String indexupdate(String medicalRecordNo, Model model, String date, String flag, Integer diseaseid, Integer id) {
        model.addAttribute("medicalRecordNo", medicalRecordNo);
        model.addAttribute("id", id);
        model.addAttribute("diseaseid", diseaseid);
        model.addAttribute("flag", flag);
        model.addAttribute("date", date);
        model.addAttribute("diseases", medicalRecordService.findallDisease());
        return "fifthpart/medical_record/update";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<Integer> submit(MedicalRecordPage medicalRecordPage,HttpSession session) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        medicalRecordPage.setDoctorid((Integer) session.getAttribute("doctorid"));
        try {
            int issuccess = medicalRecordService.insertSelective(medicalRecordPage);
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

    @RequestMapping(value = "/findDiaAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<List<Diagnosis>> findDiaAll(String medicalRecordNo) {
        ResultDTO<List<Diagnosis>> resultDTO = new ResultDTO();
        try {
            List<Diagnosis> list = medicalRecordService.findDiaAllBymedicalRecordNo(medicalRecordNo);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(JSONArray.fromObject(replaceIDToName(list)));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }
    @RequestMapping(value = "/findDiaAllAndSub", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<Diagnosis>> findDiaAllAndSub(String medicalRecordNoNew,String medicalRecordNoOld) {
        ResultDTO<List<Diagnosis>> resultDTO = new ResultDTO();
        try {
            medicalRecordService.deleteDiaByMedNo(medicalRecordNoNew);
            List<Diagnosis> list = medicalRecordService.findDiaAllBymedicalRecordNo(medicalRecordNoOld);
            for (Diagnosis diagnosis:list) {
                diagnosis.setId(null);
                diagnosis.setMedicalRecordNo(medicalRecordNoNew);
                if (diagnosis.getFlag() == null) {
                    diagnosis.setFlag("0");
                }

                medicalRecordService.insertSelectiveDia(diagnosis);
            }
            List<Diagnosis> listnew = medicalRecordService.findDiaAllBymedicalRecordNo(medicalRecordNoNew);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(JSONArray.fromObject(replaceIDToName(listnew)));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }
    @RequestMapping(value = "/findDiaYi", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO<List<Diagnosis>> findDiaYi(String medicalRecordNo) {
        ResultDTO<List<Diagnosis>> resultDTO = new ResultDTO();
        try {
            List<Diagnosis> list = medicalRecordService.findDiaAllBymedicalRecordNo(medicalRecordNo);
            resultDTO.setStatus(0);
            resultDTO.setMessage("操作成功！");
            resultDTO.setData(JSONArray.fromObject(replaceIDToName(list)));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }
//    @RequestMapping(value = "/findDname", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultDTO<List<Disease>> findDname() {
//        ResultDTO<List<Disease>> resultDTO = new ResultDTO();
//        try {
//            List<Disease> list = medicalRecordService.findallDisease();
//            resultDTO.setStatus(0);
//            resultDTO.setMessage("操作成功！");
//            resultDTO.setData(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultDTO.setStatus(1);
//            resultDTO.setMessage("操作失败！");
//        }
//        return resultDTO;
//    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO<Integer> add(Diagnosis diagnosis, Integer index, Model model) {
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        if (diagnosis.getFlag() == null) {
            diagnosis.setFlag("0");
        }

        try {
            int issuccess = medicalRecordService.insertSelectiveDia(diagnosis);
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

    @RequestMapping("/update")
    @ResponseBody
    public ResultDTO<Integer> update(Diagnosis diagnosis, Integer index, Model model) {
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        if (diagnosis.getFlag() == null) {
            diagnosis.setFlag("0");
        }

        try {
            int issuccess = medicalRecordService.updateDia(diagnosis);
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

    @RequestMapping("/delete")
    @ResponseBody
    public ResultDTO<Integer> delete(Integer id, Integer index, Model model) {
        ResultDTO<Integer> resultDTO = new ResultDTO<>();


        try {
            int issuccess = medicalRecordService.deleteDia(id);
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

    @RequestMapping("/addcommon")
    @ResponseBody
    public ResultDTO<Integer> addcommon(Integer index) {
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        Diagnosis diagnosis = diagnosisList.get(index);
        if (diagnosis.getFlag() == null) {
            diagnosis.setFlag("0");
        }
        try {
            int issuccess = medicalRecordService.insertSelectiveDia(diagnosis);
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

    private List<Diagnosis> replaceIDToName(List<Diagnosis> list) {
        for (Diagnosis diagnosis : list) {
            diagnosis.setDiseasename(medicalRecordService.findDiseaseById(diagnosis.getDiseaseid()).getDiseasename());
        }
        return list;

    }
}
