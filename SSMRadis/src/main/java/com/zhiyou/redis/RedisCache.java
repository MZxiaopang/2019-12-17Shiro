package com.zhiyou.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.zhiyou.model.Emp;

public class RedisCache implements Cache{

	//声明一个id 通过构造方法赋值
	private final String id;
	//创建一个单例的读写锁对象
	private static ReadWriteLock rw=new ReentrantReadWriteLock();
	//创建一个redis连接工厂对象
	private static JedisConnectionFactory jedisConnectionFactory;
	

	

	public RedisCache(final String id) {
		
		this.id=id;
	}
	
	public String getId() {
		
		return this.id;
	}
	//将数据存到redis中
	public void putObject(Object key, Object value) {
		//开写锁
		rw.writeLock().lock();
		//通过工厂获得redis连接
		RedisConnection con=jedisConnectionFactory.getConnection();
		// 获得序列化对象,用来将存入的对象进行序列化
		RedisSerializer<Object> rs=new JdkSerializationRedisSerializer();
		//序列化key value 的同时将其存入到redis
		con.set(rs.serialize(key), rs.serialize(value));
		System.out.println("--------------------添加mybatis二级缓存成功key:"+key);
		//关闭连接
		con.close();
		//释放锁
		rw.writeLock().unlock();
		
	}

	public Object getObject(Object key) {
		//开读锁
		rw.readLock().lock();
		//通过工厂获得redis连接
		RedisConnection con=jedisConnectionFactory.getConnection();
		// 获得序列化对象,用来将存入的对象进行序列化
		RedisSerializer<Object> rs=new JdkSerializationRedisSerializer();
		//序列化key然后根据key从redis中取值,并且对value 进行反序列化 让其变成对象
		Object object = rs.deserialize(con.get(rs.serialize(key)));
		System.out.println("-------------------------------命中二进制缓存成功  value："+object);
		con.close();
		rw.readLock().unlock();
		return object;
	}

	public Object removeObject(Object key) {
		//开写锁
		rw.writeLock().lock();
		//通过工厂获得redis连接
		RedisConnection con=jedisConnectionFactory.getConnection();
		// 获得序列化对象,用来将存入的对象进行序列化
		RedisSerializer<Object> rs=new JdkSerializationRedisSerializer();
		//让key的生命变成0
		Boolean expire = con.expire(rs.serialize(key), 0);
		con.close();
		rw.writeLock().unlock();
		return expire;
	}

	public void clear() {
		//开读锁
		rw.readLock().lock();
		//通过工厂获得redis连接
		RedisConnection con=jedisConnectionFactory.getConnection();
		con.flushDb();
		con.flushAll();
		con.close();
		rw.readLock().unlock();
	}

	public int getSize() {
		//通过工厂获得redis连接
		RedisConnection con=jedisConnectionFactory.getConnection();
		Integer size = Integer.valueOf(con.dbSize().toString());
		return size;
	}

	public ReadWriteLock getReadWriteLock() {
		
		return rw;
	}
	
	
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCache.jedisConnectionFactory = jedisConnectionFactory;
	}
	

}
