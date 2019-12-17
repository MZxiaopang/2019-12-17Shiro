package com.zhiyou.dao;

import com.zhiyou.model.Role;

public interface RoleDao {

	//根据用户的角色ID得到其角色名称
	Role selectRoleByRoleId(String username);
}
