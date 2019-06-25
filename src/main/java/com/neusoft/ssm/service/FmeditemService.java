package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Fmeditem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FmeditemService {

    Fmeditem findByItemCode(String itemCode);
    int uploadUserXls(MultipartFile file) throws IOException;

    List<Fmeditem> findAll();
    Fmeditem findById(Integer id);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Fmeditem record);
    int updateByPrimaryKeySelective(Fmeditem record);

    void createUserListExcel();


}
