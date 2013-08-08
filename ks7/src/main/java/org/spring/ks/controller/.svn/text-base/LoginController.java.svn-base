package org.spring.ks.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.spring.ks.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class LoginController {
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MappingJacksonJsonView jsonView;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/ajaxLogin.html", method = RequestMethod.POST)
	public ModelAndView ajaxLogin(
			@RequestParam(value = "userid") String userid,
			@RequestParam(value = "userpwd") String userpwd,
			HttpSession session){
		
		logger.debug("["+getClass().getSimpleName()+"] [login] start");
		logger.info("["+getClass().getSimpleName()+"] [login] userid ["+userid+"]");
		logger.info("["+getClass().getSimpleName()+"] [login] userpwd ["+userpwd+"]");
		
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpwd", userpwd);
		
		try{
			Map<String, Object> users = loginService.userLogin(paramMap);
			
			if(users == null){
				mav.addObject("isSuccess",false);
				mav.addObject("error_msg","등록되지 않은 사용자입니다.");						
			}else{
				
				if(((String)users.get("USERPWD")).equals(userpwd)){
					users.remove("USERPWD");					
					mav.addObject("isSuccess",true);
					mav.addObject("LOGIN_USER", users);
					
					
					
					session.setAttribute("LOGIN_USER", users);
				}else{
					mav.addObject("isSuccess", false);
					mav.addObject("error_msg", "비밀번호가 일치하지 않습니다.");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("["+getClass().getSimpleName()+"] [login] 로그인 처리 중 오류발생");
			mav.addObject("isSuccess", false);
			mav.addObject("error_msg", "로그인 처리 중 오류발생가 발생하였습니다.");	
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/Login.html", method = RequestMethod.POST)
	public String Login(
			@RequestParam(value = "userid") String userid ,
			@RequestParam(value = "userpwd")  String userpwd ,
			HttpSession session ,
			Model model
			){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpwd", userpwd);		
		
		
		try{
			Map<String, Object> users = loginService.userLogin(paramMap);
			
			if(users == null){
				model.addAttribute("isSuccess",false);
				model.addAttribute("error_msg","등록되지 않은 사용자입니다.");						
			}else{
				if(((String)users.get("USERPWD")).equals(userpwd)){
					session.setAttribute("LOGIN_USER", users);
					
					model.addAttribute("isSuccess",true);
					model.addAttribute("error_msg","로그인 완료");
				}else{
					model.addAttribute("isSuccess",false);
					model.addAttribute("error_msg","등록되지 않은 비밀번호가 틀립니다.");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("["+getClass().getSimpleName()+"] [login] 로그인 처리 중 오류발생");
		}
		
		
		return "redirect:home.html";
	}
	
	@RequestMapping(value = "/Logout.html", method = RequestMethod.GET)
	public String Logout(HttpSession session){		
		//session.setAttribute("LOGIN_USER", null);
		
		session.invalidate(); 
		
		return "redirect:home.html";
	}
	
}
