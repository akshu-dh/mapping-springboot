package com.mapping.controller;

import com.mapping.entity.Student;
import com.mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //for listing all the students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentService.saveStudent(student);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value="id")Long id){
        return studentService.findStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateUser(@PathVariable(value="id") long id,@RequestBody Student newStudent) {
        return studentService.updateStudent(id, newStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long id) {
        return studentService.deleteStudent(id);
    }
}
