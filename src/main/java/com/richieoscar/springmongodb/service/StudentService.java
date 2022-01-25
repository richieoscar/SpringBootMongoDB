package com.richieoscar.springmongodb.service;

import com.richieoscar.springmongodb.exceptions.StudentNotFoundException;
import com.richieoscar.springmongodb.model.Gender;
import com.richieoscar.springmongodb.model.Student;
import com.richieoscar.springmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentByEmail(String email) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else throw new StudentNotFoundException();
    }

    public Student findStudentById(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else throw new StudentNotFoundException();
    }

    public List<Student> getStudentsByGender(Gender gender) {
        return studentRepository.findStudentsByGenderEquals(gender);
    }

    public Student addStudent(Student student) {
        try {
            return studentRepository.insert(student);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
