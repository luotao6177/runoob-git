package com.note.Service;

import java.util.List;

import com.note.Model.Department;

public interface DepartmentService {
	//��������
	int AddDepartment(Department dept);
	//��������
	Department selectDeptByName(String deptName);
	//���¿�������
	int updateDeptByDept(Department dept);
	//��ȡ���п���
	List getAllDeptInfo();
	//��ȡ��������
	Department getDeptById(Integer id);
	//���¿�����Ϣ
	int updateDept(Department dept);
	//
	int updateDeptStatus(Department dept);
}
