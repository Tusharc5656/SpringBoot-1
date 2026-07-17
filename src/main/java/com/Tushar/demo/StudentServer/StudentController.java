package com.Tushar.demo.StudentServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository repository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository repository) {
        this.studentService = studentService;
        this.repository = repository;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student) {
        Student result = studentService.studentValidate(student);

        if(result == null)
        {
            return ResponseEntity.status(400).body(result);
        }
        return  ResponseEntity.status(201).body(result);
    }

    @PostMapping("/student")
    public Student saveStudent() {
        Student student = new Student(1, "Tushar", 25);
        return repository.save(student);
    }

    @GetMapping("/students")
    public Iterable<Student> getStudents() {
        return repository.findAll();
    }
}