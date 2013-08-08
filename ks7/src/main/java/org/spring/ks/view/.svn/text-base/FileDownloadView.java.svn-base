package org.spring.ks.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.AbstractView;


public class FileDownloadView extends AbstractView {
	Logger logger = Logger.getLogger(getClass());
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		File file = (File) model.get("downloadFile");
		if(file != null && file.exists()){
			response.setContentType(getContentType());
			response.setContentLength((int) file.length());
			String fileName = null;
			
			//시간정보가 포함된 파일명인지 여부를 확인한다.
			boolean isTimeIncluded = (Boolean)model.get("isTimeIncluded");
			if(isTimeIncluded){
				fileName = file.getName().substring(14);
			}else{
				fileName = file.getName();
			}
			
			fileName = URLEncoder.encode(fileName, "utf-8");
			
			if(model.containsKey("isPdfView") && (Boolean)model.get("isPdfView")){
				setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline");
			}else{
				setContentType("application/octet-stream; charset=utf-8");
				response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\";");
				response.setHeader("Content-Transfer-Encoding", "binary");
			}
			
			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			
			try{
				fis = new FileInputStream(file);
				IOUtils.copy(fis, out);
			}finally{
				if(fis != null) try{ fis.close(); } catch(IOException ex){}
			}
			
			logger.info("["+getClass().getSimpleName()+"] [renderMergedOutputModel] end");
					
		}
	}
}
