package com.zhiyou;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;

public class MainClass2 {

	@Test
	public void add() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		User user = new User(110, "tt", "tt", 888);
		// 通过反射 和 动态代理，给我们的接口创建了一个代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		System.out.println(mapper);
		// 由于代理对象中存在sqlsession ，所以可以进行数据库的查询
		mapper.add(user);
//		mapper.update(new User(90, "卡三等奖", "爱死机读卡爱丽丝", 0));
//		List<User> list = mapper.selectAll();
//		for (User user2 : list) {
//			System.out.println(user2);
//		}
		// 会自动开启事务 在这里进行提交
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void select() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		User user = new User(90, "tt", "tt", 888);
		// 通过反射 和 动态代理，给我们的接口创建了一个代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.select(new User(0, null, null, 1));
		for (User user2 : list) {
			System.out.println(user2);
		}
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void deleteAll() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int[] a = new int[] { 88, 89, 90 };
		mapper.deleteAll(a);
		session.commit();
		session.close();
		reader.close();
	}
}
