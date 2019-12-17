package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Emp;

public interface EmpService {

	void add(Emp emp);
	void delete(Integer id);
	void update(Emp emp);
	List<Emp> selectEmps();
	Emp selectById(Integer id);
}
