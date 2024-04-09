package com.agan.springboot.controller;

import com.agan.springboot.entity.Student;
import com.agan.springboot.exception.StudentNotFoundException;
import com.agan.springboot.exception.StudentNotNullException;
import com.agan.springboot.repository.StudentRepository;
import com.agan.springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student) {
        if ((student.getFirstName().isEmpty() || student.getFirstName().isBlank()) ||
        (student.getLastName().isEmpty() || student.getLastName().isBlank())) {
            throw new StudentNotNullException("Student name and surname must be not null");
        }
        Student addStudent = studentService.addStudent(student);
        return new ResponseEntity<Student>(addStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.findAllStudents();

        if (studentList.isEmpty()) {
            throw new StudentNotFoundException("Student list is empty");
        }

        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.orElseThrow(() -> new StudentNotFoundException("Student id: " + id));

        return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        optionalStudent.orElseThrow(() -> new StudentNotFoundException("Student id: " + id + " do not delete!"));

        studentService.deleteStudentById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
