package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Emp;
import com.zhiyou.service.EmpService;

@Controller
public class EmpController {


	@Autowired
	EmpService service;
	@RequestMapping("show")
	public String show(HttpServletRequest req,HttpServletResponse res) {
		String page = req.getParameter("page")==null?"1":req.getParameter("page");
		
		PageHelper.startPage(Integer.valueOf(page), 2);
		
		List<Emp> list = service.selectEmps();
		
		PageInfo<Emp> p=new PageInfo<Emp>(list);
		
		req.setAttribute("p", p);
		req.setAttribute("emps", list);
		return "show";
	}
	@RequestMapping("add")
	public String add(Emp emp,HttpServletRequest req,HttpServletResponse res) {
		service.add(emp);
		return "redirect:show";
	}
	@RequestMapping("update")
	public String update(Emp emp,HttpServletRequest req,HttpServletResponse res) {
		service.update(emp);
		return "redirect:show";
	}
	@RequestMapping("selectById")
	public String selectById(Integer id,HttpServletRequest req,HttpServletResponse res) {
		System.out.println(service.selectById(id));
		req.setAttribute("emp", service.selectById(id));
		return "update";
	}
	@RequestMapping("delete")
	public String delete(Integer empno,HttpServletRequest req,HttpServletResponse res) {
		service.delete(empno);
		return "redirect:show";
	}
}
