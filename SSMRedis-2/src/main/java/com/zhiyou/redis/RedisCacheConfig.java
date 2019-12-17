package com.zhiyou.redis;

import java.lang.reflect.Method;

import javax.crypto.KeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 缓存配置类
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration//用于定义配置类，标识在类上 标识这个类是一个配置文件
@EnableCaching//开启缓存管理功能的注解
public class RedisCacheConfig{

	private JedisConnectionFactory jedisConnectionFactory;
	private RedisTemplate<String, String> redisTemplate;
	private RedisCacheManager redisCacheManager;
	@Override
	public String toString() {
		return "RedisCacheConfig [jedisConnectionFactory=" + jedisConnectionFactory + ", redisTemplate=" + redisTemplate
				+ ", redisCacheManager=" + redisCacheManager + "]";
	}
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
			RedisCacheManager redisCacheManager) {
		super();
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}
	public RedisCacheConfig() {
		super();
	}
	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}
	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		this.jedisConnectionFactory = jedisConnectionFactory;
	}
	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}
	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}
	public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
		this.redisCacheManager = redisCacheManager;
	}
	
	
	

}
