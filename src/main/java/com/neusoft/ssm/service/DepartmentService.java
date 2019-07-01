package com.neusoft.ssm.service;

import com.neusoft.ssm.bean.Department;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    String findNameById(String DeptCode);
    String findTypeByCode(String DeptCode);
    int uploadUserXls(MultipartFile file) throws IOException;
    Map<String,String> findDistinctID();
    List<Department> findByDeptcgID(String id);
    List<Department> findAll();
    Department findById(Integer id);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Department record);
    int updateByPrimaryKeySelective(Department record);
    List<Department> getSearchDept(String keyword,String CgID);
    String getNameById(Integer id);
    List<Department> findByDeptType(String DeptType);
    Long findIdByCode(String DeptCode);
    String findCodeByID(Integer departid);
}
