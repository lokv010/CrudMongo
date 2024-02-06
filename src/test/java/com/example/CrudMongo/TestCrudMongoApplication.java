package com.example.CrudMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestCrudMongoApplication {



	public static void main(String[] args) {
		SpringApplication.from(CrudMongoApplication::main).with(TestCrudMongoApplication.class).run(args);
	}

}
