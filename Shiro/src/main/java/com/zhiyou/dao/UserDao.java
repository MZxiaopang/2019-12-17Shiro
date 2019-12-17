package com.zhiyou.dao;

import com.zhiyou.model.Usr;

public interface UserDao {

	//根据用户名查询用户是否存在
	Usr selectByName(String name);
	
	
	
}
