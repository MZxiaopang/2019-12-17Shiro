package com.zhiyou;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.model.User;

public class MainClass {
	@Test
	public void add() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		User user = new User(88, "tt", "tt", 888);
		session.insert("suibianqiaode.asda.add", user);
		// 会自动开启事务 在这里进行提交
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void update() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		session.insert("suibianqiaode.asda.update", new User(88, "pp", "pp", 99));
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void delete() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		// 根据读取的配置文件获得一个数据库会话工厂
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		// 根据工厂获得数据库会话（数据库连接）（会开启事务）
		SqlSession session = sf.openSession();
		session.insert("suibianqiaode.asda.delete", 88);
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

		List<User> list = session.selectList("suibianqiaode.asda.selectAll");

		// 提交事务
		session.commit();
		session.close();
		reader.close();

		for (User user : list) {
			System.out.println(user);
		}
	}
}
