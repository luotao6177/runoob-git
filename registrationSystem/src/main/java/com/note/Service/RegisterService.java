package com.note.Service;

import com.note.Model.Register;

import java.util.List;

public interface RegisterService {
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
		
		List<Register> getAllRegisterByName(String hzUsername);
}
