package com.agan.springboot.controller;

import com.agan.springboot.model.Student;
import com.agan.springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    ResponseEntity<String> addStudent(@RequestBody @Valid Student student) {
        studentService.save(student);
        return ResponseEntity.ok("Student saved !");
    }

}
