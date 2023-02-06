package com.diallodeveloper.studentmngmt.student;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/students")
public interface ApiStudent {

    @GetMapping
    List<Student> getStudents();

    @PostMapping
    void addStudent(@Valid @RequestBody Student student);

    @PutMapping
    void updateStudent(@RequestBody Student student);

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable("id") Long studentId);
}
