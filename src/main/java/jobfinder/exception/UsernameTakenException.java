package jobfinder.exception;

public class UsernameTakenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1290861867534839590L;
	private final String errorMessage;

	public UsernameTakenException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		return "UsernameTakenException [errorMessage=" + errorMessage + "]";
	}

}
