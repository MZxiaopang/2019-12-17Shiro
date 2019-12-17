package com.zhiyou;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.mapper.DeptMapper;
import com.zhiyou.mapper.EmpMapper;
import com.zhiyou.model.Dept;
import com.zhiyou.model.Emp;

public class MainClass {

	@Test
	public void add() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）

		SqlSession session = sf.openSession();
		Emp emp = new Emp(null, "张三", "前端工程师", null, new Date(), null, null, 11000, null);
		Dept dept = new Dept(null, "开发部", "月球");

		emp.setDept(dept);
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
//		deptMapper.add(dept);
//		empMapper.add(emp);

//		empMapper.delete(42);
//		deptMapper.delete(42);

		Emp emp2 = empMapper.selectById(7839);
		System.out.println(emp2.getDept());

//		empMapper.selectAll();

		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void dept() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		SqlSession session2 = sf.openSession();
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		DeptMapper deptMapper2 = session2.getMapper(DeptMapper.class);

		System.out.println(deptMapper.selectById(10));
		session.close();
		System.out.println(deptMapper2.selectById(10));
		session2.close();

		session.close();
		reader.close();
	}

	@Test
	public void dept2() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("dname", "开发部");
		map.put("local", "月球");
		// deptMapper.selectByNameAndByLoc(map);

		session.close();
		reader.close();
	}

	@Test
	public void dept3() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		deptMapper.selectByNameAndByLoc("开发部", "月球");
		deptMapper.selectAllOrderBy("sal");
		session.close();
		reader.close();
	}

}
