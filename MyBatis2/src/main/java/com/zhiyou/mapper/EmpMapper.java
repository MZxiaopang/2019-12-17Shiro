package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.zhiyou.model.Emp;

public interface EmpMapper {

	void add(Emp Emp); // 方法名保持对应mapper中的id一致

	@Insert("insert into emp values(null,#{ENAME},#{JOB},#{MGR},#{HIREDATE},#{SAL},#{COMM},#{dept.DEPTION});")
	void add2(Emp Emp);

	void update(Emp Emp);// 参数与mapper中的parameterType一致

	void delete(int id);

	List<Emp> selectAll();// 查询中的返回值与mapper中的resultType一致

	Emp selectById(int id);
}
