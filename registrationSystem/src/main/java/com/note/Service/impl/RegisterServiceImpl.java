package com.note.Service.impl;

import com.note.Dao.RegisterDao;
import com.note.Model.Register;
import com.note.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterDao regDao;
		//新增预约
	   @Override
		public int AddRegister(Register reg) {
			return regDao.AddRegister(reg);
		};
		//获取所有预约信息
		@Override
		public List<Register> getAllRegister(){
			return regDao.getAllRegister();
		};
	@Override
		public List<Register> getAllRegisterByName(String hzUsername){
			return regDao.getAllRegisterByName(hzUsername);
		};
		//更新预约状态
		@Override
		public int UpdateghStatus(Register reg){
			return regDao.UpdateghStatus(reg);
		};
		//删除预约记录
		@Override
		public int UpdateStatus(Register reg) {
			return regDao.UpdateStatus(reg);
		};
		//根据id查看预约信息
		@Override
		public Register getRegById(Integer id) {
			return regDao.getRegById(id);
		};
}
