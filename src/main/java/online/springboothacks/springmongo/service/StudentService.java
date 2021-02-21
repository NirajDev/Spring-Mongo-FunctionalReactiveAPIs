package online.springboothacks.springmongo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.springboothacks.springmongo.model.Student;
import online.springboothacks.springmongo.repository.StudentRepository;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Mono<List<Student>> getAllStudents() {
		return studentRepository.findAll().collect(Collectors.toList());
	}

	public Mono<Student> save(Student student) {
		return studentRepository.save(student);
	}

	public Mono<Void> deleteStudent(UUID studentId) {

		return studentRepository.deleteById(studentId);
	}

	public Mono<Student> update(Student student) {
		return studentRepository.save(student);
	}

	public Mono<Student> getStudentById(UUID studentId) {

		return studentRepository.findById(studentId);
	}

}
