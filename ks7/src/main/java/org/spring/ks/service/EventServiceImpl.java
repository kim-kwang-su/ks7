package org.spring.ks.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.spring.ks.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private EventDao eventDao;
	
	@Override
	public List<Map<String, Object>> getLoveList(Map<String, Object> paramMap) {	
		return eventDao.getLoveList(paramMap);
	}
	
	public int eventLoveInsert(Map<String, Object> paramMap){
		return eventDao.eventLoveInsert(paramMap);
	}
}
