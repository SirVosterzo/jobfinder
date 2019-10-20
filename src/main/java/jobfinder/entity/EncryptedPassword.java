package jobfinder.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class EncryptedPassword implements Serializable {

	private static final long serialVersionUID = -476247509710548449L;
	private String key;
	private String salt;

	public EncryptedPassword(String key, String salt) {
		super();
		this.key = key;
		this.salt = salt;
	}
}
