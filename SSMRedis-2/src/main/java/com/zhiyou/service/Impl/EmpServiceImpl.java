package com.zhiyou.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

	/**
	 * Spring  会将Value当成key在redis中创建一个集合,集合中的value 就是我们指定在查询的的key,时候
	 * 会先找到keys中有没有对应的value
	 */
	// 清除 key 是selectALL 的集合
	@CacheEvict(value = "selectAll",key = "#root.target.selectall()",allEntries = true)
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		System.err.println(111);
		mapper.deleteByPrimaryKey(id);
	}
	
	public void update(Emp emp) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(emp);
	}
	@Cacheable(value = "selectAll",key = "#root.target.selectall()")//添加一个key  selectAll的集合
	public List<Emp> selectEmps() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}

	public Emp selectById(Integer id) {
		// TODO Auto-generated method stub
		return  mapper.selectByPrimaryKey(id);
	}
	
	public String selectall() {
		return "haha";
	}
	
}
