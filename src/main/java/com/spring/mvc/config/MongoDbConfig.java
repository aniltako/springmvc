package com.spring.mvc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = {"com.spring.mvc.api.domain"})
@EnableMongoAuditing
public class MongoDbConfig extends AbstractMongoConfiguration {

	private @Value("${dbURL.mongo}") String url;
	private @Value("${dbPort.mongo}") int port;
	private @Value("${dbUser.mongo}") String user;
	private @Value("${dbPassword.mongo}") String password;
	private @Value("${dbName.mongo}") String dbName;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoCredential credential = MongoCredential.createCredential(user,
				dbName, password.toCharArray());
		ServerAddress serverAddress = new ServerAddress(url, port);
		MongoClient mongoClient = new MongoClient(serverAddress,
				Arrays.asList(credential));
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
				mongoClient, dbName);
		return simpleMongoDbFactory;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(url, port);
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.spring.mvc.api.domain*";
	}
}
