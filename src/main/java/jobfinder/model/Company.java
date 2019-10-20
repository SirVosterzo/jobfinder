package jobfinder.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Company implements Serializable {

	private static final long serialVersionUID = 6142573224938323005L;

	private String name;
	private String rating;

}
