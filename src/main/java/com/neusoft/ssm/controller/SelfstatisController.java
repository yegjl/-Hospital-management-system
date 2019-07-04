package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Statisticsview;
import com.neusoft.ssm.bean.Teststatis;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.StatisticsviewService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("selfstatis")
public class SelfstatisController {
    @Autowired
    private StatisticsviewService statisticsviewService;


    //    indexselfstatis
    @RequestMapping(value = "/indexselfstatis")
    public String indexselfstatis(int doctorid,Model model){
        int amount = statisticsviewService.getCount(doctorid);
        model.addAttribute("amount", amount);
        return "fifthpart/Statistics";
    }

    @RequestMapping(value = "/indexpan")
    public String indexpan(String medicalrecordid,Model model){
        model.addAttribute("medicalrecordid", medicalrecordid);
        return "fifthpart/Panpicture";
    }

    @RequestMapping(value = "/getPatientCount", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<Integer> getPatientCount(int doctorid) {
        ResultDTO<Integer> resultDTO = new ResultDTO();
        try {
            int amount = statisticsviewService.getCount(doctorid);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setData(amount);
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/getPatient", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<JSONArray> getPatient(int doctorid, int page, int limit) {
        ResultDTO<JSONArray> resultDTO = new ResultDTO();
        try {
            PageHelper.startPage(page, limit);
            List<Statisticsview> list = statisticsviewService.selectAllPatient(doctorid);
            List<Teststatis> teststatis = new ArrayList<>();
            for (Statisticsview s : list) {
                Teststatis t = new Teststatis();
                t.setMedicalRecordNo(s.getMedicalRecordNo());
                t.setPatientName(s.getPatientName());
                teststatis.add(t);
            }
            PageInfo<Teststatis> pageInfo = new PageInfo<>(teststatis);
            resultDTO.setStatus(0);
            resultDTO.setMessage("");
            resultDTO.setTotal((int) pageInfo.getTotal());
            // 将list转为JSON格式传至前端
            resultDTO.setData(JSONArray.fromObject(teststatis));
        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setStatus(1);
            resultDTO.setMessage("操作失败！");
        }
        return resultDTO;
    }

    @RequestMapping(value = "/paninfo", method = RequestMethod.POST)
    @ResponseBody
    public Double[] paninfo(String medicalrecordid){
        Double[] moneys = {0.0,0.0,0.0,0.0};
        List<Statisticsview> statisticsviews = statisticsviewService.selectByMedicalrecordid(medicalrecordid);
        for (Statisticsview s : statisticsviews) {
            double mmm = Double.valueOf(s.getPrice());
            if (s.getMark().equals("0")) {
                moneys[0] += s.getNumber() * mmm;
            } else if (s.getMark().equals("1")) {
                moneys[1] += s.getNumber() * mmm;
            } else {
                moneys[2] += s.getNumber() * mmm;
            }
        }
        double dd = statisticsviewService.selectMoney(medicalrecordid).doubleValue();
        moneys[3] += dd;

        return moneys;
    }
}
