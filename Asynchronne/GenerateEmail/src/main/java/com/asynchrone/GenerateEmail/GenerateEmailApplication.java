package com.asynchrone.GenerateEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;

@SpringBootApplication
public class GenerateEmailApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenerateEmailApplication.class, args);
	}

}
