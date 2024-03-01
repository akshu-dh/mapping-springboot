package com.mapping.service;

import com.mapping.entity.College;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CollegeService {

    public List<College> findAllColleges();

    public ResponseEntity<College> findCollegeById(Long id);

    public College saveCollege(College college);

    public ResponseEntity<College> deleteCollege(Long id);

    public College updateCollege(Long id, College newCollege);

}
