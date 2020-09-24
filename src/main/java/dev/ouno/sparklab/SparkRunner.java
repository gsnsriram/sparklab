package dev.ouno.sparklab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EnableBatchProcessing
public class SparkRunner {
	private static final Logger LOG = LoggerFactory.getLogger(SparkRunner.class);
	
	public static void main(String[] args) {
		LOG.info("Running Spark Runner");
		SpringApplication.run(SparkRunner.class, args);
	}
}
