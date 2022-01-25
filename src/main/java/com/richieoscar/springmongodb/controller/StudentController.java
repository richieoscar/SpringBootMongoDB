package com.richieoscar.springmongodb.controller;

import com.richieoscar.springmongodb.exceptions.StudentNotFoundException;
import com.richieoscar.springmongodb.model.Student;
import com.richieoscar.springmongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student findStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping("/student/{email}")
    public Student getStudentByEmail(@PathVariable("email")String email){
       return studentService.findStudentByEmail(email);

    }
}
