package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Usr;

public interface UserDao {

	//根据用户名查询用户是否存在
	Usr selectByName(String name);
	
	List<Usr> selectAll();
	
}
