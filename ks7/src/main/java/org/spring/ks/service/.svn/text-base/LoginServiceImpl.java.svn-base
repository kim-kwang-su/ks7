package org.spring.ks.service;

import java.util.List;
import java.util.Map;

import org.spring.ks.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Map<String, Object> userLogin(Map<String, Object> paramMap) {
		return loginDao.uesrLogin(paramMap); 
	}

}
