package org.spring.ks.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EventService {
	List<Map<String, Object>> getLoveList(Map<String, Object> paramMap);
	int eventLoveInsert(Map<String, Object> paramMap); 
}
