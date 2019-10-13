package jobfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import jobfinder.model.Job;

@Service
public class JobService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Job> getJobs() {
		return mongoTemplate.findAll(Job.class);
	}

}
