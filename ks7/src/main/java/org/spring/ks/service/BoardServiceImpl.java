package org.spring.ks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.spring.ks.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private BoardDao boardDao;	
	
	@Override
	public List<Map<String, Object>> getlist(Map<String, Object> paramMap) {		
		return boardDao.getlist(paramMap);
	}
	
	@Override
	public Map<String, Object> getDetail(Map<String, Object> paramMap) {		
		return boardDao.getDetail(paramMap);
	}
	
	@Override
	public int addHit(Map<String, Object> paramMap) {
		return boardDao.addHit(paramMap);
	}
	
	@Override
	public Map<String, Object> getPrev(Map<String, Object> paramMap) {
		return boardDao.getPrev(paramMap);
	}
	
	@Override
	public Map<String, Object> getNext(Map<String, Object> paramMap) {
		return boardDao.getNext(paramMap);
	}
	
	@Override
	public int boardUpdate(Map<String, Object> paramMap) {
		return boardDao.boardUpdate(paramMap);
	}
	
	@Override
	public int boardDelete(Map<String, Object> paramMap) {		
		return boardDao.boardDelete(paramMap);
	}
	
	@Override
	public int boardInsert(Map<String, Object> paramMap) {
		return boardDao.boardInsert(paramMap);
	}

	@Override
	public Map<String, Object> getListData(Map<String, Object> paramMap) {
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		Map<String,Object> detail = boardDao.getDetail(paramMap);
		Map<String,Object> next = boardDao.getNext(paramMap);
		Map<String,Object> prev = boardDao.getPrev(paramMap);
		
		resultData.put("detail", detail);		
		resultData.put("next", next);		
		resultData.put("prev", prev);		
		
		return resultData;
	}
	
}
