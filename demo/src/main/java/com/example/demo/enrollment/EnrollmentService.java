package com.example.demo.enrollment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EnrollmentService {
    private EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) { this.repo = repo; }

    public List<Enrollment> list() {
        return this.repo.findAll();
    }

    public Enrollment get(Long Id) {
        return this.repo.findById(Id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enrollment not found.")
        );
    }

    public Enrollment post(Enrollment enrollment) {
        return this.repo.save(enrollment);
    }

    public Enrollment update(Long Id, Enrollment patch) {
        Enrollment enrollment = get(Id);
        
        if (patch.getCourseId() != null) { enrollment.setCourseId(patch.getCourseId()); }
        if (patch.getEnrollmenDate() != null) { enrollment.setEnrollmenDate(patch.getEnrollmenDate()); }
        if (patch.getStudentId() != null) { enrollment.setStudentId(patch.getStudentId()); }
        if (patch.getGrade() != null) { enrollment.setGrade(patch.getGrade()); }
        return this.repo.save(enrollment);
    }

    public void delete(Long Id) {
        this.repo.deleteById(Id);
    }
}