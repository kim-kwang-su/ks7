package org.spring.ks.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.spring.ks.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class JoinController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private JoinService joinService;
	
	
	@RequestMapping(value = "/joinForm.html", method=RequestMethod.GET)
	public String joinForm(){
		return "/register/joinForm";
	}
	
	@RequestMapping(value = "/joinProcess.html", method=RequestMethod.POST)
	public String joinProcess(
			@RequestParam(value = "userid") String userid,
			@RequestParam(value = "userpwd") String userpwd,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "birth") String birth,
			@RequestParam(value = "birth_fl") String birth_fl,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "job") String job,
			@RequestParam(value = "home_tel") String home_tel,
			@RequestParam(value = "sel_hand_tel_agency") String sel_hand_tel_agency,
			@RequestParam(value = "hand_tel") String hand_tel,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "dm_fl") String dm_fl,
			@RequestParam(value = "ds_fl") String ds_fl
			){
		
		int isSuccess = -1;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpwd", userpwd);
		paramMap.put("username", username);
		paramMap.put("birth", birth);
		paramMap.put("birth_fl", birth_fl);
		paramMap.put("address", address);
		paramMap.put("job", job);
		paramMap.put("home_tel", home_tel);
		paramMap.put("sel_hand_tel_agency", sel_hand_tel_agency);
		paramMap.put("hand_tel", hand_tel);
		paramMap.put("email", email);
		paramMap.put("dm_fl", dm_fl);
		paramMap.put("ds_fl", ds_fl);		
		
		isSuccess = joinService.memberInsert(paramMap);
		
		if(isSuccess > 0){
			return "redirect:/home.html"; 
		}else{
			System.out.println("ERROR");			
			return null;
		} 
	}
}
