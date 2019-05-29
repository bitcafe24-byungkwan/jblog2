package com.cafe24.jblog.controller;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.security.CheckValid;
import com.cafe24.security.CheckValid.Role;




@Controller
public class BlogController {
	@Autowired BlogService blogService;
	
	@CheckValid(role=Role.EXIST )
	@RequestMapping(value = {"/{idx:[\\w]+}"} ,method = RequestMethod.GET)
	public String list(@PathVariable String idx) {
		return "blog/blog-main";
	}
	
	@CheckValid(role=Role.EXIST )
	@ResponseBody
	@RequestMapping(value = {"/{idx:[\\w]+}/{idx2:[\\d]+}"},method = RequestMethod.GET)
	public String list2(@PathVariable String idx,@PathVariable Long idx2) {
		return idx + "###########" + idx2.toString();
	}
	
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{id:[\\w]+}/admin/basic","/{id:[\\w]+}/admin"},method = RequestMethod.GET)
	public String adminBasic(@PathVariable String id) {
		
		return "blog/blog-admin-basic";
	}
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{id:[\\w]+}/admin/category"},method = RequestMethod.GET)
	public String blogCat(@PathVariable String id, Model model) {
		List<CategoryVo> lists = blogService.getCategoryList(id);

		model.addAttribute("categoryList", lists);
		
		return "blog/blog-admin-category";
	}
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{id:[\\w]+}/admin/category"},method = RequestMethod.POST)
	public String addCat(@PathVariable String id, String name, String description) {		
		blogService.addCategory(id,name,description);
		return String.format("redirect:/%s/admin/category", id);
	}
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{usrId:[\\w]+}/admin/category/delete/{catIdx:[\\d]+}"},method = RequestMethod.GET)
	public String delCat(@PathVariable String usrId, @PathVariable Long catIdx) {		
		blogService.delete(usrId, catIdx);
		
		return String.format("redirect:/%s/admin/category", usrId);
	}
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{id:[\\w]+}/admin/write"},method = RequestMethod.GET)
	public String blogWrite(@PathVariable String id) {
		
		return "blog/blog-admin-write";
	}
}
