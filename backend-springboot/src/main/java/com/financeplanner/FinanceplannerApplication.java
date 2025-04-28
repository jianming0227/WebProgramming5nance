package com.financeplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FinanceplannerApplication {

    private static final Logger logger = LoggerFactory.getLogger(FinanceplannerApplication.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(FinanceplannerApplication.class, args);
    }

    @PostConstruct
    public void checkDatabaseConnection() {
        try {
            // Check if the connection is successful and log the name of the database
            String dbName = mongoTemplate.getDb().getName();
            logger.info("Successfully connected to MongoDB database: {}", dbName);
        } catch (Exception e) {
            logger.error("Failed to connect to MongoDB", e);
        }
    }
}
