package online.springboothacks.springmongo.model;


import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student_details")
public class Student {

	private UUID id = UUID.randomUUID();
	private String name;
	private String college;
}
