package com.mapping.service;

import com.mapping.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();

    public ResponseEntity<Student> findStudentById(Long id);

    public Student saveStudent(Student student);

    public ResponseEntity<Student> deleteStudent(Long id);

    public Student updateStudent(Long id, Student newStudent);

}
