package jobfinder.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User implements Serializable {

	private static final long serialVersionUID = -546506787957632882L;

	@Id
	private String id;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String birthday;
	private String gender;
	private String subscriptionDate;

}
