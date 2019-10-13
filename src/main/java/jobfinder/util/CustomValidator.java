package jobfinder.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import jobfinder.controller.dto.login.LoginRequest;
import jobfinder.controller.dto.register.RegisterRequest;

public class CustomValidator {

	private CustomValidator() {
		throw new IllegalStateException("Utility class");
	}

	public static void validate(LoginRequest loginRequest) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<LoginRequest>> violations = validator.validate(loginRequest);
		if (!violations.isEmpty()) {
			throw new ValidationException(violations.iterator().next().getMessage());
		}
	}

	public static void validate(RegisterRequest request) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RegisterRequest>> violations = validator.validate(request);
		if (!violations.isEmpty()) {
			throw new ValidationException(violations.iterator().next().getMessage());
		}
	}

}
