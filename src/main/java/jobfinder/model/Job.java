package jobfinder.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Job implements Serializable {

	private static final long serialVersionUID = 8533673812111767492L;

	@Id
	private String id;
	private String title;
	private String description;
	private Company company;

}
