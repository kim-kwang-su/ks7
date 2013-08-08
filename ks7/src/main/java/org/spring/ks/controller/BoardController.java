package org.spring.ks.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.spring.ks.service.BoardService;
import org.spring.ks.view.FileDownloadView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {	
	
	Logger logger = Logger.getLogger(getClass());
	
	@Value("#{config['board.savedpath']}")
	private String save_path;
	
	
	@Autowired
	private FileDownloadView fileDownloadView;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/List.html", method=RequestMethod.GET)	
	public String boardList(
			@RequestParam(value="page", defaultValue="1") int page
			,Model model ){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		
		List<Map<String, Object>> list = boardService.getlist(paramMap);		
		model.addAttribute("list", list);
		
		
		return "/board/boardList";
	}
	
	@RequestMapping(value="/View.html", method=RequestMethod.GET)
	public String boardView(@RequestParam(value="seq") String seq, Model model){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seq", seq);
		
		boardService.addHit(paramMap);
		
		Map<String, Object> listData = boardService.getListData(paramMap);
		model.addAttribute("detail",listData.get("detail"));
		model.addAttribute("next",listData.get("next"));
		model.addAttribute("prev",listData.get("prev"));
		
		/*
		Map<String, Object> next = boardService.getNext(paramMap);
		Map<String, Object> prev = boardService.getPrev(paramMap);		
		Map<String, Object> detail = boardService.getDetail(paramMap);
		
		model.addAttribute("detail", detail);
		model.addAttribute("next", next);
		model.addAttribute("prev", prev);
		*/
		
		return "/board/boardDetail";
	}
	
	@RequestMapping(value="/Update.html", method=RequestMethod.GET)
	public String boardUpdateForm(@RequestParam(value = "seq") String seq ,Model model){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seq", seq);
		
		Map<String, Object> detail = boardService.getDetail(paramMap);
		model.addAttribute("detail", detail);
		
		return "/board/boardUpdate";
	}	
	
	@RequestMapping(value="/Update.html", method=RequestMethod.POST)
	public String boardUpdateAction(
			@RequestParam(value = "seq") String seq,
			@RequestParam(value = "writer") String writer,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content
			){		
		
		int isSuccess = -1;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seq", seq);
		paramMap.put("writer", writer);
		paramMap.put("title", title);
		paramMap.put("content", content);
		
		
		isSuccess = boardService.boardUpdate(paramMap);
		if(isSuccess > 0){
			return "redirect:View.html?seq="+seq;	
		}else{
			System.out.println("ERROR");
			return "redirect:List.html";
		}
	}
	
	@RequestMapping(value="/Delete.html", method=RequestMethod.GET)
	public String DeleteAction(@RequestParam(value = "seq") String seq){
		
		int isSuccess = -1;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seq", seq);
		
		isSuccess = boardService.boardDelete(paramMap);
		if(isSuccess > 0){
			return "redirect:List.html"; 
		}else{
			System.out.println("ERROR");			
			return null;
		}			
	}
	
	@RequestMapping(value="/Write.html", method=RequestMethod.GET)
	public String WriterFrom(){
		
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/Write.html", method=RequestMethod.POST)
	public String WriterAction(
			@RequestParam(value="writer") String writer , 
			@RequestParam(value="title") String title , 
			@RequestParam(value="content") String content ,
			@RequestParam(value="upfile" , required = false) MultipartFile upfile
			) throws Exception {
		
		int isSuccess = -1;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("writer", writer);
		paramMap.put("title", title);
		paramMap.put("content", content);
		
		if(upfile != null && !upfile.isEmpty()){
			String originalFilename = upfile.getOriginalFilename();
			String newFilename = System.currentTimeMillis() + "_" + originalFilename;			
			long filesize = upfile.getSize();
			String contentType = upfile.getContentType();
			
			FileCopyUtils.copy(upfile.getInputStream(), new FileOutputStream(new File(save_path , newFilename)));			
			
			paramMap.put("newFilename", newFilename);
		}
		
		isSuccess = boardService.boardInsert(paramMap);
		
		if(isSuccess > 0){
			return "redirect:List.html"; 
		}else{
			System.out.println("ERROR");			
			return null;
		} 
	}
	
	@RequestMapping(value = "/Download_file.html", method=RequestMethod.GET)
	public ModelAndView download_file(@RequestParam(value = "seq") int seq){
		
		logger.debug("["+getClass().getSimpleName()+"] [download_file] start");
		logger.info("["+getClass().getSimpleName()+"] [download_file] seq["+seq+"]");
		
		ModelAndView mav = new ModelAndView();
		mav.setView(fileDownloadView);
		
		try{
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("seq", seq);
			
			Map<String, Object> listData = boardService.getListData(paramMap);			
			Map<String, Object> getData = (Map<String, Object>) listData.get("detail");
			String filename = (String)getData.get("FILENAME");
			
			mav.addObject("downloadFile" , new File(save_path , filename));
			mav.addObject("isTimeIncluded", true);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("["+getClass().getSimpleName()+"] [downolad_file] seq["+seq+"] 파일 다운로드 중 오류 발생");
		}finally{
			logger.debug("["+getClass().getSimpleName()+"] [down_issuefile] end");
		}
		
		return mav;
	}
	
}
