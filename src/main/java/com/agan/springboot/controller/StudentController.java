package com.agan.springboot.controller;

import com.agan.springboot.entity.Student;
import com.agan.springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student) {
        Student addStudent = studentService.addStudent(student);
        return new ResponseEntity<Student>(addStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.findAllStudents();
        return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student studentGetById = studentService.getStudentById(id);
        return new ResponseEntity<Student>(studentGetById, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
