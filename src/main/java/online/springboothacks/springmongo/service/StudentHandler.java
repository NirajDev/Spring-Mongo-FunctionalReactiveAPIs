package online.springboothacks.springmongo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import online.springboothacks.springmongo.model.Student;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {

	 static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
	 
	 
	   @Autowired
	    private StudentService studentService;
	       /**
	        * The handler to get all the available Students.
	        * @param serverRequest
	        * @return - all the Students info as part of ServerResponse
	        */
	       public Mono<ServerResponse> getAllStudents(ServerRequest serverRequest) {
	           return ServerResponse.ok()
	                   .contentType(MediaType.APPLICATION_JSON)
	                   .body(studentService.getAllStudents(), Student.class);
	       }
	       /**
	        * The handler to create a Student
	        * @param serverRequest
	        * @return - return the created Student as part of ServerResponse
	        */

	       public Mono<ServerResponse> createStudent(ServerRequest serverRequest) {
	           Mono<Student> StudentToSave = serverRequest.bodyToMono(Student.class);
	           return StudentToSave.flatMap(Student ->
	                   ServerResponse.ok()
	                           .contentType(MediaType.APPLICATION_JSON)
	                           .body(studentService.save(Student), Student.class));
	       }
	       /**
	        * The handler to delete a Student based on the Student id.
	        * @param serverRequest
	        * @return - return the deleted Student as part of ServerResponse
	        */
	       public Mono<ServerResponse> deleteStudent(ServerRequest serverRequest) {
	           String id = serverRequest.pathVariable("id");
	           Mono<Void> deleteItem = studentService.deleteStudent(UUID.fromString(id));
	           return ServerResponse.ok()
	                   .contentType(MediaType.APPLICATION_JSON)
	                   .body(deleteItem, Void.class);
	       }
	       /**
	        * The handler to get Student by Id.
	        * @param serverRequest
	        * @return - The updated Student as part of ServerResponse
	        */
	       
	       public Mono<ServerResponse> getStudentById(ServerRequest serverRequest) {
	           String id = serverRequest.pathVariable("id");
	           Mono<Student> student = studentService.getStudentById(UUID.fromString(id));
	           return ServerResponse.ok()
	                   .contentType(MediaType.APPLICATION_JSON)
	                   .body(student, Student.class);
	       }

	       /**
	        * The handler to update Student.
	        * @param serverRequest
	        * @return - The updated Student as part of ServerResponse
	        */

	       
	   public Mono<ServerResponse> updateStudent(ServerRequest serverRequest) {
           Mono<Student> StudentToSave = serverRequest.bodyToMono(Student.class);
           return StudentToSave.flatMap(Student ->
                   ServerResponse.ok()
                           .contentType(MediaType.APPLICATION_JSON)
                           .body(studentService.save(Student), Student.class));
       }

}
