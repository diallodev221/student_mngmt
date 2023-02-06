package com.diallodeveloper.studentmngmt.student;

import com.diallodeveloper.studentmngmt.student.exception.BadRequestException;
import com.diallodeveloper.studentmngmt.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        boolean existsEmail = studentRepository
                .existsByEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException("Student " + student.getEmail() + " taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id "+ id + " not exist");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.findStudentById(student.getId())
                .map(s -> {
                    s.setName(student.getName());
                    s.setEmail(student.getEmail());
                    s.setGender(student.getGender());
                    return s;
                }).orElseThrow(() -> new StudentNotFoundException("Student with id {} not found"));
    }
}
