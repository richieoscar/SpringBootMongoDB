package com.richieoscar.springmongodb.repository;

import com.richieoscar.springmongodb.model.Gender;
import com.richieoscar.springmongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmail(String email);

    List<Student> findStudentsByGenderEquals(Gender gender);
}
