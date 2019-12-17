package com.zhiyou;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class MainClass2 {

	@Test
	public void shiro() {
		String username="admin";//假装用户输入的账号
		String password="123";//假装用户输入的密码
		// 1：加载realm配置文件  用来初始化securityManagerFactory
		Factory<org.apache.shiro.mgt.SecurityManager> factory= new IniSecurityManagerFactory("classpath:realm2.ini");
		// 通过工厂获得securityManager对象
		SecurityManager sm = factory.getInstance();
		//3：将securityManager放到当前的运行环境中
		SecurityUtils.setSecurityManager(sm);
		// 4:通过securityUtils获得subject 对象
		 Subject subject = SecurityUtils.getSubject();
		 
		// 5：根据用户的登录信息常见一个 token令牌
		 UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 6：通过subject 进行登录
		 try {
			 subject.login(token);
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			System.out.println("账号错误");
		}catch (IncorrectCredentialsException e) {
			// TODO: handle exception
			System.out.println("密码错误");
		}
		 
		 //7：用户是否认证成功
		 boolean authenticated=subject.isAuthenticated();
		 System.out.println("用户是否认证成功:"+authenticated);
		 // 判断用户是否具有某个角色
		 boolean hasRole = subject.hasRole("超级管理员");
		 System.out.println("用户是否是超级管理员："+hasRole);
		 
		 // 判断用户是否具有多个角色
		 boolean hasAllRoles = subject.hasAllRoles(Arrays.asList("普通用户","管理员"));
		 System.out.println("用户是否是普通用户，管理员"+hasAllRoles);
		 
		 // 判断用户是否具有某个权限
		 boolean permitted = subject.isPermitted("user:select");
		 System.out.println("用户具有user:select权限:" +permitted);
		 // 判断用户是否具有多个权限
		 boolean permittedAll = subject.isPermittedAll("user:select","user:add","user:update","user:delete");
		 System.out.println("用户具有user:select,user:add，user:update,user:delete权限:"+permittedAll);
		 //退出
		 subject.logout();
		 // 判断是否认证成功
		 boolean authenticated2 = subject.isAuthenticated();
		 System.out.println("退出后，用户是否认证成功："+authenticated2);
		 

	
	
	}
}
