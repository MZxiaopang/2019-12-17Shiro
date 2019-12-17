package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.dao.UserDao;

@Controller
public class UserController {

	
	@Autowired
	UserDao dao;
	
	@RequestMapping("login")
	public String login(String username,String password,HttpServletRequest req,HttpServletResponse res) {
		//根据用户的账号 密码  创建一个令牌 token
		UsernamePasswordToken token =new UsernamePasswordToken(username,password);
		// 获得subject对象
		Subject subject = SecurityUtils.getSubject();
		//登录
		try {
			 subject.login(token);
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			return "login";
		}catch (IncorrectCredentialsException e) {
			// TODO: handle exception
			return "login";
		}
		
		return "redirect:showUser";
	}
	@RequestMapping("showUser")
	public String showUser(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("users", dao.selectAll());
		
		return "show";
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("-------------------------------------------删除了");
		return "redirect:showUser";
	}
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("-------------------------------------------添加了");

		return "redirect:showUser";
	}
	
}
