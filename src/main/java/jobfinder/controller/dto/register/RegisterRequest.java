package jobfinder.controller.dto.register;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2976136566068774558L;

	@NotNull(message = "Username cannot be null")
	@NotBlank(message = "Username cannot be blank")
	private String username;

	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RegisterRequest [username=" + username + ", password=" + password + "]";
	}

}
