package com.note.Dao;

import java.util.List;

import com.note.Model.Register;

public interface RegisterDao {
	
	//����ԤԼ
	int AddRegister(Register reg);
	//��ȡ����ԤԼ��Ϣ
	List<Register> getAllRegister();
	//����ԤԼ״̬
	int UpdateghStatus(Register reg);
	//ɾ��ԤԼ��¼
	int UpdateStatus(Register reg);
	//����id�鿴ԤԼ��Ϣ
	Register getRegById(Integer id);
	
	List<Register> getAllRegisterByName(String hzName);
}
