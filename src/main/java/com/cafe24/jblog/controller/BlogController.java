package com.cafe24.jblog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.security.CheckValid;
import com.cafe24.security.CheckValid.Role;




@Controller
public class BlogController {
	
	@CheckValid(role=Role.EXIST )
	@RequestMapping(value = {"/{idx:[\\w]+}"}, method = RequestMethod.GET)
	public String list(@PathVariable String idx) {
		return "blog/blog-main";
	}
	
	@CheckValid(role=Role.EXIST )
	@ResponseBody
	@RequestMapping(value = {"/{idx:[\\w]+}/{idx2:[\\d]+}"}, method = RequestMethod.GET)
	public String list2(@PathVariable String idx,@PathVariable Long idx2) {
		return idx + "###########" + idx2.toString();
	}
	
	
	@CheckValid(role=Role.ADMIN )
	@RequestMapping(value = {"/{id:[\\w]+}/admin/basic","/{id:[\\w]+}/admin"}, method = RequestMethod.GET)
	public String adminBasic(@PathVariable String id) {
		
		return "blog/blog-admin-basic";
	}
	
	@CheckValid(role=Role.ADMIN )
	@ResponseBody
	@RequestMapping(value = {"/{id:[\\w]+}/admin/category"}, method = RequestMethod.GET)
	public String blogCat(@PathVariable String id) {
		
		return "blog/blog-admin-category";
	}
	
	@CheckValid(role=Role.ADMIN )
	@ResponseBody
	@RequestMapping(value = {"/{id:[\\w]+}/admin/write"}, method = RequestMethod.GET)
	public String blogWrite(@PathVariable String id) {
		
		return "blog/blog-admin-write";
	}
}
