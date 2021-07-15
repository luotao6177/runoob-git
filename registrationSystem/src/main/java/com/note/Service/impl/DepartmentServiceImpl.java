package com.note.Service.impl;

import com.note.Dao.DepartmentDao;
import com.note.Model.Department;
import com.note.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao deptDao;
	@Override
	 public Department selectDeptByName(String deptName){
	      return deptDao.selectDeptByName(deptName);
	 }
	@Override
	 public int AddDepartment(Department dept){  
	      return deptDao.AddDepartment(dept);
	 }
	@Override
	 public int updateDeptByDept(Department dept) {
		 return deptDao.updateDeptByName(dept);
	 }
	@Override
	 public List<Department> getAllDeptInfo() {
		 return deptDao.getAllDeptInfo();
	 }
	@Override
	 public Department getDeptById(Integer id) {
		 return deptDao.getDeptById(id);
	 }
	@Override
	 public int updateDept(Department dept) {
		 return deptDao.updateDept(dept);
	 }
	@Override
	 public int updateDeptStatus(Department dept) {
		 return deptDao.updateDeptStatus(dept);
	 }
}
