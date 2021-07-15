package com.note.Service.impl;

import com.note.Dao.DoctorDao;
import com.note.Model.Doctor;
import com.note.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao docDao;
	@Override
	 public Doctor selectDoctorByName(String docName){
	      return docDao.selectDoctorByName(docName);
	 }
	@Override
	 public int AddDoctor(Doctor doc){  
	      return docDao.AddDoctor(doc);
	 }
	@Override
	 public List<Doctor> getAllDoctorInfo() {
		 return docDao.getAllDoctorInfo();
	 }
	@Override
	 public Doctor getDoctorById(Integer id) {
		 return docDao.getDoctorById(id);
	 }
	@Override
	 public int updateDoctor(Doctor doc) {
		 return docDao.updateDoctor(doc);
	 }
	@Override
	 public int updateDoctorStatus(Doctor doc) {
		 return docDao.updateDoctorStatus(doc);
	 }
	@Override
	 public int updateDocWorkStatus(Doctor doc) {
		 return docDao.updateDocWorkStatus(doc);
	 }
	@Override
	 public List<Doctor> getDoctorByDeptId(Integer id){
		 return docDao.getDoctorByDeptId(id);
	 }
}
