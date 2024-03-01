package com.mapping.service.impl;

import com.mapping.entity.College;
import com.mapping.repository.CollegeRepository;
import com.mapping.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public List<College> findAllColleges() {

        return collegeRepository.findAll();
    }

    @Override
    public ResponseEntity<College> findCollegeById(Long id) {
        Optional<College> college = collegeRepository.findById(id);
        if (college.isPresent()) {
            return ResponseEntity.ok().body(college.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public College saveCollege(College college) {

        return collegeRepository.save(college);
    }

    @Override
    public ResponseEntity<College> deleteCollege(Long id) {
        Optional<College> college = collegeRepository.findById(id);
        if (college.isPresent()) {
            collegeRepository.deleteById(id);
            return ResponseEntity.ok().body(college.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public College updateCollege(Long id, College newCollege) {
        Optional<College> college = collegeRepository.findById(id);
        return college.map(data -> {
            data.setC_name(newCollege.getC_name());
            return collegeRepository.save(data);
        }).orElseGet(() -> {
            newCollege.setC_id(id);
            return collegeRepository.save(newCollege);
        });

    }
}
