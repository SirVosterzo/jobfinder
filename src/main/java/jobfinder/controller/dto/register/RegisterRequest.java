package jobfinder.controller.dto.register;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterRequest implements Serializable {

	private static final long serialVersionUID = -2976136566068774558L;

	@NotNull(message = "Username cannot be null")
	@NotBlank(message = "Username cannot be blank")
	private String username;

	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	private String password;

	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be blank")
	private String name;

	@NotNull(message = "surname cannot be null")
	@NotBlank(message = "surname cannot be blank")
	private String surname;

	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String email;

	@NotNull(message = "birthday cannot be null")
	@NotBlank(message = "birthday cannot be blank")
	private String birthday;

	@NotNull(message = "gender cannot be null")
	@NotBlank(message = "gender cannot be blank")
	private String gender;

}
