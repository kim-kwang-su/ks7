package org.spring.ks.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.spring.ks.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/event")
public class EventController {
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/eventLove.html", method=  RequestMethod.GET)	
	public String eventLove(
			@RequestParam(value="eventid", defaultValue="2013050802") String eventid ,
			Model model ){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("eventid", eventid);
		
		List<Map<String, Object>> getLoveList = eventService.getLoveList(paramMap);		
		model.addAttribute("getLoveList", getLoveList);		
		
		return "/event/love";
	}
	
	@RequestMapping(value = "/eventLoveInsert.html" , method = RequestMethod.POST)
	public String eventLoveInsert(
			@RequestParam(value = "eventid", defaultValue="2013050802") String eventid ,
			@RequestParam(value = "contents") String contents ,
			HttpSession session
			){
		
		Map<String, Object> sessionUser = (Map<String, Object>)session.getAttribute("LOGIN_USER");
		
		int isSuccess = -1;
		Map<String, Object> paramMap = new HashMap<String, Object>();		
		paramMap.put("managerid", sessionUser.get("MANAGERID"));
		paramMap.put("userid", sessionUser.get("USERID"));
		paramMap.put("username", sessionUser.get("USERNAME"));
		paramMap.put("contents", contents);
		paramMap.put("eventid", eventid);
		
		isSuccess = eventService.eventLoveInsert(paramMap);
		if(isSuccess > 0){
			return "redirect:eventLove.html";		 
		}else{
			System.out.println("ERROR");			
			return null;
		} 
		
	}
}
