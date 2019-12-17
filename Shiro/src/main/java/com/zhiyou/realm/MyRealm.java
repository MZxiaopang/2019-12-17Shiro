package com.zhiyou.realm;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zhiyou.dao.AuthortyDao;
import com.zhiyou.dao.RoleDao;
import com.zhiyou.dao.UserDao;
import com.zhiyou.model.Authorty;
import com.zhiyou.model.Role;
import com.zhiyou.model.Usr;

import sun.misc.Resource;

/**
 * 自定义的realm  在这里进行认证及授权信息的封装
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm{

	/**
	 * 授权的方法
	 * PrincipalCollection   是一个身份集合 里面可以存储很多身份信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SqlSessionFactory sf=null;
		try {
			sf=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("MyBatisConf.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSession sql = sf.openSession();
		RoleDao roleDao = sql.getMapper(RoleDao.class);
		AuthortyDao authortyDao = sql.getMapper(AuthortyDao.class);
		//查新出来角色名称
		Role role = roleDao.selectByRoleId((String)principals.getPrimaryPrincipal());
		SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
		//封装角色信息
		info.addRole(role.getRoleName());
		// 查询出用户权限
		List<Authorty> list = authortyDao.selectByRoleId(role.getRoleId());
		//由于权限有可能有多个  所以循环添加
		for (Authorty authorty : list) {
			info.addStringPermission(authorty.getAuthorty());
		}
		return info;
	}

	/**
	 * 认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1：取出用户信息
		String name =(String) token.getPrincipal();
		SqlSessionFactory sf=null;
		try {
			sf=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("MyBatisConf.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSession sql = sf.openSession();
		UserDao dao = sql.getMapper(UserDao.class);
		Usr usr = dao.selectByName(name);
		sql.close();
		if (usr==null) {
			return null;
		}
		// 执行到这里就索明亮用户肯定存在  将用户信息封装 并且指定授权使用的realm 然后返回
		SimpleAuthenticationInfo inif=new SimpleAuthenticationInfo(usr.getUsername(),usr.getPassword(),"myRealm");
		return inif;
	}

}
