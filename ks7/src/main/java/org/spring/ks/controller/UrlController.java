package org.spring.ks.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlController {
	Logger logger = Logger.getLogger(getClass());	
	
	@RequestMapping(value=  "/url/test.html", method=RequestMethod.GET)		
	public String ks71(Model model, @RequestParam String milk){
		
		model.addAttribute("milkvalue", milk);
		return "/url/aa";		
	}
	
	@RequestMapping(value=  "/url/test.html/milk/{milk}", method=RequestMethod.GET)		
	public String ks72(Model model, @PathVariable String milk){
		
		model.addAttribute("milkvalue", milk);
		return "/url/aa";		
	}
	
	
}
