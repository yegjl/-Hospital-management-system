package com.neusoft.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.ssm.bean.Examcheckone;
import com.neusoft.ssm.dto.ResultDTO;
import com.neusoft.ssm.service.ExamcheckService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String index(String id) {
        if (id.equals("01"))
        return "fifthpart/null";
        else if(id.equals("02"))
            return "fifthpart/medical_record/medical_record";
        else
            return "fifthpart/inspection_application/inspection_application";
    }

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
                    examcheckone.setStatus("未开立");
                else if (examcheckone.getStatus().equals("1"))
                    examcheckone.setStatus("已开立");
                else if (examcheckone.getStatus().equals("2"))
                    examcheckone.setStatus("已作废");
                else if (examcheckone.getStatus().equals("3"))
                    examcheckone.setStatus("已登记");
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
        return resultDTO;
    }
}
