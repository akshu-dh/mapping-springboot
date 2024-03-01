package com.mapping.service.impl;

import com.mapping.entity.Student;
import com.mapping.repository.StudentRepository;
import com.mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> findStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok().body(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public ResponseEntity<Student> deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().body(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(data -> {
            data.setS_name(newStudent.getS_name());
            return studentRepository.save(data);
        }).orElseGet(() -> {
            newStudent.setS_id(id);
            return studentRepository.save(newStudent);
        });

    }

}
