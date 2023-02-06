package com.diallodeveloper.studentmngmt.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
public interface ApiStudent {

    @GetMapping
    List<Student> getStudents();

    @PostMapping
    void addStudent(@RequestBody Student student);

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable("id") Long id);
}
