package com.note.Dao;

import com.note.Model.Department;

import java.util.List;

/**
 * 描述:用户mapper接口
 * 
 */
public interface DepartmentDao {
	
	Department selectDeptByName(String deptName);
   
    int AddDepartment(Department dept);
    
    int updateDeptByName(Department dept);
    
    List getAllDeptInfo();
    
    Department getDeptById(Integer id);
    
    int updateDept(Department dept);
    
    int updateDeptStatus(Department dept);
}
