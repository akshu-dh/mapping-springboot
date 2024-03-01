package com.mapping.service;

import com.mapping.entity.Faculty;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FacultyService {

    public List<Faculty> findAllFaculties();

    public ResponseEntity<Faculty> findFacultyById(Long id);

    public Faculty saveFaculty(Faculty faculty);

    public ResponseEntity<Faculty> deleteFaculty(Long id);

    public Faculty updateFaculty(Long id, Faculty newFaculty);
}
