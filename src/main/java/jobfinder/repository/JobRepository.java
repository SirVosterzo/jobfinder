package jobfinder.repository;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {

}
