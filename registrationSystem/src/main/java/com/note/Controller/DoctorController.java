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
	 * ���ҽ��
	 * @param doc
	 * @return
	 */
	@RequestMapping("addDoc.do")
	@ResponseBody
	public String add(Doctor doc) {

		String result = "";
		String docName = doc.getDoctorName();

		try{
			System.out.println("��ʼ����insert");
			Doctor doc1 = docService.selectDoctorByName(docName);
			Integer id = doc1.getDoctorId();
			//��ѯ������ ����ǰ̨�˺��Ѵ���
			if(id != null) {
				result = "exists";
			}
		}catch(Exception e) {
			//��ѯ��������ʱ ��������
			System.out.println("��ʼinsert�����ݿ�");
			docService.AddDoctor(doc);
			int pid = doc.getDoctorId();
			System.out.println(pid);
			result = "success";
		}

		System.out.println(result);
		return result;
	}

	/**
	 * ��ȡҽ���б�
	 * @return
	 */
	@RequestMapping("getDocList.do")
	@ResponseBody
	public List<Doctor> getDocLists() {
		List<Doctor> doctList = null;
		
		try{
			doctList = docService.getAllDoctorInfo();
			Integer length = doctList.size();
			//��ѯ������ ����ǰ̨�˺��Ѵ���
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
	 * �޸�ҽ��
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
	 * ɾ��ҽ��
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
	 * �޸�ҽ���ϰ�״̬
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
	 * ���ݲ��Ż�ȡҽ��
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
			//��ѯ������ ����ǰ̨�˺��Ѵ���
			if(length > 0) {
				return doctList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(doctList);
		return doctList;
	}
	
}
