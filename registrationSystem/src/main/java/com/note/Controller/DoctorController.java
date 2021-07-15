package com.note.Controller;

import com.note.Model.Doctor;
import com.note.Service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DoctorController {

	@Resource  
	private DoctorService docService;

	/**
	 * 添加医生
	 * @param doc
	 * @return
	 */
	@RequestMapping("addDoc.do")
	@ResponseBody
	public String add(Doctor doc) {

		String result = "";
		String docName = doc.getDoctorName();

		try{
			System.out.println("开始启动insert");
			Doctor doc1 = docService.selectDoctorByName(docName);
			Integer id = doc1.getDoctorId();
			//查询到数据 返回前台账号已存在
			if(id != null) {
				result = "exists";
			}
		}catch(Exception e) {
			//查询不到数据时 插入数据
			System.out.println("开始insert进数据库");
			docService.AddDoctor(doc);
			int pid = doc.getDoctorId();
			System.out.println(pid);
			result = "success";
		}

		System.out.println(result);
		return result;
	}

	/**
	 * 获取医生列表
	 * @return
	 */
	@RequestMapping("getDocList.do")
	@ResponseBody
	public List<Doctor> getDocLists() {
		List<Doctor> doctList = null;
		
		try{
			doctList = docService.getAllDoctorInfo();
			Integer length = doctList.size();
			//查询到数据 返回前台账号已存在
			if(length > 0) {
				return doctList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(doctList);
		return doctList;
	}
	
	@RequestMapping("getDocById.do")
	@ResponseBody
	public Doctor getDeptById(Doctor doc) {
		Doctor Doc = null;
		Integer id = doc.getDoctorId();
		
		try{
			Doctor doc1 = docService.getDoctorById(id);
			Integer docId = doc1.getDoctorId();
			if(docId != null) {
				Doc = doc1;
			}
		}catch(Exception e) {
			
		}
		return Doc;
	}

	/**
	 * 修改医生
	 * @param doc
	 * @return
	 */
	@RequestMapping("updateDoc.do")
	@ResponseBody
	public String updateDoc(Doctor doc) {
		System.out.println("update");
		String result = "";
		
		try{
			int id = docService.updateDoctor(doc);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}

	/**
	 * 删除医生
	 * @param doc
	 * @return
	 */
	@RequestMapping("updateDoctorStatus.do")
	@ResponseBody
	public String updateDocStatus(Doctor doc) {
		String result = "";
		
		try{
			int id = docService.updateDoctorStatus(doc);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}

	/**
	 * 修改医生上班状态
	 * @param doc
	 * @return
	 */
	@RequestMapping("updateDocWorkStatus.do")
	@ResponseBody
	public String updateDocWorkStatus(Doctor doc) {
		String result = "";
		
		try{
			int id = docService.updateDocWorkStatus(doc);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}

	/**
	 * 根据部门获取医生
	 * @param doc
	 * @return
	 */
	@RequestMapping("getDoctorByDeptId.do")
	@ResponseBody
	public List<Doctor> getDoctorByDeptId(Doctor doc) {
		List<Doctor> doctList = null;
		int id = doc.getDeptId();
		try{
			doctList = docService.getDoctorByDeptId(id);
			Integer length = doctList.size();
			//查询到数据 返回前台账号已存在
			if(length > 0) {
				return doctList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(doctList);
		return doctList;
	}
	
}
