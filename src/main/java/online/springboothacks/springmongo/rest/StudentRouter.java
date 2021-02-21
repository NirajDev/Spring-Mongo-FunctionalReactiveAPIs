package online.springboothacks.springmongo.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import online.springboothacks.springmongo.service.StudentHandler;

@Configuration
public class StudentRouter {

	@Bean
	public RouterFunction<ServerResponse> studentRoutes(StudentHandler studentHandler) {
		return RouterFunctions
				.route(GET("/students").and(accept(MediaType.APPLICATION_JSON)), studentHandler::getAllStudents)
				.andRoute(POST("/student").and(accept(MediaType.APPLICATION_JSON)), studentHandler::createStudent)
				.andRoute(DELETE("/student/{id}").and(accept(MediaType.APPLICATION_JSON)),studentHandler::deleteStudent)
				.andRoute(GET("/student/{id}").and(accept(MediaType.APPLICATION_JSON)), studentHandler::getStudentById)
				.andRoute(PUT("/student").and(accept(MediaType.APPLICATION_JSON)), studentHandler::updateStudent);
	}
}
