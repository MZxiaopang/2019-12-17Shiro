package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Dept;

public interface DeptMapper {

	void add(Dept Dept); // 方法名保持对应mapper中的id一致

	void update(Dept Dept);// 参数与mapper中的parameterType一致

	void delete(int id);

	List<Dept> selectAll();// 查询中的返回值与mapper中的resultType一致

	Dept selectById(int id);

//	Dept selectByNameAndByLoc(String name, String local);
//	Dept selectByNameAndByLoc(Map<String, String> map);
	Dept selectByNameAndByLoc(@Param("dname") String name, @Param("locc") String local);

	List<Dept> selectAllOrderBy(@Param("n") String n);

}
