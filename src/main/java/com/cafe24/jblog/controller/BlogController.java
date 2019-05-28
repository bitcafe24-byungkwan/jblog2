package com.cafe24.jblog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BlogController {
	
	@ResponseBody
	@RequestMapping(value = {"/{idx:[\\d]+}"}, method = RequestMethod.GET)
	public String list(@PathVariable Long idx) {
		return idx.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = {"/{idx:[\\w]+}/{idx2:[\\\\d]+}"}, method = RequestMethod.GET)
	public String list2(@PathVariable String idx,@PathVariable Long idx2) {
		return idx + "###########" + idx2.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = {"/{id:[\\w]+}/admin/basic"}, method = RequestMethod.GET)
	public String blogMain(@PathVariable String id) {
		
		return "###########";
	}


	@RequestMapping(value = {"/{id:[\\w]+}/admin/basic","/{id:[\\w]+}/admin"}, method = RequestMethod.GET)
	public String adminBasic(@PathVariable String id) {
		
		return "blog/blog-admin-basic";
	}
	
	@ResponseBody
	@RequestMapping(value = {"/{id:[\\w]+}/admin/category"}, method = RequestMethod.GET)
	public String blogCat(@PathVariable String id) {
		
		return "###########";
	}
	
	@ResponseBody
	@RequestMapping(value = {"/{id:[\\w]+}/admin/write"}, method = RequestMethod.GET)
	public String blogWrite(@PathVariable String id) {
		
		return "###########";
	}
}
