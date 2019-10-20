package jobfinder.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends javax.naming.AuthenticationException {

	private static final long serialVersionUID = -1333259278840258293L;
	private HttpStatus httpStatus;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(HttpStatus httpStatus, String errorMessage) {
		super(errorMessage);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "AuthenticationException [httpStatus=" + httpStatus + ", resolvedName=" + resolvedName + ", resolvedObj="
				+ resolvedObj + ", remainingName=" + remainingName + ", rootException=" + rootException + "]";
	}

}
