package jobfinder.service;

import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import jobfinder.entity.EncryptedPassword;
import jobfinder.exception.EncryptionException;
import jobfinder.exception.UsernameTakenException;
import jobfinder.model.User;
import jobfinder.repository.UserRepository;
import jobfinder.util.Constants;
import jobfinder.util.PasswordUtil;

@Service
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;

	public User authenticate(String username, String password) throws AuthenticationException {
		User user = this.findUser(username);
		PasswordUtil.verifyPassword(password, user.getPassword(), user.getSalt());
		return user;
	}

	public void register(User user) throws UsernameTakenException, EncryptionException {
		if (!found(user)) {
			EncryptedPassword password = this.encryptPassword(user.getPassword());
			user.setSalt(password.getSalt());
			user.setPassword(password.getKey());
			this.mongoInsert(user);
		} else {
			throw new UsernameTakenException("Username taken.");
		}
	}

	private boolean found(User user) {
		Query query = new Query(Criteria.where(Constants.USERNAME).is(user.getUsername()));
		User foundUser = mongoTemplate.findOne(query, User.class);
		return foundUser != null;
	}

	private String getSalt() throws EncryptionException {
		Optional<String> salt = PasswordUtil.generateSalt(512);
		if (!salt.isPresent()) {
			throw new EncryptionException("Can't generate salt");
		}
		return salt.get();
	}

	private String hashPassword(String password, String salt) throws EncryptionException {
		Optional<String> hashedPw = PasswordUtil.hashPassword(password, salt);
		if (!hashedPw.isPresent()) {
			throw new EncryptionException("Can't hash password");
		}
		return hashedPw.get();
	}

	private User findUser(String username) throws AuthenticationException {
		Query query = new Query(Criteria.where(Constants.USERNAME).is(username));
		User user = mongoTemplate.findOne(query, User.class);
		if (user.getId() == null) {
			throw new AuthenticationException("User not found.");
		}
		return user;
	}

	private EncryptedPassword encryptPassword(String password) throws EncryptionException {
		String salt = getSalt();
		String key = hashPassword(password, salt);
		return new EncryptedPassword(key, salt);
	}

	private void mongoInsert(User user) throws UsernameTakenException {
		if (userRepository.insert(user) == null) {
			throw new UsernameTakenException("Username taken.");
		}
	}

}
