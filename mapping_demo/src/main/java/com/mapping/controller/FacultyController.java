package com.mapping.controller;

import com.mapping.entity.Faculty;
import com.mapping.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // for listing all the students
    @GetMapping("/students")
    public List<Faculty> getAllFaculties() {
        return facultyService.findAllFaculties();
    }

    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty) {

        return facultyService.saveFaculty(faculty);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable(value = "id") Long id) {
        return facultyService.findFacultyById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> deleteStudent(@PathVariable(value = "id") Long id) {
        return facultyService.deleteFaculty(id);
    }
}
