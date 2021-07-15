package com.note.Controller;

import com.note.Model.Register;
import com.note.Service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RegisterController {
	
	@Resource  
	private RegisterService regService;

	/**
	 * 挂号
	 * @param reg
	 * @return
	 */
	@RequestMapping("addReg.do")
	@ResponseBody
	public String add(Register reg) {
		
		String result = "";
		System.out.println(reg);
		
		try{
			System.out.println("开始启动insert");
			int id = regService.AddRegister(reg);
			if( reg.getRegisterId() > 0) {
				result = "success";
			}
		}catch(Exception e) {
			e.printStackTrace();
			result = "error";
		}
			
		System.out.println(result);
		return result; 
	}

	/**
	 * 获取挂号单
	 * @return
	 */
	@RequestMapping("getRegList.do")
	@ResponseBody
	public List<Register> getRegisterLists() {
		List<Register> regList = null;
		
		try{
			regList = regService.getAllRegister();
			Integer length = regList.size();
			//查询到数据 返回前台账号已存在
			if(length > 0) {
				return regList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(regList);
		return regList;
	}

	/**
	 * 根据用户名获取挂号单
	 * @param reg
	 * @return
	 */
	@RequestMapping("getRegListByName.do")
	@ResponseBody
	public List<Register> getRegisterListsByName(Register reg) {
		List<Register> regList = null;
		String hzUsername = reg.getHzUsername();
		try{
			regList = regService.getAllRegisterByName(hzUsername);
			Integer length = regList.size();
			//查询到数据 返回前台账号已存在
			if(length > 0) {
				return regList;
			}
		}catch(Exception e) {
			
		}
		System.out.println(regList);
		return regList;
	}
	
	@RequestMapping("getRegById.do")
	@ResponseBody
	public Register getRegById(Register reg) {
		Register Reg = null;
		Integer id = reg.getRegisterId();
		
		try{
			Register reg1 = regService.getRegById(id);
			Integer regId = reg1.getDoctorId();
			if(regId != null) {
				Reg = reg1;
			}
		}catch(Exception e) {
			
		}
		return Reg;
	}

	/**
	 * 修改挂号状态
	 * @param reg
	 * @return
	 */
	@RequestMapping("updateghStatus.do")
	@ResponseBody
	public String updateghStatus(Register reg) {
		String result = "";
		
		try{
			int id = regService.UpdateghStatus(reg);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}

	/**
	 * 修改挂号状态
	 * @param reg
	 * @return
	 */
	@RequestMapping("updateStatus.do")
	@ResponseBody
	public String updateStatus(Register reg) {
		String result = "";
		
		try{
			int id = regService.UpdateStatus(reg);
			
			if(id > 0) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}
}
