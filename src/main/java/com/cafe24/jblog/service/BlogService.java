package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

@Service
public class BlogService {
	
	@Autowired CategoryDao categoryDao;
	
	public Boolean addCategory(String id, String catName, String desc) {
		CategoryVo vo = new CategoryVo();
		vo.setUserId(id);
		vo.setName(catName);
		vo.setDescription(desc);
		return categoryDao.insert(vo);
	}

	public List<CategoryVo> getCategoryList(String userId) {
		
		List<CategoryVo> result = categoryDao.getList(userId);

		return result;		
	}

	public Boolean delete(String userId, Long catIdx) {
		CategoryVo vo = new CategoryVo();
		vo.setUserId(userId);
		vo.setId(catIdx);
		
		return categoryDao.delete(vo);
	}
}
