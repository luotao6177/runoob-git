package com.note.Model;

public class Doctor {
	
	private Integer doctorId;//ҽ��id
	private Integer deptId;//����id
	private String deptName;
	private String doctorName;//ҽ������
	private String doctorDes;//ҽ������
	private Integer workStatus;//�ϰ�״̬
	private String workTime;//�ϰ�ʱ��
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDes() {
		return doctorDes;
	}
	public void setDoctorDes(String doctorDes) {
		this.doctorDes = doctorDes;
	}
	public Integer getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
}
