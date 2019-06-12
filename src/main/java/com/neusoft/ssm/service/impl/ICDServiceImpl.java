package com.neusoft.ssm.service.impl;

import com.neusoft.ssm.bean.Disease;
import com.neusoft.ssm.bean.Diswithcate;
import com.neusoft.ssm.bean.Icd;
import com.neusoft.ssm.dao.DiseaseDao;
import com.neusoft.ssm.dao.DiswithcateDao;
import com.neusoft.ssm.dao.IcdDao;
import com.neusoft.ssm.service.ICDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ICDServiceImpl implements ICDService {
    @Autowired
    private IcdDao icdDao;
    @Autowired
    private DiseaseDao diseaseDao;
    @Autowired
    private DiswithcateDao diswithcateDao;

    @Override
    public Map<String,String> findFirstName() {
        Map<String,Map<String,String>> objectMap= icdDao.selectFirstName();
        Map<String, String> rmap = new HashMap<>();
        for (Map.Entry<String,Map<String,String>> entry:objectMap.entrySet()) {
            rmap.put(entry.getValue().get("ICDid"),entry.getValue().get("ICDFirstName") );
        }
        List<Map.Entry<String,String>> list = new ArrayList<>(rmap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                if (Integer.valueOf(o1.getKey()) >= Integer.valueOf(o2.getKey())) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
        rmap=new HashMap<>();
        for (Map.Entry<String,String> entry:list) {
            rmap.put(entry.getKey(), entry.getValue());
        }
//        Map<String, String> sortMap =
        System.out.println();
        return rmap;
    }

    @Override
    public List<Icd> findSecondName(String icdid) {
        return icdDao.selectSecondName(icdid);
    }

    @Override
    public List<Diswithcate> findAll(String ICDID) {
        return diswithcateDao.selectAll(ICDID);
    }

    @Override
    public int doinsert(Disease record) {
        return diseaseDao.insertSelective(record);
    }

    @Override
    public int deleteByKey(int id) {
        return diseaseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateDisease(Disease record) {
        return diseaseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Diswithcate> findSearch(String keyword, String secondid) {
        return diswithcateDao.getSearch(keyword,secondid);
    }

}
