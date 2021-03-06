package dev.ouno.sparklab.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SparkConfig {
	
	@Value("${app.name:jigsaw}")
	private String appName;

	@Value("${spark.home}")
	private String sparkHome;

	@Value("${master.uri:local}")
	private String masterUri;

	@Bean
	public SparkConf sparkConf() {
		SparkConf sparkConf = new SparkConf()
				.setAppName(appName)
				.setSparkHome(sparkHome)
				.setMaster(masterUri);

		return sparkConf;
	}

	@Bean
	public JavaSparkContext javaSparkContext() {
		return new JavaSparkContext(sparkConf());
	}

	@Bean
	public SparkSession sparkSession() {
		return SparkSession.builder()
				.sparkContext(javaSparkContext().sc())
				.appName("Java Spark example")
				.getOrCreate();
	}
}
