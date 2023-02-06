package com.diallodeveloper.studentmngmt.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class StudentController implements ApiStudent{

    private final StudentService studentService;

    @Override
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentService.deleteStudent(id);
    }
}
