package jobfinder.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.http.HttpStatus;

import jobfinder.exception.AuthenticationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordUtil {

	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 512;
	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

	private PasswordUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Optional<String> generateSalt(final int length) {

		if (length < 1) {
			log.error("error in generateSalt: length must be > 0");
			return Optional.empty();
		}

		byte[] salt = new byte[length];
		RAND.nextBytes(salt);

		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}

	public static Optional<String> hashPassword(String password, String salt) {

		char[] chars = password.toCharArray();
		byte[] bytes = salt.getBytes();

		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

		Arrays.fill(chars, Character.MIN_VALUE);

		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] securePassword = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(securePassword));

		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			log.error("Exception encountered in hashPassword(): {}", ex.getMessage());
			return Optional.empty();

		} finally {
			spec.clearPassword();
		}
	}

	public static void verifyPassword(String password, String key, String salt) throws AuthenticationException {
		Optional<String> optEncrypted = hashPassword(password, salt);
		if (!optEncrypted.isPresent() || !optEncrypted.get().equals(key)) {
			throw new AuthenticationException(HttpStatus.BAD_REQUEST, "Password is incorrect.");
		}
		log.debug("[INFO ] Password is correct.");
	}

}
