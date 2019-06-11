package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Fmeditem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FmeditemService {
    //    @Override
    //    public List<Department> getSearchDept(String keyword,String CgID) {
    //        return fmeditemDao.searchDept(keyword,CgID);
    //    }

    int uploadUserXls(MultipartFile file) throws IOException;
//    Map<String,String> findDistinctID();
//    List<Fmeditem> findByDeptcgID(String id);
    List<Fmeditem> findAll();
    Fmeditem findById(Integer id);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Fmeditem record);
    int updateByPrimaryKeySelective(Fmeditem record);

    //    @Override
    //    public List<Department> getSearchDept(String keyword,String CgID) {
    //        return fmeditemDao.searchDept(keyword,CgID);
    //    }
    void createUserListExcel();

//    List<Fmeditem> getSearchDept(String keyword, String CgID);
}
