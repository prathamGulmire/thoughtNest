package com.prathGul.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
//@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(JournalApplication.class, args);
		System.out.println("Application is running in environment: " + context.getEnvironment().getActiveProfiles()[0]);
	}

//	@Bean
//	public PlatformTransactionManager falana(MongoDatabaseFactory dbFactory) {
//		return new MongoTransactionManager(dbFactory);
//	}
}

//PlatformTransactionManager -> It is a interface
//MongoTransactionManager -> It is implementation of PlatformTransactionManager. This manages the transaction
//MongoDatabaseFactory -> It is a interface and helps ton connect with a mongo database.