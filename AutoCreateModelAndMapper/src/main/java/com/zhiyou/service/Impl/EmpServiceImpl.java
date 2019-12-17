package com.zhiyou.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.EmpMapper;
import com.zhiyou.model.Emp;
import com.zhiyou.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper mapper;

	public void add(Emp emp) {
		// TODO Auto-generated method stub
		mapper.insert(emp);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

	public void update(Emp emp) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(emp);
	}

	public List<Emp> selectEmps() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}

	public Emp selectById(Integer id) {
		// TODO Auto-generated method stub
		return  mapper.selectByPrimaryKey(id);
	}
	
	
	
}
