package online.springboothacks.springmongo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import online.springboothacks.springmongo.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student, UUID> {

}
