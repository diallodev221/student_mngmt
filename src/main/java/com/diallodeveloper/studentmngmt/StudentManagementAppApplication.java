package com.diallodeveloper.studentmngmt;

import com.diallodeveloper.studentmngmt.student.Gender;
import com.diallodeveloper.studentmngmt.student.Student;
import com.diallodeveloper.studentmngmt.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementAppApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			Student student = Student.builder()
					.name("Souleymane Faye")
					.email("souley@email.com")
					.gender(Gender.MALE)
					.build();

			Student student2 = Student.builder()
					.name("Fatou Diallo")
					.email("fatou@email.com")
					.gender(Gender.FEMALE)
					.build();

			Student student3 = Student.builder()
					.name("Jean Coly")
					.email("jean@email.com")
					.gender(Gender.MALE)
					.build();

			studentRepository.save(student);
			studentRepository.save(student2);
			studentRepository.save(student3);
		};
	}
}
