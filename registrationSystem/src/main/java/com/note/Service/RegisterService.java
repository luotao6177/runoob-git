package com.note.Service;

import com.note.Model.Register;

import java.util.List;

public interface RegisterService {
		//新增预约
		int AddRegister(Register reg);
		//获取所有预约信息
		List<Register> getAllRegister();
		//更新预约状态
		int UpdateghStatus(Register reg);
		//删除预约记录
		int UpdateStatus(Register reg);
		//根据id查看预约信息
		Register getRegById(Integer id);
		
		List<Register> getAllRegisterByName(String hzUsername);
}
