package org.spring.ks.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String, Object>> getlist(Map<String, Object> paramMap);
	Map<String, Object> getListData(Map<String, Object> paramMap);
	
	Map<String, Object> getDetail(Map<String, Object> paramMap);
	Map<String, Object> getNext(Map<String, Object> paramMap);
	Map<String, Object> getPrev(Map<String, Object> paramMap);
	int addHit(Map<String, Object> paramMap);
	int boardUpdate(Map<String, Object> paramMap);
	int boardDelete(Map<String, Object> paramMap);
	int boardInsert(Map<String, Object> paramMap);
}
