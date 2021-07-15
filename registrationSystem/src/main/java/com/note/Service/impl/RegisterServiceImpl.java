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
		//����ԤԼ
	   @Override
		public int AddRegister(Register reg) {
			return regDao.AddRegister(reg);
		};
		//��ȡ����ԤԼ��Ϣ
		@Override
		public List<Register> getAllRegister(){
			return regDao.getAllRegister();
		};
	@Override
		public List<Register> getAllRegisterByName(String hzUsername){
			return regDao.getAllRegisterByName(hzUsername);
		};
		//����ԤԼ״̬
		@Override
		public int UpdateghStatus(Register reg){
			return regDao.UpdateghStatus(reg);
		};
		//ɾ��ԤԼ��¼
		@Override
		public int UpdateStatus(Register reg) {
			return regDao.UpdateStatus(reg);
		};
		//����id�鿴ԤԼ��Ϣ
		@Override
		public Register getRegById(Integer id) {
			return regDao.getRegById(id);
		};
}
