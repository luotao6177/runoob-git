package com.note.Controller;

import com.note.Model.Department;
import com.note.Service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {

	@Resource  
	private DepartmentService deptService;

	/**
	 * ��ӿ���
	 * @param dept
	 * @return
	 */
	@RequestMapping("addDept.do")
	@ResponseBody
	public String add(Department dept) {
		String result = "";
		String deptName = dept.getDepartmentName();

		try{
			System.out.println("��ʼ����insert");
			Department Dept = deptService.selectDeptByName(deptName);
			System.out.println(Dept);
			Integer id = Dept.getDepartmentId();
			//��ѯ������ ����ǰ̨�˺��Ѵ���
			if(id != null) {
				result = "exists";
			}
		}catch(Exception e) {
			//��ѯ��������ʱ ��������
			System.out.println("��ʼinsert�����ݿ�");
			deptService.AddDepartment(dept);
			int pid = dept.getDepartmentId();
			System.out.println(pid);
			result = "success";
		}

		System.out.println(result);
		return result;
	}

	/**
	 * ��ȡ�����б�
	 * @return
	 */
	@RequestMapping("getDeptList.do")
	@ResponseBody
	public List<Department> getDeptLists() {
		List<Department> deptList = null;
		
		try{
			deptList = deptService.getAllDeptInfo();
			Integer length = deptList.size();
			//��ѯ������ ����ǰ̨�˺��Ѵ���
			if(length > 0) {
				return deptList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(deptList);
		return deptList;
	}
	
	@RequestMapping("getDeptById.do")
	@ResponseBody
	public Department getDeptById(Department dept) {
		Department Dept = null;
		Integer id = dept.getDepartmentId();
		
		try{
			Department dept1 = deptService.getDeptById(id);
			Integer deptId = dept1.getDepartmentId();
			if(deptId != null) {
				Dept = dept1;
			}
		}catch(Exception e) {
			
		}
		return Dept;
	}

	/***
	 * �޸Ŀ�����Ϣ
	 * @param dept
	 * @return
	 */
	@RequestMapping("updateDept.do")
	@ResponseBody
	public String updateDept(Department dept) {
		System.out.println("update");
		System.out.println(dept);
		String result = "";
		
		try{
			int id = deptService.updateDept(dept);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}
	
	@RequestMapping("updateDeptStatus.do")
	@ResponseBody
	public String updateDeptStatus(Department dept) {
		String result = "";
		
		try{
			int id = deptService.updateDeptStatus(dept);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}
	
}
