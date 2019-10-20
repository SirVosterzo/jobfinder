package jobfinder.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jobfinder.entity.EncryptedPassword;
import jobfinder.exception.AuthenticationException;
import jobfinder.exception.EncryptionException;
import jobfinder.exception.UsernameTakenException;
import jobfinder.model.User;
import jobfinder.repository.UserRepository;
import jobfinder.util.Constants;
import jobfinder.util.DateUtil;
import jobfinder.util.PasswordUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;

	public void logout(HttpServletRequest request) {
		log.debug("[SESS ] Logout.");
		request.getSession().removeAttribute(Constants.USER);
	}

	public User authenticate(String username, String password) throws AuthenticationException {
		log.debug("[START] Authenticating user: {}", username);
		User user = this.findUser(username);
		PasswordUtil.verifyPassword(password, user.getPassword(), user.getSalt());
		log.debug("[END  ] User {} authenticated.", username);
		log.debug("[SESS ] Login.");
		return user;
	}

	public void register(User user) throws UsernameTakenException, EncryptionException {
		if (!found(user)) {
			log.debug("[START] Registering user: {}", user.getUsername());
			EncryptedPassword password = this.encryptPassword(user.getPassword());
			user.setSalt(password.getSalt());
			user.setPassword(password.getKey());
			user.setSubscriptionDate(DateUtil.toISO(new DateTime()));
			this.mongoInsert(user);
			log.debug("[END  ] User {} registered.", user.getUsername());
		} else {
			throw new UsernameTakenException("Username taken.");
		}
	}

	private User findUser(String username) throws AuthenticationException {
		Query query = new Query(Criteria.where(Constants.USERNAME).is(username));
		User user = mongoTemplate.findOne(query, User.class);
		log.debug("[MONGO] Found user: {}", user);
		if (user.getId() == null) {
			log.error("[MONGO] User not found.");
			throw new AuthenticationException(HttpStatus.NOT_FOUND, "User not found.");
		}
		return user;
	}

	private boolean found(User user) {
		Query query = new Query(Criteria.where(Constants.USERNAME).is(user.getUsername()));
		User foundUser = mongoTemplate.findOne(query, User.class);
		return foundUser != null;
	}

	private EncryptedPassword encryptPassword(String password) throws EncryptionException {
		String salt = generateSalt();
		String key = hashPassword(password, salt);
		return new EncryptedPassword(key, salt);
	}

	private String generateSalt() throws EncryptionException {
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

	private void mongoInsert(User user) throws UsernameTakenException {
		if (userRepository.insert(user) == null) {
			throw new UsernameTakenException("Username taken.");
		}
		log.debug("[MONGO] User inserted in Database. {}", user);
	}

}
