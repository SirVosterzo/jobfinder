package jobfinder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Configuration
@Component("mongoConfig")
@EnableMongoRepositories(basePackages = "jobfinder.repository")
public class MongoConfig {

	@Value("${mongoDB.config.host}")
	private String host;
	@Value("${mongoDB.config.database}")
	private String databaseName;

	@Bean
	public MongoClient mongo() {
		return new MongoClient(host);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongo(), databaseName);
	}
}
