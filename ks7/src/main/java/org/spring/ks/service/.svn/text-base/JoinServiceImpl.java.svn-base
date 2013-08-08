package org.spring.ks.service;

import java.util.Map;

import org.spring.ks.dao.JoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService{
	@Autowired
	private JoinDao joinDao;
	
	@Override
	public int memberInsert(Map<String, Object> paramMap) {	
		return joinDao.memberInsert(paramMap);
	}
}
