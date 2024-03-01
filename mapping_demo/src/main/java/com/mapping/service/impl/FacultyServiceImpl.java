package com.mapping.service.impl;

import com.mapping.entity.Faculty;
import com.mapping.repository.FacultyRepository;
import com.mapping.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAllFaculties() {

        return facultyRepository.findAll();
    }

    @Override
    public ResponseEntity<Faculty> findFacultyById(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if (faculty.isPresent()) {
            return ResponseEntity.ok().body(faculty.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {

        return facultyRepository.save(faculty);
    }

    @Override
    public ResponseEntity<Faculty> deleteFaculty(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if (faculty.isPresent()) {
            facultyRepository.deleteById(id);
            return ResponseEntity.ok().body(faculty.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty newFaculty) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.map(data -> {
            data.setF_name(newFaculty.getF_name());
            return facultyRepository.save(data);
        }).orElseGet(() -> {
            newFaculty.setF_id(id);
            return facultyRepository.save(newFaculty);
        });

    }

}
