package jobfinder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import jobfinder.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
