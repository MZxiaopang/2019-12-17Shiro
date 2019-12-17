package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Authorty;

public interface AuthortyDao {

	//根据用户的角色ID  得到 其所有的权限
	List<Authorty> selectByRoleId(int roleId);
}
