package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;



@Service
public class UserService {
	@Autowired UserDao userDao;
	
	public UserVo getUser(UserVo userVo) {
		return userDao.get(userVo.getId(),userVo.getPassword());
	}
	
	//@Transactional
	public Boolean join(UserVo userVo) {
		return userDao.insert(userVo);		
	}
}
