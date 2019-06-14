package com.neusoft.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fifthpart")
public class FifthPartController {
    @RequestMapping(value = "/index")
    public String index(String id) {
        if (id.equals("01"))
        return "fifthpart/null";
        else if(id.equals("02"))
            return "fifthpart/medical_record/medical_record";
        else
            return "fifthpart/inspection_application/inspection_application";
    }
}
