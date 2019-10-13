package jobfinder.entity;

public class EncryptedPassword {

	private String key;
	private String salt;

	public EncryptedPassword(String key, String salt) {
		super();
		this.key = key;
		this.salt = salt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "EncryptedPassword [key=" + key + ", salt=" + salt + "]";
	}

}
